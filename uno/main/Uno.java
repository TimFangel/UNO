package uno.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import uno.cards.UnoDeck;
import uno.game.Player;

public class Uno {
    public static void main(String[] args) throws IOException {
        int numofPlayers;
        BufferedReader r = new BufferedReader(
                new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.println("Please enter the number of players!");

                // Reading data using readLine
                numofPlayers = Integer.parseInt(r.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid integer!");
            }
        }

        System.out.println("Number of players: " + numofPlayers);

        // Create players and decks.
        Player[] players = new Player[numofPlayers];
        for (int i = 0; i < numofPlayers; i++) {
            String name = null;
            String confirm = "N";

            while (!confirm.equals("Y")) {
                System.out.println("Please enter the name of player:" + (i + 1));
                name = r.readLine();
                System.out.println("Player " + (i + 1) + " will be called: " + name + " (Y/N) to proceed.");
                confirm = r.readLine().toUpperCase();
            }
            players[i] = new Player(name);
        }
    }
}