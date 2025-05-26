import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

public class MouseDrawingApp extends JFrame {

    public MouseDrawingApp() {
        setTitle("Mouse Drawing App");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        DrawingPanel panel = new DrawingPanel();
        add(panel);
    }

    private static class DrawingPanel extends JPanel {
        private List<Point> points = new ArrayList<>();

        public DrawingPanel() {
            setBackground(Color.WHITE);

            // Add a MouseMotionAdapter to track mouse drags
            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    // Add the current mouse point to the list
                    points.add(e.getPoint());
                    // Repaint the panel to draw the new point/line
                    repaint();
                }
            });

            // Add a MouseAdapter to clear points on mouse press to start a new line
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    points.clear(); // Clear previous points to start a new drawing segment
                    points.add(e.getPoint()); // Add the starting point
                    repaint(); // Repaint to clear the previous drawing
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Set drawing color
            g2d.setColor(Color.BLACK);

            // Draw lines between consecutive points
            for (int i = 0; i < points.size() - 1; i++) {
                Point p1 = points.get(i);
                Point p2 = points.get(i + 1);
                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MouseDrawingApp().setVisible(true);
        });
    }
} 