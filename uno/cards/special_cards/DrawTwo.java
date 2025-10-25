package uno.cards.special_cards;

import uno.cards.Color;
import uno.cards.Value;

public class DrawTwo extends SpecialCard implements DrawEffect {
    public DrawTwo(Color color) {
        super(color, Value.DRAW_TWO);
    }

    @Override
    public int drawCards(int drawCount) {
        return drawCount += 2;
    }
}
