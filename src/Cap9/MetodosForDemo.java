package Cap9;

import java.util.*;

public class MetodosForDemo {

    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    // Enum para os valores das cartas
    enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    public static void main(String[] args) {

        for (Suit suit : suits) {
            for (Rank rank : ranks) {
                System.out.println(suit + " " + rank);
            }
        }

        /*
        cin erri
        for (Iterator<Suit> i = suits.iterator(); i.hasNext();) {
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext();) {
                System.out.println(i.next() + " " + j.next());
            }
        }
         */

    }
}
