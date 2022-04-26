import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;

public class Deck {
    private List<Card> cards;

    public Deck(int numOfDecks){
        cards = new LinkedList<Card>();
        for (int decNumber=0; decNumber < numOfDecks; decNumber++) {
            for(Suit suit: Suit.values()){
                for(Rank rank: Rank.values()){
                    if (rank == Rank.JOKER){
                        continue;
                    }
                    add(new Card(rank,suit));
                }
            }
        }
    }

    public void shuffle(){
        Random rand = new Random();
        int numOfCards = cards.size();
        for(int index = 0; index < numOfCards; index++){
            int j = index+rand.nextInt(numOfCards-index);
            Card temp = cards.get(index);
            cards.set(index,cards.get(j));
            cards.set(j,temp);
        }
    }

    public int size(){
        return cards.size();
    }

    public boolean isEmpty(){
        return cards.isEmpty();
    }

    public boolean remove(Card aCard){
        return cards.remove(aCard);
    }

    public void add(Card aCard){
        cards.add(aCard);
    }

    public Card deal(boolean faceUp){
        if (cards.isEmpty()){
            return null;
        }
        Card c = cards.remove(0);
        if (faceUp){
            c.show();
        }
        return c;
    }

    public void deal(Deck[] deck, int numOfCards, boolean isFaceUp){
        int maxCardCount = numOfCards*deck.length;
        for(int cardCount = 0; cardCount < maxCardCount; cardCount++){
            Card card = deal(isFaceUp);
            deck[cardCount % deck.length].add(card);
        }
    }

    public Iterator<Card> iterator(){
        return cards.iterator();
    }

    @Override
    public String toString() {
        String str = "";
        for(Card c: cards){
            if (str.length() > 0){
                str +=", ";
            }
            str += c;
        }
        return str;
    }
}
