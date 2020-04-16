package TextParser;

public interface DispenseChain {

    void setNextChain(DispenseChain nextChain);

    void dispense(Chain cur);

    String[][] getText();

    int[][] getAmount();
}