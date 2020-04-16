package TextParser;

public class Chain {

    private int[][] amount;
    private String[][] text;

    public Chain(int[][] amt, String[][] text) {
        this.amount = amt;
        this.text = text;
    }

    public int[][] getAmount() {
        return this.amount;
    }

    public String[][] getText() {
        return this.text;
    }

}