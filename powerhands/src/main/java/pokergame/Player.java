package pokergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {


  public void setDealCards(List<Card> dealCards) {
    this.dealCards = dealCards;
  }

  private List<Card> dealCards;

  public List<Card> getDealCards() {
    return dealCards;

  }

  public void sortDealCards() {
    Collections.sort(dealCards);
  }
}
