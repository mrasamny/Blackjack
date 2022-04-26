import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class Hand extends Deck {
    private  String name;

    public Hand(String name){
        super(0);
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Card throwCard() {
        return deal(true);
    }

    public void show(){
        Iterator<Card> iter = iterator();
        while(iter.hasNext()){
            Card aCard = iter.next();
            aCard.show();
        }
    }

    public void hide(){
        Iterator<Card> iter = iterator();
        while(iter.hasNext()){
            Card aCard = iter.next();
            aCard.hide();
        }
    }

    @Override
    public String toString() {
        String res = getName()+"'s hand: ";
        if (isEmpty()){
            res += "is empty";
        }
        return res+super.toString();
    }
}
