public class Card {
    private Rank rank;
    private Suit suit;
    private Boolean isFaceUp;

    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
        isFaceUp = false;
    }

    public Card(Rank rank, Suit suit, Boolean isFaceUp){
        this.rank = rank;
        this.suit = suit;
        this.isFaceUp = isFaceUp;
    }

    public void show(){
        isFaceUp = true;
    }

    public void hide(){
        isFaceUp = false;
    }

    public boolean isFaceUp(){
        return isFaceUp;
    }

    public Rank getRank(){
        return rank;
    }

    public Suit getSuit(){
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (rank != card.rank) return false;
        return suit == card.suit;
    }

    @Override
    public int hashCode() {
        int result = rank != null ? rank.hashCode() : 0;
        result = 31 * result + (suit != null ? suit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        if (isFaceUp){
            return ""+rank+suit;
        }
        return "??";
    }
}
