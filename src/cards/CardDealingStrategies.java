package cards;


import cards.strategies.Bridge;
import cards.strategies.Fool;
import cards.strategies.Poker;
import cards.strategies.TexasHoldem;
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
    int cardsPerPlayers = 2;//2 cards per player, 5 cards in additional "Community" stack.
    return new TexasHoldem(cardsPerPlayers);
  }

  public static CardDealingStrategy bridgeCardDealingStrategy() {
    int cardsPerPlayers = 13; //13 cards per player, no additional stacks.
    return new Bridge(cardsPerPlayers);
  }

  public static CardDealingStrategy foolCardDealingStrategy() {
    int cardsPerPlayers = 10; //6 cards per player, 1 card in additional "Trump card" stack.
    return new Fool(cardsPerPlayers);
  }

  //
  public static void main(String[] args) {
    Map<String, List<Card>> classicListMap = classicPokerCardDealingStrategy().dealStacks(
            new Deck(),
        5);
    System.out.println(classicListMap);

    Map<String, List<Card>> briLdgeistMap = bridgeCardDealingStrategy().dealStacks(
            new Deck(),
            5);
    System.out.println(briLdgeistMap);
    Map<String, List<Card>> foolListMap = foolCardDealingStrategy().dealStacks(
            new Deck("Trump card", 3),
            5);
    System.out.println(foolListMap);
    Map<String, List<Card>> texasListMap = texasHoldemCardDealingStrategy().dealStacks(
            new Deck("Community", 5),
            5);
    System.out.println(texasListMap);
  }
}
