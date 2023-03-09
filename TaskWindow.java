/**

TaskWindow class for displaying a list of tasks in a scrollable panel.
The class extends JPanel and contains a JScrollPane and a JPanel as its components.
It provides a method to update the content of the panel based on the provided tasks.
It also contains a private method to create a JPanel for each task to be displayed.
@author Jacky Fong
@version Red.1
*/
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TaskWindow extends JPanel {
    private JScrollPane scrollPane;
    private JPanel panel;

    /**
     * Constructor for the TaskWindow class.
     * 
     * Initializes the panel and scroll pane and sets their layout and dimensions.
     */
    public TaskWindow() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        this.add(scrollPane, BorderLayout.CENTER);
        JLabel noTasksSelectedLabel = new JLabel("No tasks selected");
        noTasksSelectedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(noTasksSelectedLabel);
    }

    /**
     * Updates the content of the panel based on the provided tasks.
     * 
     * Removes all the previous components from the panel and adds a new JPanel for each 
     * task. Each JPanel contains a JLabel with the task's name and details.
     * If the tasks array is empty, displays a JLabel with the text "No tasks selected".
     * 
     * @param tasks an array of Task objects to be displayed in the panel.
     */
    public void displayTasks(Task[] tasks) {
        panel.removeAll();
        if (tasks.length == 0) {
            JLabel noTasksSelectedLabel = new JLabel("No tasks selected");
            noTasksSelectedLabel.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(noTasksSelectedLabel);
        } else {
            for (Task task: tasks) {
                JPanel taskPanel = createTaskPanel(task);
                panel.add(taskPanel);
            }
        }
        panel.revalidate();
    }


    /**
     * Creates a JPanel for displaying a task.
     * 
     * Creates a JLabel with the task's name and adds it to a new JPanel.
     * 
     * @param task the Task object to be displayed in the panel.
     * @return a new JPanel containing a JLabel with the task's name.
     */
    private JPanel createTaskPanel(Task task) {
        JLabel taskLabel = new JLabel(task.toString());
        JPanel taskPanel = new JPanel();
        taskPanel.add(taskLabel);
        return taskPanel;
    }

    /**
     * Returns the JScrollPane component of the TaskWindow.
     * 
     * @return the JScrollPane component of the TaskWindow.
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }

}