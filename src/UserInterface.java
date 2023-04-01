import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class UserInterface extends JFrame implements ActionListener {
    private ArrayList<User> users;
    private JTextField searchField;
    private JTextArea resultsArea;

    public UserInterface(ArrayList<User> users) {
        super("Find a friend");
        this.users = users;

        // Create components
        JLabel searchLabel = new JLabel("Search:");
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        resultsArea = new JTextArea(10, 30);
        resultsArea.setEditable(false);

        // Add components to frame
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        mainPanel.add(searchPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(resultsArea), BorderLayout.CENTER);
        setContentPane(mainPanel);

        // Add action listener to search button
        searchButton.addActionListener(this);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String searchText = searchField.getText().toLowerCase();
        resultsArea.setText("");

        for (User user : users) {
            if (user.getName().toLowerCase().contains(searchText)) {
                resultsArea.append(user.print() + "\n");
            }
        }
    }
//    public static void main(String[] args) {
//        // Sample data
//        ArrayList<User> users = new ArrayList<User>();
//        users.add(new User("Peter09", "peter@gmail.ca", "Peter"));
//        users.add(new User("John_Sol", "jsol@gmail.ca", "John"));
//
//        // Create GUI
//        UserInterface gui = new UserInterface(users);
//    }

}