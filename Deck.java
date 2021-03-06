/**
 * Created by edgardelgado on 12/12/16.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Deck {
    List<Card> cards = new ArrayList<>();

    // The default constructor calls the shuffleCards method
    // which initializes the cards on the list
    public Deck()
    {
        shuffleCards();
    }
    // Calls the addSuit method and uses the Suit Enum
    private void shuffleCards()
    {
        addSuit(Suit.CLUBS);
        addSuit(Suit.DIAMONDS);
        addSuit(Suit.HEARTS);
        addSuit(Suit.SPADES);
    }
    // Adds a Suit and a value to each card
    // Goes from 2 to 14 (11=Jack, 12=Queen, 13=King, 14=Ace)
    private void addSuit(Suit suit)
    {
        for(int i = 2; i <= 14; i++)
            cards.add(new Card(suit,i));
    }

    public void displayDeck()
    {
        for(Card c : cards)
            System.out.println(c.toString());
    }
    // Shuffles the deck of cards
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    public Card getCard(int i)
    {
        return cards.get(i);
    }
    // Checks if there is no more cards on the deck
    public boolean noMoreCards()
    {
        if(cards.size() == 0)
            return true;
        else
            return false;
    }
    // Displays players card one by one
    public void displayCard(List<Card> cards)
    {
        System.out.println(cards.get(0));
    }

    public void displaySkipCard(List<Card> cards)
    {
        System.out.println(cards.get(2));
    }

}
