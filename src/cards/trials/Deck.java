package cards.trials;

import java.util.*;

public class Deck implements cards.Deck {
    private List<Card> deckOfCards;
    private String nameStack;
    private int stackSize;

    public Deck(String nameStack, int stackSize) {
        this.nameStack = nameStack;
        this.stackSize = stackSize;
        this.deckOfCards = getShuffledDeckOfCards();
    }
    public Deck() {
        this.deckOfCards = getShuffledDeckOfCards();
    }
    private List<Card> getShuffledDeckOfCards() {
        List<Card> deck = new ArrayList<>();
        String[] suits = {"Diamonds", "Clubs", "Hearts", "Spades"};
        String[] ranks = {"King", "Queen", "Jack", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Deuce", "Ace"};
        for (String s : suits) {
            for (String r : ranks) {
                Card card = new Card(s, r);
                deck.add(card);
            }
        }
        Collections.shuffle(deck);
        return deck;
    }

    public String getNameStack() {
        return nameStack;
    }

    @Override
    public int size() {
        return stackSize;
    }

    @Override
    public Optional<Card> dealCard() {
        if(deckOfCards.isEmpty()){
            return Optional.empty();
        }
        Card card = deckOfCards.get(deckOfCards.size() - 1);
        deckOfCards.remove(card);
        return Optional.ofNullable(card);
    }

    @Override
    public List<cards.trials.Card> restCards() {
        if(deckOfCards.isEmpty()){
            return Collections.emptyList();
        }
        return deckOfCards;
    }

}