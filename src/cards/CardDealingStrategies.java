package cards;


import cards.strategies.Poker;
import cards.trials.Card;
import cards.trials.Deck;
import java.util.List;
import java.util.Map;

public class CardDealingStrategies {

  public static CardDealingStrategy classicPokerCardDealingStrategy() {
    int cardsPerPlayers = 5; //returns a CardDealingStrategy for Classic Poker.//5 cards per player, no additional stacks.
    return new Poker(cardsPerPlayers);
  }

  public static CardDealingStrategy texasHoldemCardDealingStrategy() {
    throw new UnsupportedOperationException();
  }

  public static CardDealingStrategy bridgeCardDealingStrategy() {
    throw new UnsupportedOperationException();
  }

  public static CardDealingStrategy foolCardDealingStrategy() {
    throw new UnsupportedOperationException();
  }

  //
  public static void main(String[] args) {
    Map<String, List<Card>> stringListMap = classicPokerCardDealingStrategy().dealStacks(new Deck(),
        5);
    System.out.println(stringListMap);
  }
}
