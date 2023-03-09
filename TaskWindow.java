import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TaskWindow extends JPanel {
    private JScrollPane scrollPane;
    private JPanel panel;

    public TaskWindow() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void displayTasks(Task[] tasks) {
        panel.removeAll();
        for (Task task : tasks) {
            JPanel taskPanel = createTaskPanel(task);
            panel.add(taskPanel);
        }
        panel.revalidate();
    }

    private JPanel createTaskPanel(Task task) {
        JLabel taskLabel = new JLabel(task.toString());
        JPanel taskPanel = new JPanel();
        taskPanel.add(taskLabel);
        return taskPanel;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }
}