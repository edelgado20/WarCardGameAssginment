/**
 * Created by edgardelgado on 12/12/16.
 */
import java.net.SocketPermission;
import java.util.ArrayList;
import java.util.List;

public class Game
{

    public static void main(String[] argv)
    {

        Deck d = new Deck();
        d.shuffle();

        List<Card> player1 = new ArrayList<>();
        List<Card> player2 = new ArrayList<>();

        for(int i = 0; i < 26; i++)
        {
            player1.add(d.getCard(i));
        }
        for(int i = 26; i < 52; i++)
        {
            player2.add(d.getCard(i));
        }

        d.displayDeck();
        System.out.println("|");
        System.out.println("|");

        for(int i = 0; i < 26; i++)
        {
            System.out.println(player1.get(i).toString());
        }
        System.out.println("|");
        System.out.println("|");
        for(int i = 0; i < 26; i++)
        {
            System.out.println(player2.get(i).toString());
        }

    }
}
