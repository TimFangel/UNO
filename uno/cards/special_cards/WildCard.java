package uno.cards.special_cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uno.cards.Color;
import uno.cards.UnoCard;
import uno.cards.Value;

public abstract class WildCard extends UnoCard implements ColorEffect {
    public WildCard(Value value) {
        super(Color.BLACK, value);
    }

    @Override
    public boolean canBePlayedOn(UnoCard card) {
        return true;
    }

    public void changeColor() throws IOException {
        BufferedReader r = new BufferedReader(
                new InputStreamReader(System.in));
        String s;
        boolean input = false;

        do {
            System.out.println("Select a color RED (R), GREEN (G), BLUE (B) or YELLOW (Y)!");
            s = r.readLine().toUpperCase();
            if (s.equals('R') || s.equals('G') || s.equals('B') || s.equals('Y'))
                input = true;
        } while (!input);

        switch (s) {
            case "R":
                color = Color.RED;
                break;
            case "G":
                color = Color.GREEN;
                break;
            case "B":
                color = Color.BLUE;
                break;
            case "Y":
                color = Color.YELLOW;
                break;

        }
    }
}
