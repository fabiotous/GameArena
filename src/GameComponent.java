import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GameComponent extends JComponent implements MouseListener {
  public BufferedImage backgroundImage;
  public BufferedImage logo;
  public BufferedImage chip;
  private ArrayList<Card> dealerHand;
  private ArrayList<Card> playerHand;
  private int dealerScore;
  private int playerScore;
  public boolean faceDown = true;
  public static boolean betMade = false;
  private int currentBalance;
  public static int currentBet;

  public GameComponent(ArrayList<Card> dH, ArrayList<Card> pH) {
    dealerHand = dH;
    playerHand = pH;
    dealerScore = 0;
    playerScore = 0;
    currentBalance = 1000;
    addMouseListener(this);
  }

  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    try {
      backgroundImage = ImageIO.read(new File("images/background.png"));
      logo = ImageIO.read(new File("images/blackjackLogo.png"));
      chip = ImageIO.read(new File("images/chip.png"));
    }
    catch(IOException e) {}

    g2.drawImage(backgroundImage, 0, 0, null);
    g2.drawImage(logo, 510, 200, null);
    g2.drawImage(chip, 50, 300, null);
    g2.setColor(Color.WHITE);
    g2.setFont(new Font("Palatino", Font.BOLD, 30));
    g2.drawString("DEALER", 515, 50);
    g2.drawString("YOU", 540, 380);
    g2.drawString("DEALER'S SCORE: ", 50, 100);
    g2.drawString(Integer.toString(dealerScore), 400, 100);
    g2.drawString("YOUR SCORE: ", 50, 150);
    g2.drawString(Integer.toString(playerScore), 400, 150);
    g2.setFont(new Font("Palatino", Font.BOLD, 15));
    g2.drawString("To start each round, you have to first", 50, 250);
    g2.drawString("bet an amount by clicking on the chip below.", 50, 270);
    g2.setFont(new Font("Palatino", Font.BOLD, 20));
    g2.drawString("CURRENT BALANCE: " + currentBalance, 50, 570);

    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
    g2.drawString(sdf.format(cal.getTime()), 1020, 20);

    try {
      for (int i = 0; i < dealerHand.size(); i++) {
        if (i == 0) {
          if(faceDown) {
            dealerHand.get(i).printCard(g2, true, true, i);
          }
          else {
            dealerHand.get(i).printCard(g2, true, false, i);
          }
        }
        else {
          dealerHand.get(i).printCard(g2, true, false, i);
        }
      }
    }
    catch (IOException e) {}

    try {
      for (int i = 0; i < playerHand.size(); i++) {
        playerHand.get(i).printCard(g2, false, false, i);
      }
    }
    catch (IOException e) {}
  }

  public void refresh(int cB, int uS, int dS, boolean fD) {
    currentBalance = cB;
    playerScore = uS;
    dealerScore = dS;
    faceDown = fD;
    this.repaint();
  }

  public void mousePressed(MouseEvent e) {
    int mouseX = e.getX();
    int mouseY = e.getY();

    if(mouseX>= 50 && mouseX<=200 && mouseY>=300 && mouseY<=450) {
      betMade = true;
      String[] options = new String[] {"1", "5", "10", "25", "100"};
      int response = JOptionPane.showOptionDialog(null, "Please select your bet!", "BETTING",
              JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
      if(response == 0) {
        currentBet = 1;
        currentBalance -= 1;
      }
      else if(response == 1) {
        currentBet = 5;
        currentBalance -= 5;
      }
      else if(response == 2) {
        currentBet = 10;
        currentBalance -= 10;
      }
      else if(response == 3) {
        currentBet = 25;
        currentBalance -= 25;
      }
      else if(response == 4) {
        currentBet = 100;
        currentBalance -= 100;
      }
      else {
        currentBet = 1;
        currentBalance -= 1;
        System.out.println("You haven't selected a bet. By default, the bet will be 1.");
      }

      System.out.println("You have selected your bet: " + currentBet + "." + " If you win, you will increase your current balance by " + currentBet +
              "; if the dealer wins, you will decrease your current balance by " + currentBet + ".");
      Tester.newGame.startGame();
    }

  }
  public void mouseExited(MouseEvent e) {

  }
  public void mouseEntered(MouseEvent e) {

  }
  public void mouseReleased(MouseEvent e) {

  }
  public void mouseClicked(MouseEvent e) {

  }
}