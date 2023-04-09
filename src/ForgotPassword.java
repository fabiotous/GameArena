import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class ForgotPassword extends JFrame {
    private JPanel panel;
    private JPanel menuPanel;
    private JLabel icon;
    private JLabel title;
    private JLabel usernameLabel;
    private JTextField usernameTextField;
    private JLabel passwordLabel;
    private JButton cancelButton;
    private JButton resetButton;
    private JTextField emailTextField;
    private JLabel newPasswordLabel;
    private JPasswordField newPasswordTextField;

    public ForgotPassword() {
        ImageIcon iconImg = new ImageIcon("images/controller_small.png");
        icon.setIcon(iconImg);

        setTitle("Reset Password");
        setContentPane(panel);
        pack();
        setSize(1100, 600);
        setVisible(true);

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String email = emailTextField.getText();
                char[] password = newPasswordTextField.getPassword();

                if (username.length() == 0 || email.length() == 0 )
                    JOptionPane.showMessageDialog(null, "Please enter the username and email associated with your account.", "Credentials Missing", JOptionPane.ERROR_MESSAGE);

                else if (password.length == 0 )
                    JOptionPane.showMessageDialog(null, "Please enter a new password", "Credentials Missing", JOptionPane.ERROR_MESSAGE);

                else if (!accountExists(username, email))
                    JOptionPane.showMessageDialog(null, "No account exists with the provided username and email. Please try again.", "Invalid Credentials", JOptionPane.ERROR_MESSAGE);

                else {
                    updatePassword(username, newPasswordTextField.getPassword());
                    JOptionPane.showMessageDialog(null, "Password successfully updated.", "Password Updated", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    LoginMenu menu = new LoginMenu();
                    menu.setVisible(true);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginMenu menu = new LoginMenu();
                menu.setVisible(true);
            }
        });
    }

    public boolean accountExists(String username, String email) {
        Connection conn = null;
        /*

            Insert code to check if an account with username/email combination exists
            in the database.........

        */

        // Return true for now
        return true;
    }

    public void updatePassword(String username, char[] password) {
        // Needs database
    }
}
