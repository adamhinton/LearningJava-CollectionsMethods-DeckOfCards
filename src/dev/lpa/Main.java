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

        Collections.reverse(deck);
        Card.printDeck(deck, "Sorted by rank, suit reversed", 13);

        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(kings, "Kings in deck", 1);        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck(tens,  "Kings in deck", 1);

        int subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist for tens = " + subListIndex);
        System.out.println("Contains = " + deck.containsAll(tens));

        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("disjoint: " + disjoint);

        boolean disjoint2 = Collections.disjoint(kings, tens);
        System.out.println("disjoint2: " + disjoint2);

        // List must be sorted before binarySearch
        // Because it searches based on the order used in .sort()
        // Brain melting
        // indexOf() doesn't need sorted
        deck.sort(sortingAlgo);
        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);
        int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgo);
        System.out.println("foundIndex: " + foundIndex);
        System.out.println("foundIndex = " + deck.indexOf(tenOfHearts));
        System.out.println(deck.get(foundIndex));

        Card tenClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
        Collections.replaceAll(deck, tenClubs, tenOfHearts);
        Card.printDeck(deck.subList(32, 36), "Tens row", 1);

        // List must be sorted before binarySearch
        Collections.replaceAll(deck, tenOfHearts, tenClubs);
        Card.printDeck(deck.subList(32, 36), "Tens row", 1);

        if (Collections.replaceAll(deck, tenOfHearts, tenClubs)){
            System.out.println("Hey hey true");
        }
        else{
            System.out.println("hey hey false");
        }

        System.out.println("Ten of clubs cards = " +
                Collections.frequency(deck, tenClubs));


        System.out.println("Best card = " + Collections.max(deck, sortingAlgo));
        System.out.println("Worst card = " + Collections.min(deck, sortingAlgo));

        var sortBySuit = Comparator.comparing(Card::suit).thenComparing(Card::rank);
        deck.sort(sortBySuit);
        Card.printDeck(deck, "Sorted by suit then rank", 4);

        List<Card> copied = new ArrayList<>(deck.subList(0, 13));
        Collections.rotate(copied, 2);
        System.out.println("Unrotated: " + deck.subList(0, 13));
        System.out.println("Rotated: " + 2 + copied);

    }
}