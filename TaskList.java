import java.util.List;
import java.util.*;
/**
 * A list to store tasks and associated behaviour. A skeleton for History/Header functionality has been created.
 * 
 * @author Miguel Ramos
 * @version Red.1
 * 
 */

public class TaskList {
    private List<Task> myTaskList;
    private HistoryList myHistoryList;
    private Header myHeader;
    private int IDENTIFIER_UPPER_BOUND = 9999;
    private int SIZE = 0;
   
    public TaskList(){
        myTaskList = new LinkedList<Task>();
        myHistoryList = new HistoryList();
        myHeader = new Header();
    };

    /**Adds a task to the List.
     * 
     * @param theDescription a String description of the task.
     * @param thePrice a Float to represent the associated cost of the Task.
     * 
     * @return On success, returns an integer you can use to find the task in the list (store this somewhere). Else, returns -1;
     */
    public int AddTask(String theDescription, float thePrice){
        if(SIZE != IDENTIFIER_UPPER_BOUND) {
            int identifier = SIZE;
            SIZE++;
            Task temp = new Task(theDescription, thePrice, identifier);
            myTaskList.add(temp);
            myHistoryList.addHistory(theDescription, thePrice, identifier);
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
    /**Get a copy of all tasks in list
     * 
     * @return an array representation of all tasks in the list.
     */
    public Task[] copyList(){
        return (Task[])myTaskList.toArray();
    }

    /**Get a copy of the Header in it's current state.
     * 
     * @return a copy of the Header in it's current state
     */
    public Header getHeaderState(){
        return myHeader.copy();
    }


}
