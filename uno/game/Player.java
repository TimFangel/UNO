package uno.game;

import java.util.ArrayList;
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
    }

    /*
     * TODO: playcard, drawcard, exception????
     */
    public void playCard(UnoDeck deck, int cardToPlay) throws Exception {
        if (hand.get(cardToPlay).canBePlayedOn(deck.getTopCard())) {
            deck.addCard(hand.get(cardToPlay));
            hand.remove(cardToPlay);
            if (hand.size() == 0) {
                this.winner = true;
            }
        }
    }

}
