package pokergame;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Card implements Comparable {

    private final VALUE value;
    private final SUIT suit;

    public int compareTo(final Object o) {
        Card objP = (Card) o;
        return this.getValue().ordinal() - objP.getValue().ordinal();
    }

    @Override
    public boolean equals(final Object obj) {
        Card objP = (Card) obj;
        return this.getValue().equals(objP.getValue()) && this.getSuit()
                .equals(objP.getSuit());
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public enum VALUE {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
    }

    public enum SUIT {
        HEARTS, SPADES, CLUBS, DIAMONDS;
    }
}
