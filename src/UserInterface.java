import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class UserInterface extends JFrame implements ActionListener {
    private ArrayList<User> users;
    private JTextField searchField;
    private JTextArea resultsArea;

    private User curuser;

    public UserInterface(User curuser, ArrayList<User> users) {
        super("Find a friend");
        this.curuser = curuser;
        this.users = users;

        JLabel searchLabel = new JLabel("Search:");
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        resultsArea = new JTextArea(10, 30);
        resultsArea.setEditable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        mainPanel.add(searchPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(resultsArea), BorderLayout.CENTER);
        setContentPane(mainPanel);

        searchButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String searchText = searchField.getText().toLowerCase();
        resultsArea.setText("");

        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem inviteMenuItem = new JMenuItem("Invite to Tournament Lobby");
        popupMenu.add(inviteMenuItem);

        for (User user : users) {
            if (user.getName().toLowerCase().contains(searchText)) {
                String userInformation = user.print();
                resultsArea.append(userInformation + "\n");

                resultsArea.addMouseListener(new MouseAdapter() {
                    public void mouseEntered(MouseEvent e) {
                        resultsArea.setToolTipText(userInformation);
                    }
                    public void mouseExited(MouseEvent e) {
                        resultsArea.setToolTipText(null);
                    }
                    public void mousePressed(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            popupMenu.show(e.getComponent(), e.getX(), e.getY());
                        }
                    }
                });

                inviteMenuItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        TournamentGUI lobby = new TournamentGUI(curuser.getName(), user.getName());
                    }
                });
            }
        }
    }

   // public static void main(String[] args) {
    //   ArrayList<User> users = new ArrayList<User>();
    //    User curuser = new User("KyleP", "kylep@gmail.ca", "Kyle");
    //    users.add(new User("Peter09", "peter@gmail.ca", "Peter"));
    //    users.add(new User("John_Sol", "jsol@gmail.ca", "John"));
//
     //   UserInterface gui = new UserInterface(curuser ,users);
    //}

}
