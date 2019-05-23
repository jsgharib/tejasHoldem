package Game;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class player extends AbstractPlayer {

    private ArrayList<Card> hand;
    private boolean check;
    private boolean fold;
    private int totalMoney;

    public player(ArrayList<Card> dealt, int startingCash) {
        hand = dealt;
        fold = false;
        totalMoney = startingCash;
    }
    
    public void placeBet(int bet){
        totalMoney -= bet;
    }
    
    public boolean didFold(){
        return fold;
    }
    
    public void fold(){
        fold = true;
    }

}
