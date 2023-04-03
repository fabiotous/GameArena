import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserAccount extends JFrame {
    private JPanel panel;
    private JLabel greeting;
    private JButton selectAGameButton;
    private JButton addAFriendButton;
    private JButton viewAccountStatisticsButton;
    private JTextArea stats;
    private JButton logOffButton;
    public String username;

    public UserAccount(String username) {
        this.username = username;
        greeting.setText("Welcome " + username + "!");

        // Replace 0 with wins/losses/ties from somewhere
        stats.append("Wins: " + 0 + "\n");
        stats.append("Losses: " + 0 + "\n");
        stats.append("Ties: " + 0 + "\n");
        stats.setVisible(false);

        setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(size.width/2, size.height/4);

        selectAGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameForm gameForm = new GameForm();
                gameForm.setVisible(true);
            }
        });

        logOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainMenu m = new MainMenu();
                m.setVisible(true);
            }
        });

        viewAccountStatisticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stats.isVisible()) {
                    stats.setVisible(false);
                    viewAccountStatisticsButton.setText("View Account Statistics");
                }
                else {
                    stats.setVisible(true);
                    viewAccountStatisticsButton.setText("Hide Account Statistics");
                }
                greeting.grabFocus();
            }
        });

        addAFriendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

                // Sample data
                ArrayList<User> users = new ArrayList<User>();
                users.add(new User("Peter09", "peter@gmail.ca", "Peter"));
                users.add(new User("John_Sol", "jsol@gmail.ca", "John"));

                // Create GUI
                UserInterface gui = new UserInterface(users);
            }
        });

    }

//    public static void main(String[] args) {
//        JFrame frame = new JFrame("UserAccount");
//        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
//
//        frame.setContentPane(new UserAccount("testUser").panel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setSize(size.width/2, size.height/4);
//        frame.setVisible(true);
//    }
}
