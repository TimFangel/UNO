package uno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Uno {
    public static void main(String[] args) throws IOException {
        // Enter data using BufferReader
        BufferedReader r = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Please enter the number of players!");
        // Reading data using readLine
        int numofPlayers = Integer.parseInt(r.readLine());

        System.out.println("Number of players: " + numofPlayers);

        Player[] players = new Player[numofPlayers];
        int[] cards = { 1, 2, 3 };

        for (int i = 0; i < numofPlayers; i++) {
            System.out.println("Please enter the name of player: " + (i + 1));
            String pName = r.readLine();
            players[i] = new Player(pName, cards);
            System.out.println("Player " + (i + 1) + " is called: " + players[i].getName());
        }
    }
}