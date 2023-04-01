import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResetUserForm extends JFrame implements ActionListener {
    private JPanel panel1;
    private JButton returnButton;
    private JLabel confirmLabel;

    public ResetUserForm() {
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);

        returnButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae) {
        MainMenu page = new MainMenu();
        page.setVisible(true);
        dispose();
    }
}

