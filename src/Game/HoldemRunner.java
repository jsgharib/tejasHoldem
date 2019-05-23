package Game;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class HoldemRunner {

    public static String[] suits = {"clubs", "spades", "hearts", "diamonds"};
    public static String[] ranks = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};

    public static void main(String[] args) {
        game();
    }

    public static void game() {
        Holdem game = new Holdem(5);
        Scanner key = new Scanner(System.in);
        ArrayList<Card> hand = new ArrayList<Card>(2);
        player user = new player(hand, 1500);
        while (!user.didFold()) {
            hand = game.dealCards();
            System.out.print("Your cards are : " + hand.toString() + "\nPlayers are the dealer and you" + "\nAnte is " + game.getAnte() + "\nDo you want to call?");
            //String ans = key.nextLine();
            String ans = "yes";
            if (!ans.toLowerCase().equals("yes")) {
                System.out.println("You Folded");
                user.fold();
            }
            game.addBet(5);
            int bet = 5; //bettingRound();
            user.placeBet(bet);
            game.addBet(bet);
            System.out.println("The pot is " + game.getPot());
            game.theFlop();
            System.out.println(game.getTable().toString());
            
            game.clearDeck();
            hand = null;
            game.clearTable();
        }
    }

    public static int bettingRound() {
        Scanner key = new Scanner(System.in);
        System.out.println("Enter an amount you want to bet or 0 to call : ");
        return key.nextInt();
    }

    /*
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
     }*/
}
