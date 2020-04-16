package TextParser.Composite;
import TextParser.*;

public class ATMDispenseChain {


    private static DispenseChain c1;
    private static DispenseChain c2;
    private static DispenseChain c3;

    public ATMDispenseChain() {
        // initialize the chain
        c1 = new Paragraph();
        c2 = new Sentence();
        c3 = new Word();
        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);


    }

    public static void main(String[] args) {
        ATMDispenseChain atmDispenser = new ATMDispenseChain();
        int[][] amount = new int[1][1];
        amount[0][0] = 0;
        String[][] filename = new String[1][1];
        filename[0][0] = "src/Text.txt";
        c1.dispense(new Chain(amount, filename));


        Composite composite = new Composite();
        composite.addDepartment((Department) c1);
        composite.addDepartment((Department) c2);
        composite.addDepartment((Department) c3);
        composite.DPCmethod();
        composite.sort();

        composite.DPCmethod();

    }
}

