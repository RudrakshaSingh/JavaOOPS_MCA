import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    
    public MainFrame() {
        setTitle("ItemEvent and Child Frame Example");
        setSize(400, 300);
        setLocationRelativeTo(null);  // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JLabel label = new JLabel("Select an item:");
        Choice choice = new Choice();
        choice.add("Item 1");
        choice.add("Item 2");
        choice.add("Item 3");
        choice.add("Item 4");
        
        // Add ItemListener using an anonymous inner class
        choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Selected Item: " + e.getItem());
                }
            }
        });

        JButton childFrameButton = new JButton("Open Child Frame");
        
        // Add ActionListener to the button using an anonymous inner class
        childFrameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openChildFrame();
            }
        });

        add(label);
        add(choice);
        add(childFrameButton);

        setVisible(true);
    }

    public void openChildFrame() {
        JFrame childFrame = new JFrame("Child Frame");
        childFrame.setSize(300, 200);
        childFrame.setLocationRelativeTo(this);// 'this' refers to the current MainFrame instance
        childFrame.setLayout(new FlowLayout());

        childFrame.add(new JLabel("This is the child frame!"));

        childFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        childFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
