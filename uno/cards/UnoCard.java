package uno.cards;

public abstract class UnoCard {
    Color color;
    Value value;

    public UnoCard(Color color, Value value) {
        this.color = color;
        this.value = value;
    }

    public Color getColor() {
        return this.color;
    }

    public Value getValue() {
        return this.value;
    }

    public boolean canBePlayedOn(UnoCard card) {
        return (card.getColor() == this.getColor() || card.getValue() == this.getValue());
    }

    public void playCard() {

    }

}
