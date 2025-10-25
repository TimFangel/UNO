package uno.game;

import uno.cards.UnoCard;

public class Player {
    private String name;
    private UnoCard[] hand;

    public Player(String name, UnoCard[] cards) {
        this.name = name;
        this.hand = cards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addCards(UnoCard[] cards) {
        this.hand = cards;
    }

}
