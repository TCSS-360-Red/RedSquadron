import java.time.LocalDate;
import java.time.LocalDateTime;
/**A data abstraction of a change made to your project budget. Created for the Budget Balancer 3000.
 * Designed by Miguel Ramos, implementation by Ngou In Chu
 * 
 * @author Miguel Ramos
 * @author Ngou In Chu
 * @version Red 1
 * 
 */
public class HistoryRecord {
    private Task myTask;
    private LocalDateTime myDateAndTime;
    private int myChangeType;

    /**Change code for indicating this task was added to the project. */
    public static int TASK_ADDED = 0;
    /**Change code for indicating this task was removed fromm the project. */
    public static int TASK_REMOVED = 1;
    /**Change code for indicating this task was updated in the project. */
    public static int TASK_UPDATED = 2;

    /**This class does not have a default constructor. */
    private HistoryRecord(){}

    /**Instantiates a HistoryRecord with a Task, the date and time, and the type of change that occurred.
     * 
     * @author Miguel Ramos
     * @param theTask The Task which was changed.
     * @param theChangeType The change which occurred. 0 - Task added, 1 - Task Removed, 2 - Task Changed
     */
    public HistoryRecord(Task theTask, int theChangeType){
        myTask = new Task(theTask);
        myDateAndTime = LocalDateTime.now(); 
        myChangeType = theChangeType;
    }
    
    /**
     * Gets the task associated with this history record.
     */
    public Task getTask() {
        return myTask;
    }

    /**
     * Gets the date and time associated with this history record.
     */
    public LocalDateTime getDateAndTime() {
        return myDateAndTime;
    }

    /**
     * Gets the type of change associated with this history record.
     */
    public int getChangeType() {
        return  myChangeType;
    }
}
