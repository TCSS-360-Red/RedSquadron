import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HistoryWindow extends JFrame {
    private HistoryList historyList;
    //private ArrayList<HistoryList> logs;
    private JScrollPane scrollPane;
    private JList<HistoryList> list;

    public HistoryWindow(HistoryList historyList) {
        super("History");
        this.setSize(500, 300);
        this.setLayout(new BorderLayout());

        this.historyList = new HistoryList();
        //logs = historyList.printHistory();

        DefaultListModel<HistoryList> model = new DefaultListModel<>();
        for (HistoryList log : logs) {
            model.addElement(log);
        }

        list = new JList<>(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        scrollPane = new JScrollPane(list);
        this.add(scrollPane, BorderLayout.CENTER);
    }


    
    //Miguel: Suggested function
    void update(HistoryRecords [] theHistory){
        JLabel[] labels = new JLabel[history.length];
        int y = history.length;
        static JFrame f;
        for(int i=0; i<history.length; i++) {
                JLabel task = new JLabel(HistoryRecord.getTask());
                JLabel type = new JLabel(HistoryRecord.myChangeType());
                JLabel time = new JLabel(HistoryRecord.myDateAndTime());
                // create a panel
                JPanel p = new JPanel();
                // add label to panel
                p.add(task + type + time);
                // add panel to frame
                f.add(p);
                // set the size of frame
                f.setSize(300, 300);
                f.show();
        }
    }

    // public void update(HistoryRecord[] theHistory) {
    //     DefaultListModel<HistoryRecord> model = (DefaultListModel<HistoryRecord>) list.getModel();
    //     for (HistoryRecord log : theHistory) {
    //         model.addElement(log);
    //     }
    //     list.setModel(model);
    // }
}