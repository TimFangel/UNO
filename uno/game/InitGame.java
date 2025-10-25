package uno.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import uno.cards.UnoDeck;

public class InitGame {
    public static void main() {
        // Enter data using BufferReader
        BufferedReader r = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Please enter the number of players!");

        // Reading data using readLine
        int numofPlayers = Integer.parseInt(r.readLine());

        System.out.println("Number of players: " + numofPlayers);

        // Create players and decks.
        Player[] players = new Player[numofPlayers];
        UnoDeck drawPile = new UnoDeck();
        UnoDeck discrdPile = new UnoDeck();

        // Get player names.
        for (int i = 0; i < numofPlayers; i++) {
            System.out.println("Please enter the name of player: " + (i + 1));
            String pName = r.readLine();
            players[i] = new Player(pName, cards);
            System.out.println("Player " + (i + 1) + " is called: " + players[i].getName());
        }
    }
}
