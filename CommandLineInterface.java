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
    private String menuString = "\n[BUDGET BALANCER 2999]\na) - add a task to your budget\ns) - see all tasks in project\ne) - edit your header\nh) - history list\nQ) - quit the program";

    public CommandLineInterface(){
        in = new Scanner(System.in).useDelimiter("\n");
        myTaskList = new TaskList();
    }

    private char getInputCommand(){
        System.out.println("\nWhat would you like to do?");
        return in.next().charAt(0);
    }
/** Formats the header to a readable string and outputs to the console.
 * 
 * @param theHeader The header of the project budget.
 */
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
/**Formats a singular HistoryRecord to a readable string, then outputs that string to the console.
 * 
 * @param theRecord The HistoryRecord object to be displayed.
 */
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
/**Uses FormatHistoryRecord() to output the entire history list to the console.*/
    private void printHistory() {
        clearScreen();
        HistoryRecord [] history = myTaskList.getHistoryList();
        int size = history.length;
        if(size == 0){
            System.out.println("Looks like you haven't done anything with your project yet!");
            return;
        }

        System.out.println("HISTORY\n**********************************");
        for(int i = 0; i < size; i++){
            FormatHistoryRecord(history[i]);
        }
        System.out.println("******************************");
    }
/**Prompts the user to enter information for a Task. Packs this user data into a Task object and stores it in the 
 * TaskList.*/
    private void QueryUserForTask(){
        System.out.print("\nDescribe your task: ");
        String tempDescriptor = new String();
        tempDescriptor = "";
        tempDescriptor = in.next();
        System.out.print("\nHow much do you think that's going to cost?");
        String Buffer = in.next();
        Float tempCost = Float.parseFloat(Buffer);

        if(tempDescriptor.isEmpty()){
            System.out.print("Somethings messing up the String input");
        }
        else{
            System.out.print(tempDescriptor);
        }

        myTaskList.AddTask(tempDescriptor, tempCost);
    }

    /**Iteratively formats tasks into readable strings and ouputs them to the console.*/
    private void FormatTaskList(){
        clearScreen();
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
/**Takes several fields from the user to define a new Header for their project. */
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
/**Executes the command passed to it.
 * 
 * @param theCommand The Command to execute. See menuString for a list of all implemented commands.
 * @return true if a valid input was received and executed, false if an invalid input was received.
 */
    private boolean executeCommand(char theCommand) {
        if(theCommand == 'a') {
            QueryUserForTask();
            clearScreen();
            return true;
        }
        else if(theCommand == 's') {
            clearScreen();
            FormatTaskList();
            return true;
        }
        else if(theCommand == 'e'){
            HeaderAssignmentWizard();
            clearScreen();
            return true;
            }
        else if(theCommand == 'h'){
            printHistory();
            return true;

        }
        else {
            return false;
        }
    }
/**Clears the screen using an esoteric ANSII code. An ancient type of computer magic, oft forgot.*/
    private void clearScreen(){
        System.out.print("\033[H\033[2J"); //clears screen using ANSII code
    }
/**Runs the client in a loop. */
    public void run(){
        boolean isDone = false;
        while(!isDone){
            FormatHeader(myTaskList.getHeaderState());
            System.out.println(menuString);
            char nextCommand = getInputCommand();
            boolean invalidCommand = true;
            if(nextCommand == 'Q'){
                invalidCommand = false;
                isDone = true;
            }
            while(invalidCommand) {
                if(executeCommand(nextCommand) == false) {
                    System.out.println("Unrecognized command. Please try again.");
                    nextCommand = getInputCommand();
                }
                else{
                    invalidCommand = false;
                }
            }
        }
        clearScreen();
        System.out.println("See you later!");
        in.close();
    }
}
