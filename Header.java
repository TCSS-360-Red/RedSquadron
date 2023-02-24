import java.time.*;
/**A place to summarize all the important details about your project budget. Created for the Budget Balancer 3000
 * 
 * @author Miguel Ramos
 * @version Red.1
 * 
 */
public class Header {
    private String myProjectName;
    private float myProjectBudget;
    private float myCurrentSpending;
    private LocalDate myProjectDueDate; //a user defined date (probably need to change to LocalDate Object)
    private LocalDate myCurrentDate;

    public Header(){
        myProjectName = "UNTITLED PROJECT";
        myProjectBudget = (float) 0.0;
        myCurrentSpending = (float) 0.0;
        myProjectDueDate = 0;
        myCurrentDate = java.time.LocalDate.now();
    }

    /**Queury project name.
     * 
     * @return name of the project.
     */
    public String getProjectName(){
        return myProjectName;
    }
    /**
     * Queury project budget.
     * 
     * @return User-defined project budget
     */
    public float getProjectBudget(){
        return myProjectBudget;
    }
    /**Query combined cost of all tasks in the project.
     * 
     * @return a float representing the price of spending.
     */
    public float getCurrentSpending(){
        return myCurrentSpending;
    }
    /**Query user-defined due date of project.
     * 
     * @return A LocalDate object set to the user-defined due date of project.
     * 
     */
    public LocalDate getDueDate(){
        return myProjectDueDate;
    }
    /**Query the current Date.
     * 
     * @return A LocalDate object set to the current Date
     */
    public LocalDate getCurrentDate(){
        return myCurrentDate;
    }

    /**Set a name for the project.
     * 
     * @param theName A name for the Project.
     */
    public void setProjectName(String theName) {
        myProjectName = theName;
    }
    /**Set A Budget for the project.
     * 
     * @param theBudget
     */
    public void setProjectBudget(float theBudget) {
        myProjectBudget = theBudget;
    }
    /**Update the total spending of the project.
     * 
     * @param theSpending the new combined cost of all tasks in the project.
     */
    public void updateCurrentSpending(float theSpending) {
        myCurrentSpending = theSpending;
    }
    /**Set a Due Date for the project.
     * 
     * @param theDueDate User-defined due date for the project. Must be cast to a LocalDate object somehow.
     */
    public void setDueDate(LocalDate theDueDate) {
        myProjectDueDate = theDueDate;
    }
    /**Updates current time using the system's clock module.
     * 
     */
    public void updateCurrentDate(){
        myCurrentDate = java.time.LocalDate.now();
    }
    /**Creates a copy of the Header's current state.
     * 
     * @return A copy of the Header's current state.
     */
    public Header copy(){
        Header theCopy = new Header();

        theCopy.setProjectName(myProjectName);
        theCopy.setProjectBudget(myProjectBudget);
        theCopy.updateCurrentSpending(myCurrentSpending);
        theCopy.setDueDate(myProjectDueDate);
        theCopy.updateCurrentDate();

        return theCopy;
    }


    
}
