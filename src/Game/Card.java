package Game;

public class Card {

    private String suit;
    private String rank;
    public static final String[] suits = {"clubs", "spades", "hearts", "diamonds"};
    public static final String[] ranks = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};

    public Card(String cardRank, String cardSuit) {
        rank = cardRank;
        suit = cardSuit;
    }

    public String suit() {
        return suit;
    }

    public String rank() {
        return rank;
    }
    public String suitNum() {
        return suit;
    }

    public String rankNum() {
        return rank;
    }

    public boolean matches(Card otherCard) {
        return otherCard.suit().equals(this.suit())
                && otherCard.rank().equals(this.rank());
    }
    
    public int rankCompareTo(Card c){
        return rank.indexOf(this.rank()) - rank.indexOf(c.rank());
    }
    public int suitCompareTo(Card c){
        return suit.indexOf(this.suit()) - suit.indexOf(c.suit());
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
