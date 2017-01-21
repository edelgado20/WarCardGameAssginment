/**
 * Created by edgardelgado on 12/12/16.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.io.*;

public class Game
{
    public static void main(String[] argv)
    {
        /*
        THE WAR CAR GAME ENDS WHEN ONE PLAYER HAS ALL THE CARDS.
        WHEN ONE PLAYER WINS A BATTLE, THEY MOVE ALL THE CARDS TO THE BOTTOM OF THEIR DECK.
         */
        int player1Wins = 0, player2Wins = 0;
        int battle = 0, war = 0, doubleWar = 0;
        int maxBattles = 0, minBattles = 1000, maxWars = 0, minWars = 100;
        for(int a = 0; a < 1000; ++a)
        {
            int battles = 0, wars = 0;
            Deck d = new Deck();
            d.shuffle();

            List<Card> player1 = new ArrayList<>();
            List<Card> player2 = new ArrayList<>();
            List<Card> temp = new ArrayList<>();
            boolean winner = false;

            // Adding the first 26 cards of the deck to player 1
            for(int i = 0; i < 26; i++)
            {
                player1.add(d.getCard(i));
            }
            // Adding the last 26 cards of the deck to player 2
            for(int i = 26; i < 52; i++)
            {
                player2.add(d.getCard(i));
            }

            //d.displayDeck();

            Scanner input = new Scanner(System.in);

            while(!winner) {
                ++battle;
                ++battles;
               // System.out.print("Player one turn\n");
              //  input.nextLine();
                d.displayCard(player1);
                System.out.println();
               // System.out.print("Player two turn\n");
             //   input.nextLine();
                d.displayCard(player2);
                System.out.println();

                // Player One has a higher card (wins the battle)
                if (player1.get(0).getRank() > player2.get(0).getRank()) {
                 //   System.out.println("Player one wins this battle");
                 //   System.out.println();

                    player1.add(player2.get(0)); // Added card to deck
                    Collections.rotate(player1, -1); // Moves winning card to the back of the deck
                    player2.remove(0); // Deleted card from deck

                    if (player2.size() == 0) {
                        System.out.println("Player One Wins the Game!!!");
                        winner = true;
                        ++player1Wins;
                    }

                }
                // Player Two has a higher card (wins the battle)
                else if (player1.get(0).getRank() < player2.get(0).getRank()) {
               //    System.out.println("Player two wins this battle");
               //     System.out.println();

                    player2.add(player1.get(0)); //Added card to deck
                    Collections.rotate(player2, -1); //Moves winning card to the back of the deck
                    player1.remove(0); //Deleted card from deck

                    if (player1.size() == 0) {
                        System.out.println("Player Two Wins the Game!!!");
                        winner = true;
                        ++player2Wins;
                    }
                } else // War Time (Players had the same card)
                {
                    if(player1.size() != 1) {
                        temp.add(player1.get(0));
                        player1.remove(0);
                    }
                    if(player2.size() != 1){
                        temp.add(player1.get(0));
                        player2.remove(0);
                    }
                    boolean battleIsDone = false;
                    int tempVar = 0;

                    do {
                        ++wars; // variable to keep count which game has the most wars
                        ++war; // variable to know the average of wars in a game
                        ++tempVar; // acts like a temp variable to show when how many double wars happen in a game
                        if(tempVar == 2) ++doubleWar;
               //         System.out.println("Its War time");
               //         System.out.print("Player one turn ");
               //         input.nextLine();

                        if (player1.size() >= 2) {
                            temp.add(player1.get(0));
                            player1.remove(0);
                            d.displayCard(player1);
              //              System.out.println();
                        } else {
                            d.displayCard(player1);
               //             System.out.println();
                        }

               //         System.out.print("Player two turn ");
                //        input.nextLine();
                        if (player2.size() >= 2){
                            temp.add(player2.get(0));
                            player2.remove(0);
                            d.displayCard(player2);
             //               System.out.println();
                        } else {
                            d.displayCard(player2);
             //               System.out.println();
                        }
                        if (player1.get(0).getRank() > player2.get(0).getRank()) {
              //              System.out.println("Player one wins this battle");
              //              System.out.println();

                            temp.add(player1.get(0));
                            temp.add(player2.get(0));
                            player1.remove(0);
                            player2.remove(0);
              //              System.out.println("Player One Deck Size: " + player1.size());
              //              System.out.println("\nPlayer Two Deck Size: " + player2.size());

                            player1.addAll(temp); // Adds all dealing cards to winning player (player 1)
                            temp.clear(); // To clear all the elements in the temp array list

                            if (player2.size() == 0) {
              //                  System.out.println("Player One Wins the Game!!!");
                                winner = true;
                                ++player1Wins;
                            }
                            battleIsDone = true; // Someone wins the battle (player 1)
                        } else if (player1.get(0).getRank() < player2.get(0).getRank()) {
               //             System.out.println("Player two wins this battle");
               //             System.out.println();

                            temp.add(player1.get(0));
                            temp.add(player2.get(0));
                            player1.remove(0);
                            player2.remove(0);

               //             System.out.println("Player One Deck Size: " + player1.size());
               //             System.out.println("\nPlayer Two Deck Size: " + player2.size());

                            player2.addAll(temp); // Adds all dealing cards to winning player (player 2)
                            temp.clear(); // Clears all elements borrowed in the temp array list

                            if (player1.size() == 0) {
               //                 System.out.println("Player TWO Wins the Game!!!");
                                winner = true;
                                ++player2Wins;
                            }
                            battleIsDone = true; // Condition till someone wins the battle (player 2)
                        }
                    } while (!battleIsDone);
                }
            }

            if(battles > maxBattles) maxBattles = battles;
            if(battles < minBattles) minBattles = battles;
            if(wars > maxWars) maxWars = wars;
            if(wars < minWars) minWars = wars;
        }
        PrintStream printer = null;
        OutputStream output = null;
        try {
            output = new FileOutputStream("stats.txt");
            printer = new PrintStream(output);
            printer.print("For 1000 games");
            printer.print("\nPlayer 1 wins " + player1Wins + " games");
            printer.print("\nPlayer 2 wins " + player2Wins + " games");
            printer.print("\nAverage number of battles per game: " + (double)battle/1000);
            printer.print("\nAverage number of wars per game: " + (double)war/1000);
            printer.print("\nAverage number of double wars per game: " + (double)doubleWar/1000);
            printer.print("\nMax number of battles in a game: " + maxBattles);
            printer.print("\nMin number of battles in a game: " + minBattles);
            printer.print("\nMax number of wars in a game: " + maxWars);
            printer.print("\nMin number of wars in a game: " + minWars);
            output.close();
        }
        catch (IOException e)
        {
            System.out.println("Exception");
        }
        printer.close();

        System.out.println("\nFor 1000 games");
        System.out.println("Player 1 wins " + player1Wins + " games");
        System.out.println("Player 2 wins " + player2Wins + " games");
        System.out.printf("Average number of battles per game: %.2f", + (double)battle/1000);
        System.out.printf("\nAverage number of wars per game: %.2f", + (double)war/1000);
        System.out.printf("\nAverage number of double wars per game: %.2f", + (double)doubleWar/1000);
        System.out.println("\nMax number of battles in a game: " + maxBattles);
        System.out.println("Min number of battles in a game: " + minBattles);
        System.out.println("Max number of wars in a game: " + maxWars);
        System.out.println("Min number of wars in a game: " + minWars);
    }
}

