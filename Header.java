public class Header {
    private String myProjectName;
    private float myProjectBudget;
    private float myCurrentSpending;
    private int myProjectDueDate;
    private int myCurrentDate;

    public Header(){
        myProjectName = "UNTITLED PROJECT";
        myProjectBudget = (float) 0.0;
        myCurrentSpending = (float) 0.0;
        myProjectDueDate = 0;
        myCurrentDate = 0;
    }

    public String getProjectName(){
        return myProjectName;
    }
    public float getProjectBudget(){
        return myProjectBudget;
    }
    public float getCurrentSpending(){
        return myCurrentSpending;
    }
    public int getDueDate(){
        return myProjectDueDate;
    }
    public int getCurrentDate(){
        return myCurrentDate;
    }

    
}
