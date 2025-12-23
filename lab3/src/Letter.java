public class Letter {
    private char symbol;
    private int count;

    public Letter(char symbol, int count) {
        this.symbol = symbol;
        this.count = count;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public int getCount() {
        return this.count;
    }

    public void increaseCount() {
        this.count++;
    }

    public void decreaseCount() {
        this.count--;
    }
}
