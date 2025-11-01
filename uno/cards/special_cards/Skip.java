package uno.cards.special_cards;

import uno.cards.Color;
import uno.cards.Value;
import uno.game.GameState;

public class Skip extends SpecialCard {
    public Skip(Color color) {
        super(color, Value.SKIP);
    }

    public void skipPlayer(GameState game) {
        game.updateTurn();
    }

}