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
    //void update(HistoryRecords [] theHistory){    
        //print thehistory;
   //}

    public void update(HistoryRecord[] theHistory) {
        DefaultListModel<HistoryRecord> model = (DefaultListModel<HistoryRecord>) list.getModel();
        for (HistoryRecord log : theHistory) {
            model.addElement(log);
        }
        list.setModel(model);
    }
}