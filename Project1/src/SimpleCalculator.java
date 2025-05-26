import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SimpleCalculator extends JFrame {
    private JTextField num1;
    private JTextField num2;
    private JButton addButton;
    private JLabel output;

    public SimpleCalculator() {
        // Create the frame
        super("Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create components
        num1 = new JTextField(5);
        num2 = new JTextField(5);
        addButton = new JButton("+");
        output = new JLabel("Output");
        
        // Create panel and add components
        JPanel panel = new JPanel();
        panel.add(num1);
        panel.add(num2);
        panel.add(addButton);
        panel.add(output);
        
        // Add action to button
        addButton.addActionListener(this::calculateAndDisplay);
        
        // Display the frame
        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calculateAndDisplay(ActionEvent e) {
        try {
            double n1 = Double.parseDouble(num1.getText());
            double n2 = Double.parseDouble(num2.getText());
            output.setText("Output: " + (n1 + n2));
        } catch (Exception ex) {
            output.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleCalculator::new);
    }
} 