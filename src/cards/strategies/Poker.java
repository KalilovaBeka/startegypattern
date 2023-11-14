package cards.strategies;


import cards.CardDealingStrategy;
import cards.trials.Deck;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Poker implements CardDealingStrategy {
    private Deck deck;
    private int cardsPerHand;

    public Poker(int cardsPerHand) {
        this.deck = new Deck();
        this.cardsPerHand = 5;
    }

    @Override
    public Map<String, List<cards.trials.Card>> dealStacks(Deck deck, int players) {
        List<cards.trials.Card> shuffledCards = deck.getDeckOfCards();
        Map<String, List<cards.trials.Card>> pokerStrategy = new HashMap<>();

        for(var i = 1; i<= players; i++){
            pokerStrategy.put("Player " + i, new ArrayList<>());
        }

        int count = 52;
        for(var i = 1; i <= cardsPerHand; i++){ // 1 round
            for(var j = 1; j <= players; j++){ // each player
              pokerStrategy.get("Player " + i).add(shuffledCards.get(count-1));
              count--;
            }
        }

        return pokerStrategy;
    }
}
