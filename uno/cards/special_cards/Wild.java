package uno.cards.special_cards;

import java.io.IOException;

import uno.cards.Color;
import uno.cards.Value;

public abstract class Wild extends WildCard {
    public Wild(Value value) {
        super(value);
    }

    public abstract Color getTmpColor();

    public abstract Color setTmpColor();

    public abstract void changeColor() throws IOException;
}
