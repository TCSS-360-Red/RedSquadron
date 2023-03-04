import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class HistoryList {
    private static final String FILENAME = "history.txt";

    public HistoryList() {
    }

    public void addHistory(String taskDescription, float taskCost, int taskIdentifier) { //Miguel: This writes to a file, which may be useful for File I/O
        try (FileWriter fw = new FileWriter(FILENAME, true);                     //but I think it would be more efficient to use a list.
             PrintWriter pw = new PrintWriter(fw)) {

            // Get the current date and time
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
            Date date = new Date();
            String dateString = formatter.format(date);

            // Write the header information
            Header header = TaskList.getHeaderState();
            pw.println("Project Name: " + header.getProjectName());
            pw.println("Project Budget: " + header.getProjectBudget());
            pw.println("Due Date: " + header.getDueDate());

            // Write the task information
            pw.println("Task Description: " + taskDescription);
            pw.println("Task Cost: " + taskCost);
            pw.println("Task Identifier: " + taskIdentifier);

            // Write the timestamp
            pw.println("Timestamp: " + dateString);

            pw.flush();

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void printHistory() {                                           //Miguel: This also prints to the console, which is not what the 
        try {                                                              //class is supposed to do. Instead of a printHistory() function, we need
            List<String> lines = Files.readAllLines(Paths.get(FILENAME));  //a getHistory function that returns an array of each historyRecord recorded.
            for (String line : lines) {                                   
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
