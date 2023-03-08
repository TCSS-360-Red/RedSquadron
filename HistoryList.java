import java.util.ArrayList;
import java.util.List;

/**
 * A list to store the history of tasks added to the TaskList.
 * Each history record contains the description, price, and identifier of the associated task.
 * Records are stored in the order they were added.
 * 
 * @author Ngou In Chu
 * @version Red 1
 */
public class HistoryList {
    public List<HistoryRecord> history;

    public HistoryList() {
        history = new ArrayList<HistoryRecord>();
    }

    /**
     * Add a new history record to the list.
     * 
     * @param theDescription a String description of the task
     * @param thePrice a Float to represent the associated cost of the Task
     * @param identifier an integer to represent the task's identifier in the TaskList
     */
    public void addHistory(Task theTask, int theChangeType) {
        HistoryRecord newRecord = new HistoryRecord(theTask, theChangeType);
        history.add(newRecord);
    }

    /**
     * Return an array of all history records stored in the list.
     * 
     * @return an array of HistoryRecord objects
     */
    public HistoryRecord[] getHistoryList() {
        HistoryRecord[] historyArray = new HistoryRecord[history.size()];
        history.toArray(historyArray);
        return historyArray;
    }

}
