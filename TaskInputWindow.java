
import javax.swing.*;
/** Seperate window for taking and storing information about a task to be added to the Budget.
 * Created for the Budget Balancer 3000.
 * 
 * @author Miguel Ramos
 * @version Red.1
 */
public class TaskInputWindow{

    private JTextArea myTaskDescriptionField;
    private JTextArea myTaskCostField;

    private String stringBuffer = "";
    private float floatBuffer = 0.0f;

    /** Initializes the Input fields with placeholder text. */
    public TaskInputWindow(){
        myTaskDescriptionField = new JTextArea("[Task]");
        myTaskCostField = new JTextArea("[$]");
    }

    /**Query the stored input for the Task Description Field. */
    public String getString(){
        return stringBuffer;
    }
    /**Query the stored input for the Task cost field. */
    public float getFloat(){
        return floatBuffer;
    }
    /**Creates and displays a window for receiving input from the user. If 'OK' is selected, it stores this input
     * publicly and can be queried using getString() for the Task Description and getFloat() for the Task cost.
     * 
     * @author Miguel Ramos
     */
    public void getTaskInput(){
        JPanel myPanel = new JPanel();

        myPanel.add(new JLabel("Task Description"));
        myPanel.add(myTaskDescriptionField);

        myPanel.add(new JLabel("$"));
        myPanel.add(myTaskCostField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "Add a Task,", JOptionPane.OK_CANCEL_OPTION);
        if(result == JOptionPane.OK_OPTION){
            stringBuffer = myTaskDescriptionField.getText();
            try{
                floatBuffer = Float.parseFloat(myTaskCostField.getText());
            }
            catch(Exception e){
                    //DO NOTHING
            }
        }
        if(result == JOptionPane.CANCEL_OPTION){
            stringBuffer = "";
            floatBuffer = 0.0f;
        }

    }


    
}
