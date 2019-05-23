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
    

    public String[] getSuits() {
        return deck.getSuits();
    }

    public String[] getRanks() {
        return deck.getRanks();
    }
    
    public int getAnte(){
        return blind;
    }

    public ArrayList<Card> dealCards() {
        ArrayList<Card> playerHand = new ArrayList<Card>(2);
        for (int i = 0; i < 2; i++) {
            playerHand.add(deck.deal());
        }
        return playerHand;
    }

    public int getPot() {
        return thePot;
    }

    public void addBet(int amount) {
        thePot += amount;
    }
    public void theFlop() {
        for (int i = 0; i < 3; i++) {
            table.add(deck.deal());
        }
    }

    public void turn() {
        table.add(deck.deal());
    }

    public void river() {
        table.add(deck.deal());
    }
    
    public int indexOfRank(String key){
        int index = -1;
        for(int i = 0; i < getRanks().length; i++){
            if(getRanks()[i].equals(key)){
                index = i;
                break;
            }
        }
        return index;
    }
    
    public int indesOfSuit(String key){
        int index = -1;
        for(int i = 0; i < getSuits().length; i++){
            if(getSuits()[i].equals(key)){
                index = i;
                break;
            }
        }
        return index;
    }
    public List<Card> getTable(){
        return table;
    }
}
