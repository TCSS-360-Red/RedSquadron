import java.time.LocalDate;
import java.util.Scanner;
/**
 * A command line prototype to demo the Budget Balancer 3000. Extremely fragile, not
 * intended for extended use beyond a code showcase and bugtesting our backend objects.
 * 
 * @author Miguel ramos
 * @version Red.1
 * 
 */

public class CommandLineInterface {
    private Scanner in;
    private TaskList myTaskList;
    private String menuString = "\n[BUDGET BALANCER 2999]\na) - add a task to your budget\ns) - see all tasks in project\ne) - edit your header\nh) - history list";

    public CommandLineInterface(){
        in = new Scanner(System.in).useDelimiter("\n");
        myTaskList = new TaskList();
    }

    private char getInputCommand(){
        System.out.println("\nWhat would you like to do?");
        return in.next().charAt(0);
    }

    private void FormatHeader(Header theHeader){
        System.out.print("********************************************");
        System.out.print("\nPROJECT NAME: ");
        System.out.print(theHeader.getProjectName());
        System.out.print("\nBUDGET: ");
        System.out.print(theHeader.getProjectBudget());
        System.out.print("\nCURRENT SPENDING: ");
        System.out.print(theHeader.getCurrentSpending());
        System.out.print("\nDue Date: " + theHeader.getDueDate().toString());
        System.out.print("\nCurrent Date: " + theHeader.getCurrentDate().toString());
        System.out.print("\n********************************************");

    }

    private void FormatHistoryRecord(HistoryRecord theRecord){
        String RecordString = new String();
        RecordString += theRecord.getDateAndTime().toString();

        if(theRecord.getChangeType() == 0){
            RecordString += " [Task ADDED]: ";
            RecordString += theRecord.getTask().getTaskDescription();
            RecordString += "\n***************************************\n";
        }
        if(theRecord.getChangeType() == 1){
            RecordString += " [Task ADDED]: ";
            RecordString += theRecord.getTask().getTaskDescription();
            RecordString += "\n***************************************\n";
        }

        System.out.println(RecordString);

    }

    private void printHistory() {
        HistoryRecord [] history = myTaskList.getHistoryList();
        int size = history.length;
        if(size = 0){
            "Looks like you haven't done anything with your project!"
            return;
        }

        System.out.println("HISTORY\n**********************************");
        for(int i = 0; i < size; i++){
            FormatHistoryRecord(history[i]);
        }
        System.out.println("******************************");
    }

    private void QueryUserForTask(){
        System.out.print("\nDescribe your task: ");
        String tempDescriptor = new String();
        tempDescriptor = "";
        tempDescriptor = in.next();
        System.out.print("\nHow much do you think that's going to cost?");
        String Buffer = in.next();
        Float tempCost = Float.parseFloat(Buffer);

        if(tempDescriptor.isEmpty()){
            System.out.print("Somethings fucking up the String input");
        }
        else{
            System.out.print(tempDescriptor);
        }

        myTaskList.AddTask(tempDescriptor, tempCost);
    }

    private void FormatTaskList(){
        Task[]  myTasks = myTaskList.copyList();
        if(myTasks.length == 0){
            System.out.println("Looks like your're project is empty!");
            return;
        }

        System.out.println("+++++++++++TASKS+++++++++++\n");
        for(int i = 0; i < myTasks.length; i++){
            System.out.println ("[" + i +"] ");
            System.out.println(myTasks[i].getTaskDescription());
            System.out.print("                Cost: ");
            System.out.print(myTasks[i].getTaskCost());
            System.out.print("\n");
        }
        System.out.print("+++++++++++++++++++++++++++++\n");
    }

    private void HeaderAssignmentWizard(){
        String newProjectName;
        float newProjectBudget;
        LocalDate newProjectDueDate;

        System.out.print("Please enter a new name for your project: ");
        newProjectName = in.next();
        System.out.print("\nPlease enter a new budget for your project: ");
        String floatBuffer = in.next();
        newProjectBudget = Float.parseFloat(floatBuffer);
        System.out.print("Please enter a date in the following format [xxxx-xx-xx]: ");
        String dateBuffer = in.next();
        dateBuffer += "-";
        String DateTokens [] = dateBuffer.split("-");

        DateTokens[2] = DateTokens[2].substring(0,2);
        int year = Integer.parseInt(DateTokens[0]);
        int month = Integer.parseInt(DateTokens[1]);
        int day = Integer.parseInt(DateTokens[2]);
        newProjectDueDate = LocalDate.of(year, month, day);


        Header temp = new Header();
        temp.setProjectName(newProjectName);
        temp.setProjectBudget(newProjectBudget);
        temp.setDueDate(newProjectDueDate);

        myTaskList.AssignHeader(temp);
    }

    private boolean executeCommand(char theCommand) {
        if(theCommand == 'a') {
            QueryUserForTask();
            clearScreen();
            return false;
        }
        else if(theCommand == 's') {
            clearScreen();
            FormatTaskList();
            return false;
        }
        else if(theCommand == 'e'){
            HeaderAssignmentWizard();
            clearScreen();
            return false;
            }
        else if(theCommand == 'h'){
            printHistory();
            return false;

        }
        else {
            return true;
        }
    }

    private void clearScreen(){
        System.out.print("\033[H\033[2J"); //clears screen using ANSII code
    }

    public void run(){
        boolean isDone = false;
        while(!isDone){
            FormatHeader(myTaskList.getHeaderState());
            System.out.println(menuString);
            char nextCommand = getInputCommand();
            isDone = executeCommand(nextCommand);
        }
        in.close();
    }

    
}
