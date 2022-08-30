package pokergame;

import java.util.Collections;
import java.util.List;

public class Poker {

  public List<Card> getCards() {
    return cards;
  }

  private List<Card> cards;
  private static final int FIVE_CARDS = 5;

  public Poker(List<Card> cards) {
    this.cards = cards;
  }

  public List<Card> dealCards() {
    shuffleCards();
    return pickFiveCards();
  }

  private List<Card> pickFiveCards() {
    return cards.subList(0, FIVE_CARDS);
  }

  private void shuffleCards() {
    Collections.shuffle(cards);
  }

}
