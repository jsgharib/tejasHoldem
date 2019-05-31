package Game;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class player extends AbstractPlayer {

    public ArrayList<Card> hand;
    public boolean check;
    public static boolean fold;
    public int totalMoney;

    public player(ArrayList<Card> dealt, int startingCash) {
        hand = dealt;
        fold = false;
        totalMoney = startingCash;
    }
    public player(){
        
    }

    public void placeBet(int bet) {
        totalMoney -= bet;
    }

    public boolean didFold() {
        return fold;
    }

    public void fold() {
        fold = true;
    }

}
