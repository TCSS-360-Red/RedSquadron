import java.util.ArrayList;
import java.util.List;

public class HistoryList {
    private List<String> history; //Miguel: A history record needs to also map a time it was created. 
                                  //suggestion: create a HistoryRecord data type with the task and the time of creation.

    public HistoryList() {
        history = new ArrayList<>();
    }

    public void addHistory(String taskDescription, float taskCost, int taskID) {
        String task = "Task ID " + taskID + ": " + taskDescription + " ($" + taskCost + ")";
        history.add(task);
    }

    public void displayHistory() {                  //Miguel: This will output to a console. Useful for bugtesting, but not for the final app
        System.out.println("Task history:");     //suggestion: create a function that will return a copy of your history list for the HistoryWindow
        for (String task : history) {
            System.out.println(task);
        }
    }

    // Method to display the task history
    //public void displayHistory() {
    //    myHistoryList.displayHistory();
    //}
}