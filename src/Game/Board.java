package Game;

import java.util.List;
import java.util.ArrayList;

public abstract class Board {

    private ArrayList<Card> table;
    private Deck deck;
    private int blind;
    private int thePot;

    public Board(int size, int ante) {
        table = new ArrayList<Card>(size);
        blind = ante;
        thePot = 0;
        deck = new Deck();
    }
    
    public int bettingRound(){
        
    }

    public String[] getSuits() {
        return deck.getSuits();
    }

    public String[] getRanks() {
        return deck.getRanks();
    }

    public void dealCards(Card[] playerHand) {
        for (int i = 0; i < 2; i++) {
            playerHand[i] = deck.deal();
        }
    }

    public int getPot() {
        return thePot;
    }

    public void theFlop(ArrayList<Card> Deck) {
        for (int i = 0; i < 3; i++) {
            table.add(Deck.get(0));
            Deck.remove(0);
        }
    }

    public void turn(ArrayList<Card> Deck) {
        table.add(Deck.get(0));
        Deck.remove(0);
    }

    public void river(ArrayList<Card> Deck) {
        table.add(Deck.get(0));
        Deck.remove(0);
    }

    public void resetDeck() {

    }
}
