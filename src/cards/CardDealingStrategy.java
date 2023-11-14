package cards;


import java.util.List;
import java.util.Map;

public interface CardDealingStrategy {
    Map<String, List<cards.trials.Card>> dealStacks(cards.trials.Deck deck, int players);
}
