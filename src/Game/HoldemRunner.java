package Game;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HoldemRunner {

    public static String[] suits = {"clubs", "spades", "hearts", "diamonds"};
    public static String[] ranks = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
    public static int bet;
    public static boolean call;
    public static boolean fold = false;

    public static void main(String[] args) throws IOException {
        gameFrame gui = new gameFrame();
        gui.main(args);
        game(gui);
        //test();
    }

    public static void game(gameFrame gui) throws IOException {
        Holdem game = new Holdem(50);
        Scanner key = new Scanner(System.in);
        ArrayList<Card> hand = new ArrayList<Card>(2);
        player user = new player(hand, 1500);
        while (!fold) {
            hand = game.dealCards();
            System.out.println("Your cards are : " + hand.toString() + "\nPlayers are the dealer and you" + "\nAnte is " + game.getAnte() + "\nDo you want to call?");
            while (!gui.callPressed()) {
                System.out.print("");
            }
            gameFrame.callPressed = false;
            if (fold) {
                System.out.println("You Folded");
                break;
            }
            game.addBet(50);
            bettingRound(gui);
            System.out.println("Your bet : " + bet);
            user.placeBet(bet);
            game.addBet(bet);
            System.out.println("The pot is " + game.getPot());
            game.theFlop();
            System.out.println(game.getTable().toString());
            System.out.println("Your cards are : " + hand.toString() + "\nDo you want to call?");
            while (!gui.callPressed()) {
                System.out.print("");
            }
            gameFrame.callPressed= false;
            if (fold) {
                System.out.println("You Folded");
                break;
            }
            bettingRound(gui);
            user.placeBet(bet);
            game.addBet(bet);
            System.out.println("The pot is " + game.getPot());

            game.turn();
            System.out.println(game.getTable().toString());
            System.out.println("Your cards are : " + hand.toString() + "\nDo you want to call?");
            while (!gui.callPressed()) {
                System.out.print("");
            }
            gameFrame.callPressed = false;
            if (fold) {
                System.out.println("You Folded");
                break;
            }
            bettingRound(gui);
            user.placeBet(bet);
            game.addBet(bet);
            System.out.println("The pot is " + game.getPot());
            game.river();
            System.out.println(game.getTable().toString());
            System.out.println("Your cards are : " + hand.toString() + "\nDo you want to call?");
            while (!gui.callPressed()) {
                System.out.print("");
            }
            gameFrame.pressed = false;
            if (fold) {
                System.out.println("You Folded");
                break;
            }
            bettingRound(gui);
            user.placeBet(bet);
            game.addBet(bet);
            System.out.println("The pot is " + game.getPot());
            game.storePot();
            game.combineHands(hand, Board.table);
            List<Card> finalHand = new ArrayList<Card>(2);
            if(game.isDouble()){
                finalHand = game.getDouble();
                System.out.println("The double is the " + finalHand.get(0).toString() + " and the " + finalHand.get(1).toString());
            }
            else{
                System.out.println("No Doubles");
            }
            System.out.println("Game over");
            hand.clear();
            game.reset();
        }
        System.out.println("You folded.");
    }

    public static void bettingRound(gameFrame gui) {
        System.out.println("Enter an amount you want to bet or 0 to call");
        while (!gui.isPressed()) {
            System.out.print("");
        }
        gameFrame.pressed = false;
    }

    public static void test() {
        //public Card(String cardRank, String cardSuit)

        Holdem holdem = new Holdem(5);

        List<Card> testBoard = new ArrayList<Card>(10);

        int i, j;
        System.out.println("running1 ");

        for (int n = 0; n < 7; n++) {
            i = (int) (Math.random() * 12);
            j = (int) (Math.random() * 4);
            testBoard.add(new Card(ranks[i], suits[j]));
        }

        for (Card c : testBoard) {
            System.out.println(c.toString());
        }

        System.out.println("\nSorted Cards\n");

        holdem.rankSort(testBoard);

        for (Card c : testBoard) {
            System.out.println(c.toString());
        }
    }
}
