import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventExample extends JFrame {
    static int timer = 100;
    static int timer2 = 30;

    public MouseEventExample() {// constructor
        setTitle("Handle Mouse Events");
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the window on windows screen

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showConfirmDialog(MouseEventExample.this,
                        "Are you sure you want to close?",
                        "Confirm Exit",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    dispose(); // Close the frame
                }
            }
        });
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Prevent default close operation

        add(new panel());
        setVisible(true);
    }

    class panel extends JPanel {

        public panel() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    System.out.println("Mouse pressed at: " + e.getPoint());
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    System.out.println("Mouse released at: " + e.getPoint());
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    System.out.println("Mouse entered the window");
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    System.out.println("Mouse exited the window");
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Mouse clicked at: " + e.getPoint());
                }
            });

            // Add a MouseMotionListener to handle mouse movement
            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    if (timer > 0) {
                        timer = timer - 1;
                    } else {
                        System.out.println("Mouse moved at: " + e.getPoint());
                        timer = 100;
                    }
                }

                @Override
                public void mouseDragged(MouseEvent e) {

                    if (timer2 > 0) {
                        timer2 = timer2 - 1;
                    } else {
                        System.out.println("Mouse dragged at: " + e.getPoint());
                        timer2 = 30;
                    }
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.GRAY);
        }
    }

    public static void main(String[] args) {
        new MouseEventExample();
    }
}