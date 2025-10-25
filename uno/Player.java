package uno;

/* test */
public class Player {
    private String name;
    private int[] hand;

    public Player(String name, int[] cards) {
        this.name = name;
        this.hand = cards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addCards(int[] cards) {
        this.hand = cards;
    }

}
