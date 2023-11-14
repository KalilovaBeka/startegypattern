package cards.strategies;


import cards.Card;
import cards.CardDealingStrategy;
import cards.trials.Deck;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Poker implements CardDealingStrategy {
    private Deck deck;
    private int cardsPerHand;
    private int players;

    public Poker(int cardsPerHand) {
        this.deck = new Deck();
        this.cardsPerHand = 5;
        this.players = (int) Math.ceil(52.0 / cardsPerHand);
    }

    @Override
    public Map<String, List<cards.trials.Card>> dealStacks(Deck deck, int players) {
        List<cards.trials.Card> shuffledCards = deck.getDeckOfCards();
        Map<String, List<cards.trials.Card>> pokerStrategy = new HashMap<>();

        int count = 51;
        for (int round = 0; round >= 0; round++) {
            System.out.println("The " + round + " round.");
            for (int player = 1; player <= players; player++) {
                Card playersCard = (Card) shuffledCards.get(count);
                List<cards.trials.Card> cards = pokerStrategy.get("Player " + player);// if(cards == null){ cards = new ArrayList<>();}
                cards.add((cards.trials.Card) playersCard);
                pokerStrategy.put("Player " + player, cards);
                count--;
                if(count < 0) break;
            }//list = {{player1; 1card}, {player2; 2card}, {player3; 3card},
        }// {player1; 4card}, {player2; 5card}, {player3; 6card},}
        return pokerStrategy;
    }
}
