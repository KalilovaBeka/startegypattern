package cards;

import cards.trials.Card;

import java.util.List;
import java.util.Optional;

public interface Deck{
    Optional<Card> dealCard();
    List<cards.trials.Card> restCards();
    int size(); //size deck of cards
}
