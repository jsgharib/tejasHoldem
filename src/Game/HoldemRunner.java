package Game;


import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class HoldemRunner {
    
    public static String[] suits = {"clubs", "spades", "hearts", "diamonds"};
    public static String[] ranks = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
    
        public static void main(String[] args) {
            test();
        }
        
        public static void game(){
            Holdem game = new Holdem(5);
            
        }
        public static void test(){
 //public Card(String cardRank, String cardSuit)
            
            Holdem holdem = new Holdem(5);
            
            List<Card> testHand = new ArrayList<Card>(2);
            List<Card> testBoard = new ArrayList<Card>(5);
            List<Card> testedHand = new ArrayList<Card>(5);
            
          int i = 6;
          int j = 2;
          testHand.add(new Card(ranks[i], suits[j]));
            
          i = 6;
          j = 1;
          testHand.add(new Card(ranks[i], suits[j]));
            
          i = 4;
          j = 3;
          testBoard.add(new Card(ranks[i], suits[j]));
            
          i = 2;
          j = 2;
          testBoard.add(new Card(ranks[i], suits[j]));
            
          i = 2;
          j = 3;
          testBoard.add(new Card(ranks[i], suits[j]));
           
          i = 2;
          j = 1;
          testBoard.add(new Card(ranks[i], suits[j]));
           
          i = 9;
          j = 3;
          testBoard.add(new Card(ranks[i], suits[j]));
            
            testedHand = holdem.checkCards(testHand,testBoard);
            for(Card c : testedHand){
                System.out.println(c);
            }
        }
}
