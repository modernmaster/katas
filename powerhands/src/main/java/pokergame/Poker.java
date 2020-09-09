package pokergame;

import java.util.Collections;
import java.util.List;

public class Poker {

    private List<Card> cards;

    public Poker(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Card> dealCards() {
        shuffleCards();
        return pickFiveCards();
    }

    private List<Card> pickFiveCards() {
        return cards.subList(0, 5);
    }

    private void shuffleCards() {
        Collections.shuffle(cards);
    }

}
