import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CreateAccount extends JFrame {
    private JPanel panel;
    private JPanel menuPanel;
    private JLabel title;
    private JLabel usernameLabel;
    private JTextField usernameTextField;
    private JLabel passwordLabel;
    private JButton cancelButton;
    private JButton createButton;
    private JTextField emailTextField;
    private JLabel newPasswordLabel;
    private JPasswordField passwordTextField;
    private JLabel icon;
    private JPasswordField confirmPasswordTextField;
    private JTextField nameTextField;

    public CreateAccount() {
        ImageIcon iconImg = new ImageIcon("images/controller_small.png");
        icon.setIcon(iconImg);

        setTitle("Create a New Account");
        setContentPane(panel);
        pack();
        setSize(1100, 700);
        setVisible(true);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginMenu menu = new LoginMenu();
                menu.setVisible(true);
            }
        });


        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name, username, email;
                char[] password, confirmPassword;

                name = nameTextField.getText();
                username = usernameTextField.getText();
                email = emailTextField.getText();
                password = passwordTextField.getPassword();
                confirmPassword = confirmPasswordTextField.getPassword();

                if ( username.length() == 0 || email.length() == 0 || name.length() == 0 || password.length == 0 || confirmPassword.length == 0 )
                    JOptionPane.showMessageDialog(null, "Please fill out all fields.", "Credentials Missing", JOptionPane.ERROR_MESSAGE);

                else if (!Arrays.equals(password, confirmPassword))
                    JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.", "Password Mismatch", JOptionPane.ERROR_MESSAGE);

                else if (emailExists(username))
                    JOptionPane.showMessageDialog(null, "An account with the email '" + email + "' already exists. Please log in or use another email account.", "Account Exists", JOptionPane.ERROR_MESSAGE);

                else if (usernameExists(username))
                    JOptionPane.showMessageDialog(null, "An account with the username '" + username + "' already exists. Please choose another username.", "Username Taken", JOptionPane.ERROR_MESSAGE);

                else {
                    JOptionPane.showMessageDialog(null, "Account created successfully!", "Account Created", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    UserAccount u = new UserAccount(username);
                    u.setVisible(true);
                }
            }
        });
    }

    public boolean usernameExists(String username) {
        /* Lookup username in database */
        return false;
    }

    public boolean emailExists(String email) {
        /* Lookup email in database */
        return false;
    }
}
