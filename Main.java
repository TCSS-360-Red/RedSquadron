import javax.swing.*;

public class Main {
    public static void main (String[] arg) {
        JFrame mainFrame = new JFrame("Budget Balancer");
        JButton aboutButton = new JButton("About");
        aboutButton.setBounds(10, 10, 85, 20);
        mainFrame.setSize(450, 600);
        mainFrame.setVisible(true);
        mainFrame.setLocation(1000, 300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(aboutButton);

    }
}
