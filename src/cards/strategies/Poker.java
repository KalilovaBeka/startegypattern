package cards.strategies;


import cards.CardDealingStrategy;
import cards.trials.Card;
import cards.trials.Deck;

import java.util.*;

public class Poker implements CardDealingStrategy {
    private Deck deck;
    private int cardsPerHand;

    public Poker(int cardsPerHand) {
        this.deck = new Deck();
        this.cardsPerHand = 5;
    }

    @Override
    public Map<String, List<cards.trials.Card>> dealStacks(Deck deck, int players) {
        Map<String, List<cards.trials.Card>> pokerStrategy = new HashMap<>();

        for(var i = 1; i<= players; i++){
            pokerStrategy.put("Player " + i, new ArrayList<>());
        }

        List<Card> restCards = deck.restCards();
        for(var j = 1; j <= players; j++){ // each player

            if(restCards.isEmpty()) return pokerStrategy;

            for(var i = 1; i <= cardsPerHand; i++){ // 1 round
                Optional<Card> card = deck.dealCard();
                if(card.isEmpty()){
                    break;
                }
              pokerStrategy.get("Player " + j).add(card.get());
            }
        }

        pokerStrategy.put("Rest Cards", restCards);
        return pokerStrategy;
    }
}
