package uno.cards;

import java.util.Random;
import uno.cards.special_cards.DrawFour;
import uno.cards.special_cards.DrawTwo;
import uno.cards.special_cards.Reverse;
import uno.cards.special_cards.Skip;
import uno.cards.special_cards.Wild;

public class UnoDeck {

    private int cardsInDeck;
    private UnoCard deck[];

    /**
     * UnoDeck constructor
     * 
     * @param initDeck boolean deciding whether to initialize(1) deck or not(0)
     */
    public UnoDeck(boolean initDeck) {
        this.deck = new UnoCard[108];
        this.cardsInDeck = 0;
        if (initDeck) {
            initDeck();
            shuffleDeck();
        }
    }

    public int getDeckSize() {
        return cardsInDeck;
    }

    public UnoCard getTopCard() {
        return deck[cardsInDeck];
    }

    /**
     * Initializes a deck of UNO cards.
     */
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

    /**
     * Method shuffling a deck of UNO cards.
     */
    public void shuffleDeck() {
        Random r = new Random();
        for (int i = this.deck.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);

            UnoCard temp = this.deck[i];
            this.deck[i] = this.deck[j];
            this.deck[j] = temp;
        }
    }

    /**
     * Method adding cards to deck.
     * 
     * @param cardsToAdd UnoCard array of cards to add to deck.
     */
    public void addCard(UnoCard[] cardsToAdd) {
        try {
            if (cardsInDeck + cardsToAdd.length <= 108) {
                for (UnoCard unoCard : cardsToAdd) {
                    this.deck[cardsInDeck++] = unoCard;
                }
            } else {
                throw new ArrayIndexOutOfBoundsException("Deck overflow: too many cards!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method adding a single card to deck.
     * 
     * @param cardToAdd UnoCard to add to deck
     */
    public void addCard(UnoCard cardToAdd) {
        try {
            if (cardsInDeck + 1 <= 108) {
                deck[cardsInDeck++] = cardToAdd;
            } else {
                throw new ArrayIndexOutOfBoundsException("Deck overflow: too many cards!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method removing cards from deck.
     * 
     * @param numToRemove number of cards to remove from deck.
     */
    public void removeCard(int numToRemove) {
        try {
            if (cardsInDeck - numToRemove >= 0) {
                for (int i = 0; i < numToRemove; i++) {
                    this.deck[cardsInDeck--] = null;
                }
            } else {
                throw new ArrayIndexOutOfBoundsException("Deck underflow: too few cards!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method resetting deck after emptying drawpile.
     * 
     * @param deck the discard pile.
     */
    public void resetDeck(UnoDeck deck) {
        while (this.cardsInDeck != 108 && deck.getDeckSize() != 0 || deck.getTopCard() != null) {
            addCard(deck.getTopCard());
            deck.removeCard(1);
        }
        shuffleDeck();
    }
}
