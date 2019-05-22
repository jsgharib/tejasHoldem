package Game;

import java.util.List;
import java.util.ArrayList;

public class Holdem extends Board {

    private List<Card> totalHand;

    public Holdem(int ante) {
        super(5, ante);
        totalHand = new ArrayList<Card>(7);
    }

    public List<Card> checkCards(List<Card> hand, List<Card> table) {
        ArrayList<Card> finalHand = new ArrayList<Card>();
        combineHands(hand, table);
        if (isDouble() && isTriple()) {
            finalHand.add(getTriple().get(0));
            finalHand.add(getTriple().get(1));
            finalHand.add(getTriple().get(2));
            finalHand.add(getDouble().get(0));
            finalHand.add(getDouble().get(1));
        } else if (isTriple()) {
            finalHand.add(getTriple().get(0));
            finalHand.add(getTriple().get(1));
            finalHand.add(getTriple().get(2));
        } else if (isDouble()) {
            finalHand.add(getDouble().get(0));
            finalHand.add(getDouble().get(1));
        } else {
            for (int i = 0; i < 5 - finalHand.size(); i++) {
                if (!finalHand.contains(totalHand.get(i))) {
                    finalHand.add(totalHand.get(i));
                }
            }
        }
        return finalHand;
    }

    public void combineHands(List<Card> hand, List<Card> table) {
        for (int i = 0; i < 7; i++) {
            if (i < 5) {
                totalHand.add(table.get(i));
            } else {
                totalHand.add(hand.get(i - 5));
            }
        }
    }

    public boolean isDouble() {
        for (int i = 0; i < 7; i++) {
            for (int j = i + 1; j < 7; j++) {
                if (totalHand.get(i).rank().equals(totalHand.get(j).rank())) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Card> getDouble() {
        List<Card> doubleCard = new ArrayList<Card>(2);
        doubleCard.add(0, new Card(null, null));
        doubleCard.add(1, new Card(null, null));
        for (int i = 0; i < 7; i++) {
            for (int j = i + 1; j < 7; j++) {
                if (totalHand.get(i).rank().equals(totalHand.get(j).rank()) && (!doubleCard.contains(totalHand.get(i)) || !doubleCard.contains(totalHand.get(j)))) {
                    if (doubleCard.get(0).rank() != null) {
                        if (indexOfRank(doubleCard.get(0).rank()) < indexOfRank(totalHand.get(i).rank())) {
                            doubleCard.clear();
                            doubleCard.add(0, totalHand.get(i));
                            doubleCard.add(1, totalHand.get(j));
                        }
                    } else {
                        doubleCard.add(0, totalHand.get(i));
                        doubleCard.add(1, totalHand.get(j));
                    }
                }
            }
        }
        return doubleCard;
    }

    public boolean isTriple() {
        for (int i = 0; i < 7; i++) {
            for (int j = i + 1; j < 7; j++) {
                for (int k = j + 1; k < 7; k++) {
                    if (totalHand.get(i).rank().equals(totalHand.get(j).rank()) && totalHand.get(i).rank().equals(totalHand.get(k).rank())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<Card> getTriple() {
        List<Card> doubleCard = new ArrayList<Card>(3);
        doubleCard.add(0, new Card(null, null));
        doubleCard.add(1, new Card(null, null));
        doubleCard.add(2, new Card(null, null));
        for (int i = 0; i < 7; i++) {
            for (int j = i + 1; j < 7; j++) {
                for (int k = j + 1; k < 7; k++) {
                    if (totalHand.get(i).rank().equals(totalHand.get(j).rank()) && totalHand.get(i).rank().equals(totalHand.get(k).rank()) && (!doubleCard.contains(totalHand.get(i)) || !doubleCard.contains(totalHand.get(j)) || !doubleCard.contains(totalHand.get(k)))) {
                        if (doubleCard.get(0).rank() != null) {
                            if (indexOfRank(doubleCard.get(0).rank()) < indexOfRank(totalHand.get(i).rank())) {
                                doubleCard.clear();
                                doubleCard.add(0, totalHand.get(i));
                                doubleCard.add(1, totalHand.get(j));
                                doubleCard.add(2, totalHand.get(k));
                            }
                        } else {
                            doubleCard.add(0, totalHand.get(i));
                            doubleCard.add(1, totalHand.get(j));
                            doubleCard.add(2, totalHand.get(k));
                        }
                    }
                }
            }
        }
        return doubleCard;
    }

    public List<Card> getRestOfHand(List<Card> cards) {
        List<Card> biggestHand = new ArrayList<Card>(5);
        int sameCard;
        for (Card c : cards) {
            biggestHand.add(c);
        }
        sameCard = biggestHand.size();
        for (int i = getRanks().length - 1; i >= 0; i--) {
            for (int j = getSuits().length - 1; j >= 0; j--) {
                for (Card c : totalHand) {
                    if (c.rank().equals(getRanks()[i]) && c.suit().equals(getSuits()[j]) && sameCard < 5 && !biggestHand.contains(c)) {
                        biggestHand.add(c);
                        sameCard++;
                    }
                }
            }
        }
        return biggestHand;
    }
}
