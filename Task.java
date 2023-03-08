/**
 * Task is a data abstraction of a step towards completing a project. Created for the Budget Balancer 3000.
 * 
 * @author Miguel Ramos
 * @version Red.1
 */

public class Task {
    private String myTaskDescription;
    private float myTaskCost;
    private int myIdentifier;

    /* This class does not use a default constructor. */
    private Task(){};

    public Task(Task theTask){
        myTaskDescription = theTask.myTaskDescription;
        myTaskCost = theTask.myTaskCost;
        myIdentifier = theTask.myIdentifier;
    }

    /**Instantiate a task with an associated cost, description, and identifier. */
    public Task (String theDescription, float theCost, int theID) {
        myTaskDescription = theDescription;
        myTaskCost = theCost;
        myIdentifier = theID;
    }
    /**Returns a task's associated cost. */
    public float getTaskCost(){
        return myTaskCost;
    }
    /**Returns a tasks associated description. */
    public String getTaskDescription(){
        return myTaskDescription;
    }
    /**Compares Identifier fields. */
    public boolean compareID(int theID){
        return (theID == myIdentifier);
    
    }

    
}
