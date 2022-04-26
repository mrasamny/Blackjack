public abstract class CardGame {
    private int numberOfDecks;
    private Deck gameDeck;

    public CardGame(int numberOfDecks){
        this.numberOfDecks = numberOfDecks;
        newGame();
    }

    public Deck getGameDeck(){
        return gameDeck;
    }

    public void newGame(){
        gameDeck = new Deck(numberOfDecks);
        gameDeck.shuffle();
    }
}
