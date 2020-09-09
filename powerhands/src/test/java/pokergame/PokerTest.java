package pokergame;

import pokergame.Card.suit;
import pokergame.Card.value;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.IsEqual.equalTo;

public class PokerTest {


    private Poker poker;
    private Player player1;
    private Player player2;

    @Before
    public void setup() {
        poker = new Poker(createCards());
        player1 = new Player();
        player2 = new Player();
    }

    private List<Card> createCards() {
        List<Card> cards = new ArrayList<Card>();
        value[] values = value.values();
        suit[] suits = suit.values();
        for (int i = 0; i <= 12; i++) {
            for (int j = 0; j <= 3; j++) {
                cards.add(new Card(values[i], suits[j]));
            }
        }
        return cards;
    }

    @Test
    public void deckHas52Cards() {
        int result = poker.getCards().size();

        assertThat(result, equalTo(52));
    }

    @Test
    public void testMustContainAtleastOneDiamondSpadeHeartClub() {
        List<Card> cards = poker.getCards();
        for (Card card : cards) {
            assertThat(card.getSuit(), isA(suit.class));
        }
    }

    @Test
    public void testCardMustContainAValue() {
        List<Card> cards = poker.getCards();
        for (Card card : cards) {
            assertThat(card.getValue(), isA(value.class));
        }
    }

    @Test
    public void testAceHigherThanTwo() {
        Card cardAce = new Card(value.ACE, suit.HEARTS);
        Card cardTwo = new Card(value.FOUR, suit.HEARTS);
        cardAce.compareTo(cardTwo);
        assertThat(cardAce.compareTo(cardTwo), greaterThan(0));
    }

    @Test
    public void testAPokerHandConsistsOf5CardsDealtFromDeck() {
        List<Card> dealtCards = poker.dealCards();
        assertThat(dealtCards.size(), equalTo(5));
    }

    @Test
    public void testAllCardsAreUniqueFromPokerHand() {
        List<Card> dealtCards = poker.dealCards();
        Set<Card> uniqueDealtCards = new HashSet<Card>(dealtCards);
        assertThat(uniqueDealtCards.size(), equalTo(5));
    }

    @Test
    public void testTwoPlayersHaveTwoSetsOfFiveCards() {
        player1.setDealCards(poker.dealCards());
        player2.setDealCards(poker.dealCards());
        assertThat(player1.getDealCards().size(), equalTo(5));
        assertThat(player2.getDealCards().size(), equalTo(5));
    }

    @Test
    public void testCardsDealtAreSorted() {
        player1.setDealCards(poker.dealCards());
        player1.sortDealCards();
        for (int i = 0; i < 4; i++) {
            assertThat(player1.getDealCards().get(i), lessThanOrEqualTo(player1.getDealCards().get(i + 1)));
        }
    }

}
