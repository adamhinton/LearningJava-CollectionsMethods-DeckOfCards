package dev.lpa;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');

        Arrays.fill(cardArray, aceOfHearts);

        Card.printDeck(Arrays.asList(cardArray), "Aces of Hearts", 1);


        // Doesn't populate with null refs
        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHearts);
        System.out.println(cards);
        System.out.println("size:" + cards.size());

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts, "Aces of Hearts", 1);

        Card kClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> ksOfClubs = Collections.nCopies(13, kClubs);
        Card.printDeck(ksOfClubs, "Kings of Clubs", 1);

        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card collection with Aces added", 2);

         Collections.copy(cards, ksOfClubs);
         Card.printDeck(cards, "Card Collection w Kings copied", 2);


         cards = List.copyOf(ksOfClubs);
         Card.printDeck(cards, "List copy of Kings", 1);

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled Deck", 4);

        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed Deck", 4);

        var sortingAlgo = Comparator.comparing(Card::rank).thenComparing(Card::suit);
        Collections.sort(deck, sortingAlgo);
        Card.printDeck(deck, "Standard deck sorted by rank, suit", 13);
    }
}