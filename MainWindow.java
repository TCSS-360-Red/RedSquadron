import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
/**
 * A "Main" GUI window. Connects the backend model to the front end display windows. Serves as the "Controller"
 * object in our Model/View/Controller design. Created for the Budget Balancer 3000.
 * 
 * @author Miguel Ramos and Jacky Fong
 * @version Red.1
 */

public class MainWindow extends JFrame {

    private HistoryWindow myHistoryWindow;
    private TaskWindow myTaskWindow;
    private HeaderWindow myHeaderWindow;

    private TaskList myTaskList;
    private AboutWindow myAboutwindow;
    private TaskInputWindow myTaskInputWindow;

    private JMenuItem addTaskButton;
    private JMenuItem aboutPageButton;
    private JMenuBar myMenuBar;
    private JMenu myEditMenu;

    public MainWindow() {

        myHeaderWindow = new HeaderWindow(new Header());
        myTaskList = new TaskList();
        myTaskWindow = new TaskWindow();
        myHistoryWindow = new HistoryWindow();
        myTaskInputWindow = new TaskInputWindow();
        myAboutwindow = new AboutWindow();
        myMenuBar = new JMenuBar();
        //myEditMenu = new JMenu("Edit");

        InitializeButtons();
        SetupWindows();
    }

    private void InitializeButtons() {
        addTaskButton = new JMenuItem("Add Task");
        aboutPageButton = new JMenuItem("About");

        myEditMenu = new JMenu("Edit");
        myEditMenu.add(addTaskButton);

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
                myTaskList.AddTask(myTaskInputWindow.getString(), myTaskInputWindow.getFloat());
                myTaskWindow.displayTasks(myTaskList.copyList());
                myHistoryWindow.update(myTaskList.getHistoryList());
            }

        });
    }

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

    public void run() {
        super.setSize(450, 600);
        super.setVisible(true);
        super.setLocation(1000, 300);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //SubWindows
    // HeaderWindow - Abdul
    // Taskwindow - Jacky
    // HistoryWindow - Jacky
    //Data
    //TaskList

    //buttons
    //About button (top?)
    //File I/O? maybe???

    //public functions
    //Ask the task list object for data.
    //updateHeader: ask task list for Header, call headerWindoow.updateHeader(Header object)

    //open
    //update

}