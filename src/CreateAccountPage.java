import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreateAccountPage extends JFrame{
    private JPanel backgroundPanel;
    private JLabel titleLabel;
    private JTextField nameField;
    private JTextField usernameField;
    private JTextField emailField;
    private JButton SubmitButton;
    private JButton BackButton;
    private JPasswordField confirmPassword;
    private JPasswordField password;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;

    public CreateAccountPage(){
        nameField.setText("Enter your full name: ");
        usernameField.setText("Enter your username: ");
        emailField.setText("Enter your email: ");
        passwordLabel.setText("Enter your password: ");
        confirmPasswordLabel.setText("Confirm your password: ");
        SubmitButton.setText("Submit");
        BackButton.setText("Back");

        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainMenu m = new MainMenu();
                m.setVisible(true);
            }
        });

        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Account created successfully!");
                dispose();
                UserAccount u = new UserAccount(usernameField.getText());
                u.setVisible(true);
            }
        });

        setContentPane(backgroundPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
    }

}
