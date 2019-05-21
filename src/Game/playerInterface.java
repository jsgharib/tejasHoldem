package Game;

import java.util.ArrayList;
import java.util.List;

public interface playerInterface {

    public void dealHand(Card temp);

    public void resetHand();

    public ArrayList<Card> getHand();

}
