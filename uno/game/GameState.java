package uno.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import uno.cards.UnoDeck;

public class GameState {
    private ArrayList<Player> rankings;
    private Player[] players;
    private UnoDeck discardPile;
    private UnoDeck drawPile;
    private int turn = 0;
    private int drawCount = 0;

    public GameState() {
        this.discardPile = new UnoDeck(false);
        this.drawPile = new UnoDeck(true);
        try {
            initPlayers();
            printPlayers();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getTurn() {
        return this.turn;
    }

    public void printTurn() {
        System.out.println("Player: " + (getTurn() + 1) + "\'s turn!");
    }

    public void printPlayers() {
        System.out.println("List of players:");
        for (Player player : players) {
            System.out.println(player.getName());
        }
    }

    /**
     * Method updating current player turn.
     */
    public void updateTurn() {
        while (true) {
            this.turn++;

            // Go to front of array if currently at end.
            if (this.turn > players.length)
                this.turn = 0;

            // If player finished continue
            if (players[turn].getWinStatus() == true)
                continue;

            // Game finished and add last player to
            if (rankings.size() == players.length - 1) {
                playerFinished();
                break;
            }

            break;
        }
    }

    /**
     * Function initializing all players.
     * 
     * @throws IOException thrown on wrong input for number of players.
     */
    public void initPlayers() throws IOException {
        int numofPlayers;
        // Create buffered reader to read input.
        BufferedReader r = new BufferedReader(
                new InputStreamReader(System.in));

        // Get number of players.
        while (true) {
            try {
                System.out.println("Please enter the number of players! (MIN: 2, MAX: 10)");

                // Reading data using readLine
                numofPlayers = Integer.parseInt(r.readLine());
                if (numofPlayers >= 2 && numofPlayers <= 10)
                    break;
            } catch (Exception e) {
                System.out.println("Please enter a valid integer in range!");
            }
        }

        System.out.println("Number of players: " + numofPlayers);

        // Get player names and create players
        this.players = new Player[numofPlayers];
        for (int i = 0; i < numofPlayers; i++) {
            String name = null;
            String confirm = "N";

            while (!confirm.equals("Y")) {
                System.out.println("Please enter the name of player: " + (i + 1));
                name = r.readLine();
                System.out.println("Player " + (i + 1) + " will be called: " + name + " (Y/N) to proceed.");
                confirm = r.readLine().toUpperCase();
            }
            this.players[i] = new Player(name);
        }
    }

    /**
     * Prints player rankings at the end of the game.
     */
    public void printRankings() {
        System.out.println("Rankings of this game:");
        for (int i = 0; i < rankings.size(); i++) {
            System.out.println((i + 1) + " " + rankings.get(i));
        }
    }

    /**
     * Adds finished player to rankings.
     */
    public void playerFinished() {
        rankings.add(players[this.turn]);
    }

    public void playGame() {

    }
}
