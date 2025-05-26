import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInfoForm extends JFrame implements ActionListener {
    private JTextField nameField;
    private JRadioButton maleButton, femaleButton;
    private ButtonGroup genderGroup;
    private JCheckBox coffeeBox, teaBox;
    private JButton submitButton;
    private JLabel outputLabel;

    public UserInfoForm() {
        // Frame setup
        setTitle("User Information Form");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Components
        nameField = new JTextField(15);
        
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        coffeeBox = new JCheckBox("likes Coffee");
        teaBox = new JCheckBox("likes Tea");

        submitButton = new JButton("Submit detail");
        outputLabel = new JLabel("Greetings.");

        // Add components to frame
        add(new JLabel("Name:"));
        add(nameField);
        add(maleButton);
        add(femaleButton);
        add(coffeeBox);
        add(teaBox);
        add(submitButton);
        add(outputLabel);

        // Add action listener
        submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String gender = "";
            if (maleButton.isSelected()) {
                gender = "Mr. ";
            } else if (femaleButton.isSelected()) {
                gender = "Ms. ";
            }

            StringBuilder likes = new StringBuilder();
            if (coffeeBox.isSelected()) {
                likes.append("likes coffee");
            }
            if (teaBox.isSelected()) {
                if (likes.length() > 0) {
                    likes.append(", ");
                }
                likes.append("likes tea");
            }

            outputLabel.setText(gender + name + " " + likes.toString() + ".");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UserInfoForm().setVisible(true);
        });
    }
} 