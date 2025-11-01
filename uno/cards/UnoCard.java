package uno.cards;

public abstract class UnoCard {
    Color color;
    Value value;
    Color tmpColor = null; // Only used for wildcards and draw four.

    public UnoCard(Color color, Value value) {
        this.color = color;
        this.value = value;
    }

    public Color getColor() {
        return this.color;
    }

    // Only used for wildcards and draw four.
    public Color getTmpColor() {
        return this.tmpColor;
    }

    public Value getValue() {
        return this.value;
    }

    public boolean canBePlayedOn(UnoCard card) {
        return (card.getColor() == this.getColor() || card.getValue() == this.getValue()
                || card.getTmpColor() == this.getColor());
    }
}
