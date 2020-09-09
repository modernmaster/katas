package pokergame;

import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Poker {

    private static final int NUMBER_OF_CARDS = 5;
    private List<Card> cards;

    public List<Card> dealCards() {
        shuffleCards();
        return pickFiveCards();
    }

    private List<Card> pickFiveCards() {
        return cards.subList(0, NUMBER_OF_CARDS);
    }

    private void shuffleCards() {
        Collections.shuffle(cards);
    }

}
