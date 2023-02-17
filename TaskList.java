import java.util.List;
import java.util.*;
/**
 * A list to store tasks and associated behaviour. A skeleton for History functionality has been created.
 * 
 * @author Miguel Ramos
 * @version Red.1
 * 
 */

public class TaskList {
    private List<Task> myTaskList;
    //private HistoryList myHistoryList;
    private Random myRand;
    private int IDENTIFIER_UPPER_BOUND = 9999;
   
    public TaskList(){
        myTaskList = new LinkedList<Task> ();
        //myHistoryList = new LinkedList<HistoryRecord> ();
        myRand = new Random();
    }

    //public TaskList(HistoryList theHistoryList){}

    /**Adds a task to the List.
     * 
     * @param theDescription a String description of the task.
     * @param thePrice a Float to represent the associated cost of the Task.
     * 
     * @return On success, returns an integer you can use to find the task in the list (store this somewhere). Else, returns -1;
     */
    public int AddTask(String theDescription, float thePrice){
        if(IDENTIFIER_UPPER_BOUND != 0) {
            int identifier = myRand.nextInt(IDENTIFIER_UPPER_BOUND);
            IDENTIFIER_UPPER_BOUND--;
            Task temp = new Task(theDescription, thePrice, identifier);
            myTaskList.add(temp);
            return identifier;
        }
        return -1;
    }
    /**Query the number of Tasks in the list.
     * 
     * @return Number of tasks stored in the list.
     */
    public int numTasks(){
        int size = myTaskList.size();
        return size;
    }
    /**Query combined cost of all tasks in the list.
     * 
     * @return Combined cost of all tasks stored in list.
     */
    public float totalCost(){
        float priceTotal = (float) 0.0;
        Iterator<Task> myTaskLisIterator = myTaskList.iterator();

        while(myTaskLisIterator.hasNext()){
            priceTotal += myTaskLisIterator.next().getTaskCost();
        }
        return priceTotal;
    }


}
