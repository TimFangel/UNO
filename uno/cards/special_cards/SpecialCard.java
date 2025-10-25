package uno.cards.special_cards;

import uno.cards.Color;
import uno.cards.UnoCard;
import uno.cards.Value;

public abstract class SpecialCard extends UnoCard {
    public SpecialCard(Color color, Value value) {
        super(color, value);
    }
}
