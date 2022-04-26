import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void shuffle() {

    }

    @Test
    void size() {
        Deck deck = new Deck(0);
        Card card = new Card(Rank.KING,Suit.CLUB);
        deck.add(card);
        assertEquals(1,deck.size());
        // more tests needed
    }

    @Test
    void isEmpty() {
        Deck deck = new Deck(0);
        assertTrue(deck.isEmpty());
        deck = new Deck(1);
        assertFalse(deck.isEmpty());
    }

    @Test
    void remove() {
        Deck deck = new Deck(1);
        assertTrue(deck.remove(new Card(Rank.ACE,Suit.DIAMOND)));
        assertFalse(deck.remove(new Card(Rank.ACE,Suit.DIAMOND)));
        // more tests needed
    }

    @Test
    void add() {
        Deck deck = new Deck(0);
        Card card = new Card(Rank.KING,Suit.CLUB);
        card.show();
        deck.add(card);
        assertEquals(Rank.KING.toString()+Suit.CLUB.toString(),deck.toString());
        // more tests needed
    }

    @Test
    void deal() {
        Deck deck = new Deck(0);
        assertNull(deck.deal(false));
        deck = new Deck(1);
        Card actual = deck.deal(true);
        Card expected = new Card(Rank.ACE, Suit.CLUB);
        expected.show();
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    void testToString() {
        Deck deck = new Deck(1);
        String expected = "";
        for(Suit s: Suit.values()){
            for(Rank rank: Rank.values()){
                if (rank == Rank.JOKER){
                    continue;
                }
                if (expected.length() > 0){
                    expected += ", ";
                }
                expected += rank.toString()+s.toString();
            }
        }
        Iterator<Card> iter = deck.iterator();
        while(iter.hasNext()){
            iter.next().show();
        }
        assertEquals(expected,deck.toString());
    }
}