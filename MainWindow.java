import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
/**
 * A "Main" GUI window. Connects the backend model to the front end display windows. Serves as the "Controller"
 * object in our Model/View/Controller design. Created for the Budget Balancer 3000.
 * 
 * @author Miguel Ramos
 * @author Jacky Fong
 * @version Red.1
 */

public class MainWindow extends JFrame {

    private HistoryWindow myHistoryWindow;
    private TaskWindow myTaskWindow;
    private HeaderWindow myHeaderWindow;

    private TaskList myTaskList;
    private AboutWindow myAboutwindow;
    private TaskInputWindow myTaskInputWindow;
    private HeaderInputWindow myHeaderInputWindow;

    private JMenuItem addTaskButton;
    private JMenuItem aboutPageButton;
    private JMenuItem editHeaderButton;
    private JMenuBar myMenuBar;
    private JMenu myEditMenu;

    /**Initializes the GUI and the backend model.
     * 
     * @author Miguel Ramos
     * @author Jacky Fong
     */
    public MainWindow() {

        myHeaderWindow = new HeaderWindow(new Header());
        myTaskList = new TaskList();
        myTaskWindow = new TaskWindow();
        myHistoryWindow = new HistoryWindow();
        myTaskInputWindow = new TaskInputWindow();
        myHeaderInputWindow = new HeaderInputWindow();
        myAboutwindow = new AboutWindow();
        myMenuBar = new JMenuBar();

        setTitle("Budget Balancer 3000"); // Set the title of the window

        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("BB3KDollarLogo.png"));
        setIconImage(icon);


        InitializeButtons();
        SetupWindows();
    }

    /**Initializes buttons and wires them to relevant functions
     * 
     * @author Miguel Ramos
     */
    private void InitializeButtons() {
        addTaskButton = new JMenuItem("Add Task");
        aboutPageButton = new JMenuItem("About");
        editHeaderButton = new JMenuItem("Edit Header");

        myEditMenu = new JMenu("Edit");
        myEditMenu.add(addTaskButton);
        myEditMenu.add(editHeaderButton);

        myMenuBar.add(myEditMenu);
        myMenuBar.add(aboutPageButton);
        super.setJMenuBar(myMenuBar);

        aboutPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myAboutwindow.open();

            }
        });
        addTaskButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myTaskInputWindow.getTaskInput();
                if(myTaskInputWindow.getString() != ""){ //error handling
                    myTaskList.AddTask(myTaskInputWindow.getString(), myTaskInputWindow.getFloat());
                    myTaskWindow.displayTasks(myTaskList.copyList());
                    myHistoryWindow.update(myTaskList.getHistoryList());
                    myHeaderWindow.updateHeader(myTaskList.getHeaderState());
                }
            }

        });
        editHeaderButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myHeaderInputWindow.getHeaderInput();
                myTaskList.AssignHeader(myHeaderInputWindow.getHeader());
                myHeaderWindow.updateHeader(myTaskList.getHeaderState());
            }

        });
    }

    /**"Sticks" each Subwindow to the MainWindow. 
     * 
     * @author Miguel Ramos
     * @author Jacky Fong
    */
    private void SetupWindows() {
        // Add HeaderWindow
        JPanel headerPanel = new JPanel();
        headerPanel.add(myHeaderWindow.getPanel());
        add(headerPanel, BorderLayout.NORTH);
        JPanel taskPanel = new JPanel();
        JLabel taskLabel = new JLabel("Task:");

        taskPanel.setLayout(new BorderLayout());
        taskPanel.add(taskLabel, BorderLayout.NORTH);
        taskPanel.add(myTaskWindow.getScrollPane(), BorderLayout.CENTER);
        add(taskPanel, BorderLayout.CENTER);

        JPanel historyPanel = new JPanel();
        JLabel historyLabel = new JLabel("History:");
        historyPanel.add(historyLabel);
        historyPanel.add(myHistoryWindow);
        add(historyPanel, BorderLayout.SOUTH);

    }

    /**Displays the GUI.
     * 
     * @author Miguel Ramos
     */
    public void run() {
        super.setSize(450, 600);
        super.setVisible(true);
        super.setLocation(1000, 300);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}