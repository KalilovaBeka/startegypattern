package cards.trials;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck implements cards.Deck {
    private List<Card> deckOfCards;

    public Deck() {
        this.deckOfCards = getShuffledDeckOfCards();
    }
    public List<Card> getDeckOfCards(){
        return this.deckOfCards;
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

    @Override
    public cards.Card dealCard() {
        return null;
    }

    @Override
    public List<cards.Card> restCards() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}