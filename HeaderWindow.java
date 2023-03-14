import javax.swing.*;
import java.awt.*;

/**
 * A GUI class that displays the Header object's important details, including project name, budget, current spending, due date, and current date.
 * The HeaderWindow class depends on the Header class.
 * 
 * @author Jacky Fong
 * @version Red.1
 */

public class HeaderWindow extends JPanel {
    private Header myHeader;
    private JPanel panel;
    private JLabel myProjectNameLabel;
    private JLabel myBudgetLabel;
    private JLabel mySpendingLabel;
    private JLabel myDueDateLabel;
    private JLabel myCurrentDateLabel;

    /**Constructs a HeaderWindow object that displays the details of a given Header object.
     * 
     * @param theHeader The Header object to display information for.
     */
    public HeaderWindow(Header theHeader){
        myHeader = theHeader;

        //Create labels for each detail
        myProjectNameLabel = new JLabel("Project Name: " + myHeader.getProjectName());
        myBudgetLabel = new JLabel("Budget: $" + myHeader.getProjectBudget());
        mySpendingLabel = new JLabel("Current Spending: $" + myHeader.getCurrentSpending());
        myDueDateLabel = new JLabel("Due Date: " + myHeader.getDueDate());
        myCurrentDateLabel = new JLabel("Current Date: " + myHeader.getCurrentDate());

        //Add labels to the panel
        panel = new JPanel(new GridLayout(5, 1));
        panel.add(myProjectNameLabel);
        panel.add(myBudgetLabel);
        panel.add(mySpendingLabel);
        panel.add(myDueDateLabel);
        panel.add(myCurrentDateLabel);

        //Set size and make window visible
        setSize(300, 200);
        setVisible(true);
        //setContentPane(panel);
    }

    public JPanel getPanel() {
        return panel;
    }

    /**Updates the Header object that the window displays information for.
     * 
     * @param theHeader The new Header object to display information for.
     */
    public void updateHeader(Header theHeader){
        myHeader = theHeader;

        //Update labels with new details
        myProjectNameLabel.setText("Project Name: " + myHeader.getProjectName());
        myBudgetLabel.setText("Budget: $" + myHeader.getProjectBudget());
        mySpendingLabel.setText("Current Spending: $" + myHeader.getCurrentSpending());
        myDueDateLabel.setText("Due Date: " + myHeader.getDueDate());
        myCurrentDateLabel.setText("Current Date: " + myHeader.getCurrentDate());
    }
}
