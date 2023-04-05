import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginMenu extends JFrame {
    private JPanel panel;
    private JLabel icon;
    private JLabel title;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JButton loginButton;
    private JButton forgotButton;
    private JSeparator sep;
    private JPanel menuPanel;
    private JButton createAccountButton;
    private JLabel createButtonLabel;


    public LoginMenu() {
        ImageIcon iconImg = new ImageIcon("images/controller_small.png");
        icon.setIcon(iconImg);

        setTitle("Game Arena Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        pack();
        setSize(1100, 600);
        setVisible(true);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = passwordTextField.getText();

                if (username.length() == 0 || password.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Please enter your username and password.", "Credentials Missing", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Not sure how this is being done, leaving as pseudocode for now
                // Check txt file or database (?) for matching username and password

                if (true) { // If username and password are correct
                    dispose();  // Only dispose if correct
                    UserAccount user = new UserAccount(username);
                    user.setVisible(true);
                }

                // else if (username/password combo is wrong) {
                //      JOptionPane.showMessageDialog(null,"Password is invalid, please try again.","Login Error", JOptionPane.ERROR_MESSAGE);
                // }

                // else if (no account with given username exists) {
                //      JOptionPane.showMessageDialog(null,"Invalid username provided, please try again.","Login Error", JOptionPane.ERROR_MESSAGE);
                //}
            }
        });

        forgotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ForgotUserForm f = new ForgotUserForm();
                f.setVisible(true);
            }
        });


        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CreateAccountPage c = new CreateAccountPage();
                c.setVisible(true);

            }
        });
    }

        public static void main(String[] args) {
            LoginMenu menu = new LoginMenu();
            menu.setVisible(true);

    }
}
