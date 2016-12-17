/**
 * Created by edgardelgado on 12/12/16.
 */
import java.net.SocketPermission;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game
{
    public static void main(String[] argv)
    {
        Deck d = new Deck();
        d.shuffle();

        List<Card> player1 = new ArrayList<>();
        List<Card> player2 = new ArrayList<>();
        List<Card> player1Stack = new ArrayList<>();
        List<Card> player2Stack = new ArrayList<>();

        for(int i = 0; i < 26; i++)
        {
            player1.add(d.getCard(i));
        }
        for(int i = 26; i < 52; i++)
        {
            player2.add(d.getCard(i));
        }

        d.displayDeck();

        Scanner input = new Scanner(System.in);

        while(d.noMoreCards())
        {
            if(player1.size() == 0)
                System.out.println("Player Two Wins the Game!!!");
            else if (player2.size() == 0)
                System.out.println("Player One Wins the Game!!!");
            System.out.print("Player one turn");
            input.nextLine();
            d.displayCard(player1);
            System.out.println();
            System.out.print("Player two turn");
            input.nextLine();
            d.displayCard(player2);
            System.out.println();
            if(player1.get(0).getRank() > player2.get(0).getRank()) {
                System.out.println("Player one wins this battle");
                System.out.println();
                player2.remove(0);
                if(player1.size() == 0)
                    System.out.println("Player Two Wins the Game!!!");
                else if (player2.size() == 0)
                    System.out.println("Player One Wins the Game!!!");
                player1Stack.add(player1.get(0));
                player1Stack.add(player2.get(0));


               /* for(int i = 0; i < player1Stack.size(); i++)
                {
                    System.out.println(player1Stack.get(i).toString());
                }*/
            }
            else if(player1.get(0).getRank() == player2.get(0).getRank())
            {
                System.out.println("Its War time");
                System.out.print("Player one turn");
                input.nextLine();
                if(player1.size() >= 3)
                {
                    d.displaySkipCard(player1);
                    System.out.println();
                }
                else
                {
                    d.displayCard(player1);
                    System.out.println();
                }
                System.out.print("Player two turn");
                input.nextLine();
                if(player2.size() >= 3)
                {
                    d.displaySkipCard(player2);
                    System.out.println();
                }
                else
                {
                    d.displayCard(player2);
                    System.out.println();
                }
                if(player1.get(2).getRank() > player2.get(2).getRank())
                {
                    System.out.println("Player one wins this battle");
                    System.out.println();
                    player2.remove(0);
                    player2.remove(1);
                    player2.remove(2);
                    if(player1.size() == 0)
                        System.out.println("Player Two Wins the Game!!!");
                    else if (player2.size() == 0)
                        System.out.println("Player One Wins the Game!!!");
                    player1Stack.add(player1.get(0));
                    player1Stack.add(player2.get(0));
                    player1Stack.add(player1.get(1));
                    player1Stack.add(player2.get(1));
                    player1Stack.add(player1.get(2));
                    player1Stack.add(player2.get(2));
                }
                else
                {
                    System.out.println("Player two wins this battle");
                    System.out.println();
                    player1.remove(0);
                    player1.remove(1);
                    player1.remove(2);
                    player2Stack.add(player1.get(0));
                    player2Stack.add(player2.get(0));
                    player2Stack.add(player1.get(1));
                    player2Stack.add(player2.get(1));
                    player2Stack.add(player1.get(2));
                    player2Stack.add(player2.get(2));
                }
            }
            else
            {
                System.out.println("Player two wins this battle");
                System.out.println();
                player1.remove(0);
                if(player1.size() == 0)
                    System.out.println("Player Two Wins the Game!!!");
                else if (player2.size() == 0)
                    System.out.println("Player One Wins the Game!!!");
                player2Stack.add(player1.get(0));
                player2Stack.add(player2.get(0));
            }

        }
    }
}

