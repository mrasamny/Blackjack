import java.util.Iterator;

public class BlackJackHand extends Hand{
    public static final int BLACKJACK = 22;
    public static final int BUST = -1;

    private int weight;

    public BlackJackHand(String name){
        super(name);
        weight = 0;
    }

    private void calculateWeight() {
        int[] weights = {0,0};
        Iterator<Card> iter = iterator();
        while(iter.hasNext() && Math.min(weights[0],weights[1]) <= 21){
            Card card = iter.next();
            if (!card.isFaceUp()){
                continue;
            }
            int cardWeight = getCardWeight(card);
            if ( cardWeight <= 10){
                weights[0] += cardWeight;
                weights[1] += cardWeight;
            } else if (cardWeight == 11) { // ACE
                if (Math.max(weights[0], weights[1]) + 11 > 21) {
                    weights[0] = Math.min(weights[0], weights[1]) + 1;
                    weights[1] = weights[0] - 1 + 11;
                } else {
                    weights[0] += 1;
                    weights[1] += 11;
                }
            }
        }
        // calculate the weight of the hand
        this.weight = Math.max(weights[0],weights[1]);
        if (this.weight > 21){
            this.weight = Math.min(weights[0],weights[1]);
        }
        // check for Black Jack or Bust
        if (this.weight > 21){
            this.weight = BUST;
        } else if (size() == 2 && this.weight == 21){
            this.weight = BLACKJACK;
        }
    }

    private int getCardWeight(Card aCard) {
        int value = 0;
        if (aCard == null){
            return value;
        }
        Rank rank = aCard.getRank();

        if (rank == Rank.JOKER){
            value = 0;
        } else if (rank == Rank.ACE){
            value = 11;
        }else if (rank == Rank.JACK || rank == Rank.QUEEN || rank == Rank.KING) {
            value = 10;
        } else {
            value = rank.getRank();
        }
        return value;
    }

    public int getWeight(){
        return weight;
    }

    @Override
    public void add(Card aCard){
        super.add(aCard);
        calculateWeight();
    }

    @Override
    public void show(){
        super.show();
        calculateWeight();
    }

    @Override
    public String toString() {
        String res = getName()+"'s hand: ";
        if (!isEmpty()){
            res += super.toString() + " = ";
            if (weight == BLACKJACK){
                res += "Blackjack!";
            } else if (weight == BUST){
                res += "Bust!";
            } else {
                res += weight;
            }
            return res;
        }
        return "is empty";
    }
}
