package Game;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class player extends AbstractPlayer {

    private ArrayList<Card> hand;
    private int bet;
    private boolean check;
    private boolean fold;
    private int totalMoney;

    public player(ArrayList<Card> dealt, int startingCash) {
        hand = dealt;
        totalMoney = startingCash;
    }
    
    public void increasebet(int amount){
        bet += amount;
    }
    
    public void setBet(int amount){
        bet = amount;
    }
    
    public void fold(){
        fold = true;
    }

}
