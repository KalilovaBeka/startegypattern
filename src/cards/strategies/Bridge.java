package cards.strategies;

import cards.CardDealingStrategy;
import cards.trials.Card;
import cards.trials.Deck;

import java.util.*;

public class Bridge implements CardDealingStrategy {
    private int cardsPerHand;
    private Deck deck;

    public Bridge(int cardsPerHand) {
        this.cardsPerHand = cardsPerHand;
        deck = new Deck();
    }

    @Override
    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
        Map<String, List<cards.trials.Card>> bridgeStrategy = new HashMap<>();

        for(var i = 1; i<= players; i++){
            bridgeStrategy.put("Player " + i, new ArrayList<>());
        }

        List<Card> restCards = deck.restCards();
        for(var j = 1; j <= players; j++){ // each player

            if(restCards.isEmpty()) return bridgeStrategy;

            for(var i = 1; i <= cardsPerHand; i++){ // 1 round
                Optional<Card> card = deck.dealCard();
                if(card.isEmpty()){
                    break;
                }
                bridgeStrategy.get("Player " + j).add(card.get());
            }
        }

        bridgeStrategy.put("Rest Cards", restCards);
        return bridgeStrategy;
    }
}
