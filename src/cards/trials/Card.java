package cards.trials;

public class Card implements cards.Card {
    String suit;
    String rank;
    public Card(String cardSuit, String cardRank){
        this.suit = cardSuit;
        this.rank = cardRank;
    }
    @Override
    public String name() {
        return "'" + this.suit + " " + this.rank + "'";
    }
}
