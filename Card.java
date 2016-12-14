/**
 * Created by edgardelgado on 12/12/16.
 */
public class Card {
    private int rank = 0;
    private Suit suit;

    Card(Suit suit, int rank)
    {
        this.rank= rank;
        this.suit = suit;
    }

    public void setRank(int rank)
    {
        this.rank = rank;
    }
    public int getRank()
    {
        return rank;
    }
    public void setSuit(Suit suit)
    {
        this.suit = suit;
    }
    public Suit getSuit()
    {
        return suit;
    }
    //public Card getCard()
    //{}

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit=" + suit +
                '}';
    }

}

