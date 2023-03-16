import javax.swing.*;
import java.time.LocalDate;

/**
 * Separate window for taking and storing information about a Header object.
 * Created for the Budget Balancer 3000.
 * 
 * This class allows the user to input a project name, budget, current spending,
 * project due date, and current date. If 'OK' is selected, the input is stored in
 * a Header object that can be retrieved using getHeader(). If 'OK' is not selected,
 * a default Header will be stored instead.
 * 
 * @author Ngou In Chu
 * @author Miguel Ramos
 * Version: Red.1
 */
public class HeaderInputWindow {
    private JTextField myProjectNameField;
    private JTextField myProjectBudgetField;
    private JTextField myProjectDueDateYear;
    private JTextField myProjectDueDateMonth;
    private JTextField myProjectDueDateDay;

    private static String DEFAULT_PROJECT_NAME = "Untitled Project";
    private static String DEFAULT_PROJECT_BUDGET = "0.0";
    private static String DEFAULT_PROJECT_YEAR = "Year [xxxx]";
    private static String DEFAULT_PROJECT_MONTH = "Month [xx: 1-12]";
    private static String DEFAULT_PROJECT_DAY = "Day [xx: 1-31]";

    private Header myHeader;

    /**
     * Initializes the input fields with default values.
     * @author Ngou In Chu
     * @author Miguel Ramos
     */
    public HeaderInputWindow() {
        myProjectNameField = new JTextField(DEFAULT_PROJECT_NAME);
        myProjectBudgetField = new JTextField(DEFAULT_PROJECT_BUDGET);
        myProjectDueDateYear = new JTextField(DEFAULT_PROJECT_YEAR);
        myProjectDueDateMonth = new JTextField(DEFAULT_PROJECT_MONTH);
        myProjectDueDateDay = new JTextField(DEFAULT_PROJECT_DAY);

        myHeader = new Header();
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
     * @author Ngou In Chu
     * @author Miguel Ramos
     */
    public void getHeaderInput() {
        JPanel myPanel = new JPanel();

        myPanel.add(new JLabel("Project Name: "));
        myPanel.add(myProjectNameField);

        myPanel.add(new JLabel("Project Budget: $"));
        myPanel.add(myProjectBudgetField);

        myPanel.add(new JLabel("Project Due Date: "));
        myPanel.add(myProjectDueDateYear);
        myPanel.add(myProjectDueDateMonth);
        myPanel.add(myProjectDueDateDay);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "Enter Project Information", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {

            //try setting the project name
            try {
                if(myProjectNameField.getText() == DEFAULT_PROJECT_NAME){
                    throw new Exception();
                }
                myHeader.setProjectName(myProjectNameField.getText());
            } catch (Exception e) {
                // continue
            }

            //try setting the project budget
            try {
                myHeader.setProjectBudget(Float.parseFloat(myProjectBudgetField.getText()));

            } catch (Exception e) {
                // continue
            }

            //try setting the project due date
            try {
                
                int year = Integer.parseInt(myProjectDueDateYear.getText().substring(0,4));
                int month = Integer.parseInt(myProjectDueDateMonth.getText().substring(0,2));
                int day = Integer.parseInt(myProjectDueDateDay.getText().substring(0,2));
                myHeader.setDueDate(LocalDate.of(year, month, day));

            } catch (Exception e) {
                //continue
            }

        } else {
            myHeader = new Header(); //Error Handling: Default to Default Header if 'OK' is not selected
        }
    }
}
