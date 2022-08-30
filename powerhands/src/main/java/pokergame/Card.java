package pokergame;

public class Card implements Comparable {

  private VALUE value;

  public int compareTo(Object o) {
    Card objP = (Card) o;
    return this.getValue().ordinal() - objP.getValue().ordinal();
  }

  public Card(VALUE value, SUIT suit) {
    this.value = value;
    this.suit = suit;
  }
  private SUIT suit;

  public VALUE getValue() {
    return value;
  }

  public enum VALUE {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
  }

  public enum SUIT {
    HEARTS, SPADES, CLUBS, DIAMONDS;
  }

  public SUIT getSuit() {
    return suit;
  }

  @Override
  public boolean equals(Object obj) {
    Card objP = (Card) obj;
    return this.getValue().equals(objP.getValue()) && this.getSuit()
        .equals(objP.getSuit());
  }

  @Override
  public int hashCode() {
    return 1;
  }
}
