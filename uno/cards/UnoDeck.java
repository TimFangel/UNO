package uno.cards;

import uno.cards.Color;
import uno.cards.Value;
import uno.cards.special_cards.DrawFour;
import uno.cards.special_cards.DrawTwo;
import uno.cards.special_cards.Reverse;
import uno.cards.special_cards.Skip;
import uno.cards.special_cards.Wild;
import uno.cards.UnoCard;

public class UnoDeck {

    private int cardsInDeck;
    private UnoCard deck[];

    public UnoDeck(boolean initDeck) {
        this.deck = new UnoCard[108];
        this.cardsInDeck = 0;
        if (initDeck)
            initDeck();
    }

    public void initDeck() {
        int i = 0;
        Color colors[] = Color.values();
        Value values[] = Value.values();

        for (Color color : colors) {
            // Add black cards
            if (color == Color.BLACK) {
                for (int j = 0; j < 4; j++) {
                    this.deck[i++] = new Wild(Value.WILDCARD);
                    this.deck[i++] = new DrawFour(Value.DRAW_FOUR);
                }
                continue;
            }

            for (Value value : values) {
                switch (value) {
                    // Add only one zero of each color
                    case ZERO:
                        this.deck[i++] = new NumberCard(color, value);
                        break;
                    case ONE:
                    case TWO:
                    case THREE:
                    case FOUR:
                    case FIVE:
                    case SIX:
                    case SEVEN:
                    case EIGHT:
                    case NINE:
                        this.deck[i++] = new NumberCard(color, value);
                        this.deck[i++] = new NumberCard(color, value);
                        break;
                    case DRAW_TWO:
                        this.deck[i++] = new DrawTwo(color);
                        this.deck[i++] = new DrawTwo(color);
                        break;
                    case REVERSE:
                        this.deck[i++] = new Reverse(color);
                        this.deck[i++] = new Reverse(color);
                        break;
                    case SKIP:
                        this.deck[i++] = new Skip(color);
                        this.deck[i++] = new Skip(color);
                        break;
                    default:
                        break;
                }
            }
        }
        this.cardsInDeck = i + 1;
    }

}
