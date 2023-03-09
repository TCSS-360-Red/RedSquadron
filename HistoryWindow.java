/**
 * HistoryWindow class for displaying the history of transactions in a scrollable panel.
 * The class extends JPanel and contains a JScrollPane and a JPanel as its components.
 * It provides a method to update the content of the panel based on the provided history records.
 * 
 * @author Jacky Fong
 * @version Red.1
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HistoryWindow extends JPanel {
    private JScrollPane scrollPane;
    private JPanel panel;

    /**
     * Constructor for the HistoryWindow class.
     * 
     * Initializes the panel and scroll pane and sets their layout and dimensions.
     */
    public HistoryWindow() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        this.add(scrollPane, BorderLayout.CENTER);
    }

    /**
    * Updates the content of the panel based on the provided history records.
    *
    * Removes all the previous components from the panel and adds new JLabels for each
    * history record. Each JLabel contains the task, change type, and date and time of the record.
    *
    * If the array is empty, displays "History empty" on the panel.
    *
    * @param theHistory an array of HistoryRecord objects to be displayed in the panel.
    */
public void update(HistoryRecord[] theHistory) {
    panel.removeAll();
    if (theHistory.length == 0) {
        JLabel empty = new JLabel("History empty");
        panel.add(empty);
    } else {
        for (int i = 0; i < theHistory.length; i++) {
            JLabel task = new JLabel(theHistory[i].getTask().toString());
            JLabel type = new JLabel(Integer.toString(theHistory[i].getChangeType()));
            JLabel time = new JLabel(theHistory[i].getDateAndTime().toString());

            JPanel p = new JPanel();
            p.add(task);
            p.add(type);
            p.add(time);

            panel.add(p);
        }
    }
    panel.revalidate();
}



    /**
     * Returns the JScrollPane component of the HistoryWindow.
     * 
     * @return the JScrollPane component of the HistoryWindow.
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }

}