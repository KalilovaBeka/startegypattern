package cards.strategies;

import cards.CardDealingStrategy;
import cards.trials.Card;
import cards.trials.Deck;

import java.util.*;

public class TexasHoldem implements CardDealingStrategy {
    private Deck deck;
    private int cardsPerHand;

    public TexasHoldem(int cardsPerHand) {
        this.cardsPerHand = cardsPerHand;
        this.deck = new Deck();
    }

    @Override
    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
        Map<String, List<cards.trials.Card>> texasStrategy = new HashMap<>();

        for(var i = 1; i<= players; i++){
            texasStrategy.put("Player " + i, new ArrayList<>());
        }

        List<Card> restCards = deck.restCards();
        for(var j = 1; j <= players; j++){ // each player

            if(restCards.isEmpty()) return texasStrategy;

            for(var i = 1; i <= cardsPerHand; i++){ // 1 round
                Optional<Card> card = deck.dealCard();
                if(card.isEmpty()){
                    break;
                }
                texasStrategy.get("Player " + j).add(card.get());
            }
        }

        int stackSize = deck.size();
        texasStrategy.put(deck.getNameStack(), new ArrayList<>());
        for (int i = 0; i < stackSize; i++) {
            Optional<Card> card = deck.dealCard();
            if(card.isEmpty()) break;
            texasStrategy.get(deck.getNameStack()).add(card.get());
        }
        return texasStrategy;    }
}
