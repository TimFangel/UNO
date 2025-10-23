package uno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

enum Color {
    RED, BLUE, GREEN, YELLOW
}

enum cardValue {
    ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, DRAWTWO, DRAWFOUR, REVERSE, WILDCARD, SKIP
}


public class Uno {
    public static void main (String[] args) throws IOException {
        // Enter data using BufferReader
        BufferedReader r = new BufferedReader(
            new InputStreamReader(System.in));

        System.out.println("Please enter the number of players!");
        // Reading data using readLine
        int numofPlayers = Integer.parseInt(r.readLine());

        System.out.println("Number of players: " + numofPlayers);

        Player[] players = new Player[numofPlayers];
        int[] cards = {1, 2, 3};

        for (int i = 0; i < numofPlayers; i++) {
            System.out.println("Please enter the name of player: " + (i + 1));
            String pName = r.readLine();
            players[i] = new Player(pName, cards);
            System.out.println("Player " + (i + 1) + " is called: " + players[i].getName());
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

} 

class Player {
    private String name;
    private int[] cards;

    public Player(String name, int[] cards) {
        this.name = name;
        this.cards = cards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}