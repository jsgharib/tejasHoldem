package Game;

import java.util.ArrayList;

public abstract class AbstractPlayer implements playerInterface {

    private ArrayList<Card> hand= new ArrayList<Card>();
    private int winCount;

    public AbstractPlayer(){
        
    }
    
    public void dealHand(Card temp) {
           hand.add(temp);
    }

    public void resetHand() {
        hand.clear();
    }

    public int getHandSize() {
        return hand.size();
    }
    
    public ArrayList<Card> getHand() {
        return hand;
    }

    public String toString() {
        return "hand = " + hand.toString() + " \n-  # wins " + winCount;
    }
}
