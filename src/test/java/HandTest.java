import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void getName() {
        Hand hand = new Hand("Player");
        assertEquals("Player",hand.getName());
    }

    @Test
    void throwCard() {
        Hand hand = new Hand("Player");
        hand.add(new Card(Rank.TWO,Suit.CLUB));
        hand.add(new Card(Rank.THREE,Suit.CLUB));
        assertTrue(hand.throwCard().equals(new Card(Rank.TWO,Suit.CLUB)));
        assertTrue(hand.throwCard().equals(new Card(Rank.THREE,Suit.CLUB)));
        // need more tests
    }

    @Test
    void show() {
        // need more tests
    }

    @Test
    void hide() {
        // need more tests
    }
}