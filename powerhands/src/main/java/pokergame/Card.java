package pokergame;

public class Card implements Comparable {

    private value value;
    private suit suit;

    public Card(Card.value value, Card.suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public int compareTo(Object o) {
        Card objP = (Card) o;
        return this.getValue().ordinal() - objP.getValue().ordinal();
    }

    public value getValue() {
        return value;
    }

    public suit getSuit() {
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

    public enum value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
    }

    public enum suit {
        HEARTS, SPADES, CLUBS, DIAMONDS;
    }
}
