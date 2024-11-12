import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RectangleMouseCheck extends JFrame {
    static int RECT_X = 100; 
    static int RECT_Y = 100; 
    static int RECT_WIDTH =200;
    static int RECT_HEIGHT = 100;
    static boolean isInsideRectangle = false;

    public RectangleMouseCheck() {//constructor
        setTitle("Rectangle Mouse Check");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new panel());
        setVisible(true);
    }

    class panel extends JPanel {
        
        public panel() {
            setPreferredSize(new Dimension(400, 300));
            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    int mouseX = e.getX();
                    int mouseY = e.getY();
                    boolean currentlyInsideRectangle = (mouseX >= RECT_X && mouseX <= RECT_X 
                        + RECT_WIDTH && mouseY >= RECT_Y && mouseY <= RECT_Y + RECT_HEIGHT);

                        if (currentlyInsideRectangle) {
                            if (!isInsideRectangle) {
                                System.out.println("Mouse entered inside the rectangle.");
                                isInsideRectangle = true;
                            }
                        } else {
                            if (isInsideRectangle) {
                                System.out.println("Mouse exited the rectangle but is inside the Swing Window.");
                                isInsideRectangle = false;
                            }
                        }
                    
                }
            });

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    System.out.println("Mouse entered Swing Window ");
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    System.out.println("Mouse exited Swing Window ");
                }
            });
        }

        //paintComponent is a specialized method intended for custom painting within Swing components.
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // Ensure the background is cleared before drawing
            setBackground(Color.LIGHT_GRAY);
            
            g.setColor(Color.BLUE);
            g.fillRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
        }
    }

    public static void main(String[] args) {
        new RectangleMouseCheck();
    }
}
