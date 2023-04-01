import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TournamentGUI extends JFrame implements ActionListener {

    private JTextField lobbyField;
    private JButton enterButton;
    private JLabel player1Label;
    private JLabel player2Label;
    private JButton winButton;
    private JButton loseButton;
    private JLabel player1ScoreLabel;
    private JLabel player2ScoreLabel;
    private int player1Score;
    private int player2Score;

    public TournamentGUI(String player1, String player2) {
        super("Tournament Lobby Screen");
        
        JLabel lobbyLabel = new JLabel("Enter Lobby Number:");
        lobbyField = new JTextField(10);
        enterButton = new JButton("Enter");
        player1Label = new JLabel(player1);
        player2Label = new JLabel(player2);
        winButton = new JButton("Win");
        loseButton = new JButton("Lose");
        player1ScoreLabel = new JLabel("Score: 0");
        player2ScoreLabel = new JLabel("Score: 0");
        player1Score = 0;
        player2Score = 0;
        player1Label.setFont(player1Label.getFont().deriveFont(20f));
        player2Label.setFont(player2Label.getFont().deriveFont(20f));
        lobbyLabel.setFont(lobbyLabel.getFont().deriveFont(20f));
        player1ScoreLabel.setFont(player1ScoreLabel.getFont().deriveFont(20f));
        player2ScoreLabel.setFont(player2ScoreLabel.getFont().deriveFont(20f));

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        JPanel lobbyPanel = new JPanel(new FlowLayout());
        lobbyPanel.add(lobbyLabel);
        lobbyPanel.add(lobbyField);
        lobbyPanel.add(enterButton);
        mainPanel.add(lobbyPanel, BorderLayout.NORTH);
        JPanel playerPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        playerPanel.add(player1Label);
        playerPanel.add(player2Label);
        playerPanel.add(player1ScoreLabel);
        playerPanel.add(player2ScoreLabel);
        mainPanel.add(playerPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(winButton);
        buttonPanel.add(loseButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        setContentPane(mainPanel);

        enterButton.addActionListener(this);
        winButton.addActionListener(this);
        loseButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterButton) {
            String lobbyNumber = lobbyField.getText();
            JOptionPane.showMessageDialog(this, "Entered lobby: " + lobbyNumber);
        } else if (e.getSource() == winButton) {
            player1Score++;
            player1ScoreLabel.setText("Score: " + player1Score);
        } else if (e.getSource() == loseButton) {
            player2Score++;
            player2ScoreLabel.setText("Score: " + player2Score);
        }
    }

//    public static void main(String[] args) {
//        String player1 = "Kyle";
//        String player2 = "Tom";
//        TournamentGUI gui = new TournamentGUI(player1, player2);
//    }

}
