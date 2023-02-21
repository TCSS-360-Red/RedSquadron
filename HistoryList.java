import java.util.ArrayList;
import java.util.List;

public class HistoryList {
    private List<String> history;

    public HistoryList() {
        history = new ArrayList<>();
    }

    public void addHistory(String taskDescription, float taskCost, int taskID) {
        String task = "Task ID " + taskID + ": " + taskDescription + " ($" + taskCost + ")";
        history.add(task);
    }

    public void displayHistory() {
        System.out.println("Task history:");
        for (String task : history) {
            System.out.println(task);
        }
    }

    // Method to display the task history
    //public void displayHistory() {
    //    myHistoryList.displayHistory();
    //}
}