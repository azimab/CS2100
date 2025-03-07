/**
 * A stack of more than one deck of cards used in a casino game
 *
 */
//Azim Abdulmajeeth
// zwf8qy@virginia.edu
// HW 4 - Blackjack
// none
public class DeckShoe {

    //An array of decks of cards that comprise this multi-deck.
    private Deck[] decks;

    // you may need other instance variables here


    //Constructor: instantiates the number of decks specified and
    //adds them to the list of decks
    public DeckShoe(int numDecks) {
        decks = new Deck[numDecks];
        for (int i = 0; i < numDecks; i++) {
            decks[i] = new Deck();
        }
    }


    //Deals the top card from the stack of decks and returns that Card.
    //You can implement this several ways, as long as it correctly
    //deals a card from one of the decks.
    //Important: if you've dealt the last card in all the decks, you'll want
    //to reshuffle all the decks and start over again
    public Card dealTopCard() {
        for (Deck deck : decks) {
            if (deck.cardsLeft() > 0) {
                return deck.dealTopCard();
            }
        }
        restoreDecks();
        return decks[0].dealTopCard();

    }


    //Reshuffles all of the decks.
    protected void restoreDecks() {
        for (Deck deck : decks) {
            deck.restockDeck();
        }
    }


    //returns the number of cards left to be dealt in the entire stack of cards.
    public int cardsLeft() {
        int sum = 0;
        for (Deck deck : decks) {
            sum += deck.cardsLeft();
        }
        return sum;
    }


}
