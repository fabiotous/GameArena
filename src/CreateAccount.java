import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;

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
    private String[] games = {"Chess", "Checkers", "Death", "BlackJack", "TournamentLobby", "TicTacToe"};

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
                String userPW = String.valueOf(password);
                confirmPassword = confirmPasswordTextField.getPassword();

                if ( username.length() == 0 || email.length() == 0 || name.length() == 0 || password.length == 0 || confirmPassword.length == 0 )
                    JOptionPane.showMessageDialog(null, "Please fill out all fields.", "Credentials Missing", JOptionPane.ERROR_MESSAGE);

                else if (!Arrays.equals(password, confirmPassword))
                    JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.", "Password Mismatch", JOptionPane.ERROR_MESSAGE);

                else if (emailExists(email))
                    JOptionPane.showMessageDialog(null, "An account with the email '" + email + "' already exists. Please log in or use another email account.", "Account Exists", JOptionPane.ERROR_MESSAGE);

                else if (usernameExists(username))
                    JOptionPane.showMessageDialog(null, "An account with the username '" + username + "' already exists. Please choose another username.", "Username Taken", JOptionPane.ERROR_MESSAGE);

                else {
                    JOptionPane.showMessageDialog(null, "Account created successfully!", "Account Created", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    UserAccount u = new UserAccount(username);
                    u.setVisible(true);
                    BufferedWriter out = null;

                    try {
                        FileWriter f = new FileWriter("database.txt", true); //true tells to append data.
                        out = new BufferedWriter(f);
                        out.write("\n" + "\n" + "Name: " + name);
                        out.write("\n" + "Email: " + email);
                        out.write("\n" + "Username: " + username);
                        out.write("\n" + "Password: " + userPW);
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
                }
            }
        });
    }
    public boolean usernameExists(String username) {
        /* Lookup username in database */
        try {
            File file = new File("database.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String targetusername = "";
                if (line.length() >= 10)
                {
                    if (line.substring(0,9).equals("Username:"))
                    {
                        targetusername = line.substring(10);
                    }
                }
                if (username.equals(targetusername))
                {
                    return true;
            }
            //scanner.close();
        }} catch (FileNotFoundException f) {
            System.out.println("File not found.");
        }
        return false;
    }

    public boolean emailExists(String email) {
        /* Lookup email in database */
        try {
            File file = new File("database.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String targetemail = "";
                if (line.length() >= 7)
                {
                    if (line.substring(0,6).equals("Email:"))
                    {
                        targetemail = line.substring(7);
                    }
                }
                if (email.equals(targetemail))
                {
                    return true;
                }
                //scanner.close();
            }} catch (FileNotFoundException f) {
            System.out.println("File not found.");
        }
        return false;
    }
}
