import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.*;

public class CreateLoginForm extends JFrame {
    private JPanel panel1;
    private JPanel title;
    private JLabel titlelabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameInput;
    private JPasswordField passwordInput;
    private JButton loginButton;
    private JButton forgotButton;
    public CreateLoginForm() {

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                UserAccount u = new UserAccount(usernameInput.getText());
                u.setVisible(true);
            }
        });

        forgotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ForgotUserForm f = new ForgotUserForm();
                f.setVisible(true);
            }
        });

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setTitle("Login");
    }
//    public void actionPerformed(ActionEvent ae) {
//        String userValue = usernameInput.getText();
//        String passValue = passwordInput.getText();
//        Object obj = ae.getSource();
//        if (obj == loginButton) {
//            //if (userValue.equals ( /*username variable)*/ ) && passValue.equals ( /*password variable*/ )) {
//            //go to game system
//                /* (insert gamesystem page) page = new (insert gamesystem page)
//                    page.setVisible(True);
//                 */
//            else {
//                System.out.println("Please enter valid username and password");
//            }
//        }
//        else if (obj == forgotButton) {
//            ForgotUserForm page = new ForgotUserForm();
//            page.setVisible(true);
//            dispose();
//        }
//        }
}

