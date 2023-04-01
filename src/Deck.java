import java.util.ArrayList;
import java.util.Collections;

public class Deck {
  
  private ArrayList<Card> deck;
  
  public Deck() {   
    deck = new ArrayList<Card>();
    
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 13; j++) {                                                  
        if (j == 0) {
          Card card = new Card(i, j, 11);
          deck.add(card);
        }
        else if (j >= 10) {
          Card card = new Card(i, j, 10);
          deck.add(card);
        }
        else {
          Card card = new Card(i, j, j+1);
          deck.add(card);
        } 
      }
    }
  }
  
  public void shuffleDeck() { //This method shuffles the deck to make the alignment of cards random.
    Collections.shuffle(deck); 
  }
  public Card getCard(int i) { //This method returns the ith (index) card of the deck.
    return deck.get(i); 
  }
  public Card removeCard(int i) { //This method removes the ith (index) card of the deck.
    return deck.remove(i); 
  }
}