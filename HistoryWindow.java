import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HistoryWindow extends JPanel {
    private JScrollPane scrollPane;
    private JPanel panel;
    public HistoryWindow() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void update(HistoryRecord[] theHistory) {
        panel.removeAll();
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
        panel.revalidate();
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

}