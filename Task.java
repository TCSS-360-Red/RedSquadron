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

    /**Instantiate a task with an associated cost, description, and identifier. */
    public Task (String theDescription, float theCost, int theID) {
        myTaskDescription = theDescription;
        myTaskCost = theCost;
        myIdentifier = theID;
    }
    /**Instantiate a copy of another Task.   */
    public Task(Task toCopy){
        myTaskDescription = toCopy.myTaskDescription;
        myTaskCost = toCopy.myTaskCost;
        myIdentifier = toCopy.myIdentifier;
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
    /**Formats data into a string. */
    public String toString(){
        String returnString = myTaskDescription;
        returnString += "        $";
        returnString += Float.toString(myTaskCost);

        return returnString;
    }

    
}
