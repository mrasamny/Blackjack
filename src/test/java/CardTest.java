import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void show() {
        Card card = new Card(Rank.ACE,Suit.DIAMOND);
        card.show();
        assertEquals(card.toString(),Rank.ACE.toString()+Suit.DIAMOND.toString());
    }

    @Test
    void hide() {
        Card card = new Card(Rank.ACE,Suit.DIAMOND);
        card.hide();
        assertEquals(card.toString(),"??");
    }

    @Test
    void isFaceUp() {
        Card card = new Card(Rank.ACE,Suit.DIAMOND);
        assertFalse(card.isFaceUp());
        card.show();
        assertTrue(card.isFaceUp());
    }

    @Test
    void getRank() {
        Card card = new Card(Rank.ACE,Suit.DIAMOND);
        assertTrue(card.getRank() == Rank.ACE);
    }

    @Test
    void getSuit() {
        Card card = new Card(Rank.ACE,Suit.DIAMOND);
        assertTrue(card.getSuit() == Suit.DIAMOND);
    }


    @Test
    void testEquals() {
        Card card1 = new Card(Rank.ACE,Suit.DIAMOND);
        Card card2 = new Card(Rank.TWO,Suit.DIAMOND);
        Card card3 = new Card(Rank.ACE,Suit.DIAMOND);
        assertFalse(card1.equals(card2));
        assertTrue(card1.equals(card3));
    }

    @Test
    void testToString() {
        Card card = new Card(Rank.ACE,Suit.DIAMOND);
        assertEquals(card.toString(),"??");
        card.show();
        assertEquals(card.toString(),Rank.ACE.toString()+Suit.DIAMOND.toString());
    }
}