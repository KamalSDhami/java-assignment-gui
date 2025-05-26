import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class DrawingApp extends JFrame {

    public DrawingApp() {
        setTitle("Drawing Project 3");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        DrawingPanel panel = new DrawingPanel();
        add(panel);
    }

    private static class DrawingPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Set drawing color to red
            g2d.setColor(Color.RED);

            // Draw face rectangle
            int faceX = 100;
            int faceY = 100;
            int faceWidth = 150;
            int faceHeight = 150;
            g2d.drawRect(faceX, faceY, faceWidth, faceHeight);

            // Draw eyes (filled circles)
            int eyeSize = 20;
            int eye1X = faceX + 35;
            int eye1Y = faceY + 40;
            int eye2X = faceX + faceWidth - eyeSize - 35;
            int eye2Y = faceY + 40;
            g2d.fillOval(eye1X, eye1Y, eyeSize, eyeSize);
            g2d.fillOval(eye2X, eye2Y, eyeSize, eyeSize);

            // Draw mouth (curved line/arc)
            int mouthX = faceX + 40;
            int mouthY = faceY + 90;
            int mouthWidth = faceWidth - 80;
            int mouthHeight = 50;
            g2d.drawArc(mouthX, mouthY, mouthWidth, mouthHeight, 0, -180);

            // Draw ears (outlined circles)
            int earSize = 30;
            int ear1X = faceX - earSize / 2;
            int ear1Y = faceY + faceHeight / 2 - earSize / 2;
            int ear2X = faceX + faceWidth - earSize / 2;
            int ear2Y = faceY + faceHeight / 2 - earSize / 2;
            g2d.drawOval(ear1X, ear1Y, earSize, earSize);
            g2d.drawOval(ear2X, ear2Y, earSize, earSize);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DrawingApp().setVisible(true);
        });
    }
} 