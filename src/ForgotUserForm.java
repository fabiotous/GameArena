import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.*;

public class ForgotUserForm extends JFrame {
    private JPanel panel1;
    private JTextField emailText;
    private JButton resetButton;
    private JLabel enterLabel;
    private JPasswordField passwordText;
    private JTextField usernameText;
    private JLabel newLabel;

    public ForgotUserForm() {
        //resetButton.addActionListener(this);
        setTitle("Reset Username/Password");

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ResetUserForm r = new ResetUserForm();
                r.setVisible(true);
            }
        });

    }
}
//    public void actionPerformed(ActionEvent ae) {
//        String newuserValue = usernameText.getText();
//        String newpassValue = passwordText.getText();
//        /* access the user database and resets the appropriate username and password*/
//        ResetUserform page = new ResetUserForm();
//        page.setVisible(true);
//        dispose();
//    }
//}
