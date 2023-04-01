import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private JPanel backgroundPanel;
    private JLabel GameArenaLabel;
    private JButton btnLogIn;
    private JButton createAccountButton;

    public MainMenu() {
        GameArenaLabel.setText("Game Arena");
        btnLogIn.setVisible(true);
        createAccountButton.setVisible(true);

        setContentPane(backgroundPanel);
        setTitle("Welcome to Game Arena!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CreateAccountPage createAccountPage = new CreateAccountPage();
                createAccountPage.setVisible(true);
            }
        });

        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CreateLoginForm createLoginForm = new CreateLoginForm();
                createLoginForm.setVisible(true);
            }
        });

    }
    public static void main(String[] args) {
        MainMenu m = new MainMenu();
        m.setVisible(true);
    }
}
