package Game;

public class Card {

    private String suit;
    private String rank;

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

    public boolean matches(Card otherCard) {
        return otherCard.suit().equals(this.suit())
                && otherCard.rank().equals(this.rank());
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
