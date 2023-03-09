import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] arg) {

        JFrame mainFrame = new JFrame("Budget Balancer");
        //We should make a separate class for the mainFrame which will contain all this functionality
        JButton aboutButton = new JButton("About");
        AboutWindow myAboutWindow = new AboutWindow();
        HistoryWindow myHistoryWindow = new HistoryWindow();
        TaskWindow myTaskWindow = new TaskWindow(); // create TaskWindow instance
        JPanel taskPanel = new JPanel(); // create JPanel for TaskWindow and label

        aboutButton.setBounds(10, 10, 85, 20);
        mainFrame.setSize(450, 600);
        mainFrame.setVisible(true);
        mainFrame.setLocation(1000, 300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(aboutButton, BorderLayout.NORTH);

        // add label and TaskWindow to taskPanel
        JLabel taskLabel = new JLabel("Task:");
        taskPanel.setLayout(new BorderLayout());
        taskPanel.add(taskLabel, BorderLayout.NORTH);
        taskPanel.add(myTaskWindow.getScrollPane(), BorderLayout.CENTER);

        // add taskPanel and HistoryWindow panel to mainFrame
        mainFrame.add(taskPanel, BorderLayout.CENTER);
        JPanel historyPanel = new JPanel();
        JLabel historyLabel = new JLabel("History:");
        historyPanel.add(historyLabel);
        historyPanel.add(myHistoryWindow.getScrollPane());
        mainFrame.add(historyPanel, BorderLayout.SOUTH);

        aboutButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                myAboutWindow.open();
            }
        });
    }
}