import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

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
    private JLabel nameLabel;
    private JLabel emailLabel;
    private JLabel usernameLabel;
    private String[] games = {"Chess", "Checkers", "Death", "BlackJack", "TournamentLobby"};

    public CreateAccountPage(){
        nameLabel.setText("Enter your full name: ");
        nameLabel.setLabelFor(nameField);
        usernameLabel.setText("Enter your username: ");
        usernameLabel.setLabelFor(usernameField);
        emailLabel.setText("Enter your email: ");
        emailLabel.setLabelFor(emailField);
        passwordLabel.setText("Enter your password: ");
        passwordLabel.setLabelFor(password);
        confirmPasswordLabel.setText("Confirm your password: ");
        confirmPasswordLabel.setLabelFor(confirmPassword);
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
                if (emailField.getText() != "" && nameField.getText() != "" && usernameField.getText() != "" && password.getPassword().length != 0 && confirmPassword.getPassword().length != 0) {
                    var field = password.getPassword();
                    String userPW = String.valueOf(field);
                    var fieldConfirm = confirmPassword.getPassword();
                    String userPWC = String.valueOf(fieldConfirm);

                    if (userPW.equals(userPWC)) {
                        BufferedWriter out = null;

                        try {
                            FileWriter f = new FileWriter("database.txt", true); //true tells to append data.
                            out = new BufferedWriter(f);
                            out.write("\n" + "\n" + "Name: " + nameField.getText());
                            out.write("\n" + "Email: " + emailField.getText());
                            out.write("\n" + "Username: " + usernameField.getText());
                            for (String game: games) {
                                out.write("\n" + game + " Stats");
                                out.write("\n - Wins: 0");
                                out.write("\n - Loses: 0");
                                out.write("\n - Ties: 0");
                            }
                        }

                        catch (IOException er) {
                            System.err.println("Error: " + er.getMessage());
                        }

                        finally {
                            if(out != null) {
                                try {
                                    out.close();
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Account created successfully!");
                        dispose();
                        UserAccount u = new UserAccount(usernameField.getText());
                        u.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog (null, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog (null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setContentPane(backgroundPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
    }

}
