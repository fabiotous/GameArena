import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MainMenu extends JFrame {
    private JPanel backgroundPanel;
    private JLabel GameArenaLabel;
    private JButton btnLogIn;
    private JButton createAccountButton;
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "docker";
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

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
    public static void main(String[] args) {
        MainMenu m = new MainMenu();
        m.connect();
        m.setVisible(true);
    }
}
