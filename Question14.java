import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Question14 {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Main Frame");
        mainFrame.setSize(400, 300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout());
        JLabel label = new JLabel("Select an option:");
        mainFrame.add(label);
        Choice choice = new Choice();
        choice.add("Option 1");
        choice.add("Option 2");
        choice.add("Option 3");
        choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Selected: " + choice.getSelectedItem());
                }
            }
        });
        mainFrame.add(choice);
        JPanel buttonPanel = new JPanel();
        JButton openChildFrameButton = new JButton("Open Child Frame");
        openChildFrameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame childFrame = new JFrame("Child Frame");
                childFrame.setSize(200, 150);
                childFrame.setLocationRelativeTo(mainFrame);
                childFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                childFrame.setLayout(new FlowLayout());
                childFrame.add(new JLabel("This is the child frame!"));
                childFrame.setVisible(true);
            }
        });
        buttonPanel.add(openChildFrameButton);
        mainFrame.add(buttonPanel); // Add the button panel to the main frame
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}