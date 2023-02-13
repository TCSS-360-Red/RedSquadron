import javax.swing.*;
/**
 * An About window for the Budget Balancer 3000
 * 
 * @author Miguel Ramos
 * @version Red.1
 */

public class AboutWindow {
    private  JFrame myWindow;
    private JLabel myLabel;
    private Developer devTeamInfo[];

    AboutWindow(){
        devTeamInfo = new Developer[2];
        devTeamInfo[0] = new Miguel();
        devTeamInfo[1] = new Abdul();
        devTeamInfo[2] = new Bill();
        //Jacky, Bill, when you implement your Developer classes,
        //instantiate them here and update the array size on line 15;
        //
        //
        myWindow = new JFrame("About");
        myLabel = new JLabel();
    }

    public void open(){
        String devString;
        int devTeamSize;

        devTeamSize = devTeamInfo.length;
        devString = new String();
        for(int i = 0; i < devTeamSize; i++) {
            devString += devTeamInfo[i].getDevInfo();
            devString += "%n";
        myLabel.setText(devString);

        myWindow.setSize(500, 800);
        myWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myWindow.add(myLabel);
       // myWindow.pack();

        myWindow.setVisible(true);

    }

    
}
}
