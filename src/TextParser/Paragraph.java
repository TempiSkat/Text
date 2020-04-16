package TextParser;

import TextParser.Composite.Department;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Paragraph implements DispenseChain,Department{

    private DispenseChain chain;
    private int[][] ntoken;
    private String[][] text;


    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
        this.ntoken = new int[1][1];
        this.text = new String[10][10];
    }

    @Override
    public void dispense(Chain cur) {
        if (cur.getText() != null) {
            System.out.println("Paragraph : ");
            String[][] filename = cur.getText();
            try (Scanner scanner = new Scanner(new File(filename[0][0]))) {
                scanner.useDelimiter(" {2}");

                while (scanner.hasNext()) {
                    String token = scanner.next();
                    assert false;
                    text[ntoken[0][0]++][0] = token;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < ntoken[0][0]; i++)
                System.out.println(text[i][0]);
            this.chain.dispense(new Chain(ntoken, text));
//        if(text!= null)
//        this.chain.dispense(cur);
        }
    }

    public String[][] getText() {
        return this.text;
    }

    public int[][] getAmount() {
        return this.ntoken;
    }


    public void DPCmethod() {
        System.out.println("Base Form: ");
        for (int i = 0; i < ntoken[0][0]; i++)
            System.out.println(text[i][0]);
    }

    @Override
    public String[][] sort() {

        return new String[0][];
    }


}

