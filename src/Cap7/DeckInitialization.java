package Cap7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeckInitialization {

    public static void main(String[] args) {
        // Versão iterativa
        List<Card> deckIterative = initializeDeckIterative();
        System.out.println("Baralho (Iterativo): " + deckIterative);

        // Versão com streams
        List<Card> deckStream = initializeDeckStream();
        System.out.println("Baralho (Stream): " + deckStream);
    }

    // Versão iterativa: Usa loops for-each aninhados
    private static List<Card> initializeDeckIterative() {
        List<Card> deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }
        return deck;
    }

    // Versão com streams: Usa flatMap para criar o produto cartesiano de Rank e Suit
    private static List<Card> initializeDeckStream() {
        return Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Rank.values())
                        .map(rank -> new Card(rank, suit)))
                .collect(Collectors.toList());
    }

    // Enum para os naipes das cartas
    enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    // Enum para os valores das cartas
    enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    // Classe Card representando uma carta do baralho
    static class Card {
        private final Rank rank;
        private final Suit suit;

        public Card(Rank rank, Suit suit) {
            this.rank = rank;
            this.suit = suit;
        }

        @Override
        public String toString() {
            return rank + " of " + suit;
        }
    }
}
