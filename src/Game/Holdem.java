package Game;

import java.util.List;
import java.util.ArrayList;

public class Holdem extends Board {
    private List<Card> totalHand;

    public Holdem(int ante) {
        super(5, ante);
        totalHand = new ArrayList<Card>(7);
    }
    

    public void combineHands(List<Card> hand, List<Card> table) {
        for (int i = 0; i < 7; i++) {
            if (i < 5) {
                totalHand.add(table.get(i));
            } else {
                totalHand.add(hand.get(i-5));
            }
        }
    }

    public List<Card> isDouble() {
        List<Card> biggestHand = new ArrayList<Card>(5);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (totalHand.get(i).rank().equals(totalHand.get(j).rank()) && i != j && !biggestHand.contains(totalHand.get(i))&& !biggestHand.contains(totalHand.get(j))) {
                    biggestHand.add(totalHand.get(i));
                    biggestHand.add(totalHand.get(j));
                    break;
                }
            }
        }
        return getRestOfHand(biggestHand);
    }

    public List<Card> isThreeOfAKind() {
        List<Card> biggestHand = new ArrayList<Card>(5);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                for (int k = 0; k < 7; k++) {
                    if (totalHand.get(i).rank().equals(totalHand.get(j).rank()) && totalHand.get(i).rank().equals(totalHand.get(k).rank()) && k != i && i != j && !biggestHand.contains(totalHand.get(i))&& !biggestHand.contains(totalHand.get(k))&& !biggestHand.contains(totalHand.get(j))) {
                        biggestHand.add(totalHand.get(i));
                        biggestHand.add(totalHand.get(j));
                        biggestHand.add(totalHand.get(k));
                        break;
                    }
                }
            }
        }
        return getRestOfHand(biggestHand);
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
