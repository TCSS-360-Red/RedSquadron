import javax.swing.*;
import java.time.LocalDate;

/**
 * Separate window for taking and storing information about a Header object.
 * Created for the Budget Balancer 3000.
 * 
 * This class allows the user to input a project name, budget, current spending,
 * project due date, and current date. If 'OK' is selected, the input is stored in
 * a Header object that can be retrieved using getHeader().
 * 
 * Author: Ngou In Chu
 * Version: Red.1
 */
public class HeaderInputWindow {
    private JTextField myProjectNameField;
    private JTextField myProjectBudgetField;
    private JTextField myCurrentSpendingField;
    private JTextField myProjectDueDateField;
    private LocalDate myProjectDueDate;
    private LocalDate myCurrentDate;

    private Header myHeader;

    /**
     * Initializes the input fields with default values.
     */
    public HeaderInputWindow() {
        myProjectNameField = new JTextField("Untitled Project");
        myProjectBudgetField = new JTextField("0.0");
        myCurrentSpendingField = new JTextField("0.0");
        myProjectDueDateField = new JTextField(LocalDate.now().toString());
        myProjectDueDate = LocalDate.now();
        myCurrentDate = LocalDate.now();
    }

    /**
     * Query the stored Header object.
     * 
     * @return the Header object created from the input.
     */
    public Header getHeader() {
        return myHeader;
    }

    /**
     * Creates and displays a window for receiving input from the user.
     */
    public void getHeaderInput() {
        JPanel myPanel = new JPanel();

        myPanel.add(new JLabel("Project Name: "));
        myPanel.add(myProjectNameField);

        myPanel.add(new JLabel("Project Budget: $"));
        myPanel.add(myProjectBudgetField);

        myPanel.add(new JLabel("Current Spending: $"));
        myPanel.add(myCurrentSpendingField);

        myPanel.add(new JLabel("Project Due Date: "));
        myPanel.add(myProjectDueDateField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "Enter Project Information", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String projectName = myProjectNameField.getText();
                float projectBudget = Float.parseFloat(myProjectBudgetField.getText());
                float currentSpending = Float.parseFloat(myCurrentSpendingField.getText());
                LocalDate projectDueDate = LocalDate.parse(myProjectDueDateField.getText());

                myHeader = new Header();
                myHeader.setProjectName(projectName);
                myHeader.setProjectBudget(projectBudget);
                myHeader.updateCurrentSpending(currentSpending);
                myHeader.setDueDate(projectDueDate);
                myHeader.updateCurrentDate();
            } catch (Exception e) {
                // DO NOTHING
            }
        } else {
            myHeader = null;
        }
    }
}
