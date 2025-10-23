package uno;

public abstract class UnoCard {
    public enum Color {
        RED, BLUE, GREEN, YELLOW
    }

    public abstract String getColor();

    public abstract String getValue();

    public abstract boolean isPlayable(UnoCard card);

    public abstract void applyEffect();

}
