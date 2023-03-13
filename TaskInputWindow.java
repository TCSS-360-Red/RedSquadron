import java.awt.BorderLayout;

import javax.swing.*;

public class TaskInputWindow{
    private  JFrame myWindow;
    private JTextArea myTaskDescriptionField;
    private JTextArea myTaskCostField;

    private String stringBuffer = "";
    private float floatBuffer = 0.0f;

    public TaskInputWindow(){
        myWindow = new JFrame("Add Task");
        myTaskDescriptionField = new JTextArea("Task Description:");
        myTaskCostField = new JTextArea("$");
    }

    public String getString(){
        return stringBuffer;
    }
    public float getFloat(){
        return floatBuffer;
    }

    public void getTaskInput(){
        JPanel myPanel = new JPanel();

        myPanel.add(new JLabel("Task Description"));
        myPanel.add(myTaskDescriptionField);

        myPanel.add(new JLabel("$"));
        myPanel.add(myTaskCostField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "Add a Task,", JOptionPane.OK_CANCEL_OPTION);
        if(result == JOptionPane.OK_OPTION){
            stringBuffer = myTaskDescriptionField.getText();
            floatBuffer = Float.parseFloat(myTaskCostField.getText());
        }

    }


    
}
