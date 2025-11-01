package uno.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import uno.cards.Color;
import uno.cards.UnoCard;
import uno.cards.UnoDeck;

public class Player {
    private String name;
    private ArrayList<UnoCard> hand = new ArrayList<UnoCard>();
    private boolean winner = false;

    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean getWinStatus() {
        return this.winner;
    }

    public boolean setWinStatus() {
        this.winner = true;
        return this.winner;
    }

    public int getHandSize() {
        return hand.size();
    }

    public void drawCards(UnoDeck deck, int drawCount) {
        for (int i = 0; i < drawCount; i++) {
            this.hand.add(deck.getTopCard());
            deck.removeCard(1);
        }
        drawCount = 0;
    }

    /**
     * Method to play from hand.
     * 
     * @param discardDeck discard deck.
     * @param drawDeck    draw deck.
     * @param cardToPlay  integer representing index to play.
     * @param drawCount   integer representing number of cards to draw.
     * @return true if valid play and false otherwise.
     */
    public boolean playCard(UnoDeck discardDeck, UnoDeck drawDeck, int cardToPlay, int drawCount) {
        if (cardToPlay == 0) {
            if (drawCount != 0) {
                drawCards(drawDeck, drawCount);
                return true;
            } else {
                drawCards(drawDeck, 1);
                return true;
            }
        } else if (hand.get(--cardToPlay).canBePlayedOn(discardDeck.getTopCard())) {
            discardDeck.addCard(hand.get(--cardToPlay));
            hand.remove(--cardToPlay);
            if (hand.size() == 0) {
                this.winner = true;
            }
            return true;
        }
        return false;
    }

    /**
     * Get a player's play for their turn.
     * 
     * @param discardDeck discard deck
     * @param drawDeck    draw deck
     * @param drawCount   integer representing number of cards to draw.
     */
    public void getPlay(UnoDeck discardDeck, UnoDeck drawDeck, int drawCount) {
        boolean playStatus = false;
        int play;
        do {
            System.out.println("Top card in discard pile: " + discardDeck.getTopCard());
            System.out.println("Choose your play!");
            if (drawCount != 0) {
                System.out.println("0: Draw " + drawCount + " cards");
            } else {
                System.out.println("0: Draw 1 card");
            }
            int i = 0;
            for (UnoCard card : hand) {
                System.out.println(i + ": Play " + card.getColor() + " " + card.getValue());
            }
            // Create buffered reader to read input.
            BufferedReader r = new BufferedReader(
                    new InputStreamReader(System.in));

            while (true) {
                try {
                    play = Integer.parseInt(r.readLine());
                    if (play >= 0 && play <= hand.size())
                        break;
                } catch (Exception e) {
                    System.out.println("Please enter a valid integer in range!");
                }
            }
            playStatus = playCard(discardDeck, drawDeck, play, drawCount);
        } while (!playStatus);
    }

}
