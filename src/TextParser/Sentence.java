package TextParser;

import TextParser.Composite.Department;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence implements DispenseChain, Department {

    private DispenseChain chain;
    private int[][] ntoken;
    private String[][] text;
    private int[][] nmtoken2;
    private String[][] str;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
        this.ntoken = new int[10][1];
        this.nmtoken2 = new int[10][1];
        this.text = new String[100][100];
        this.str = new String[100][100];
    }

    @Override
    public void dispense(Chain cur) {
        if (cur.getText() != null) {
            System.out.println("Sentence : ");
            text = cur.getText();
            ntoken = cur.getAmount();
            for (int i = 0; i < ntoken[0][0]; i++) {
                nmtoken2[i][0] = 0;
                Pattern re = Pattern.compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)", Pattern.MULTILINE | Pattern.COMMENTS);
                Matcher reMatcher = re.matcher(text[i][0]);
                while (reMatcher.find()) {
                    str[i][nmtoken2[i][0]] = reMatcher.group();
                    System.out.println(str[i][nmtoken2[i][0]]);
                    nmtoken2[i][0]++;
                }
            }
            this.chain.dispense(new Chain(nmtoken2, str));
        }
    }

    public String[][] getText() {
        return this.str;
    }

    public int[][] getAmount() {
        return this.nmtoken2;
    }

    @Override
    public void DPCmethod() {

    }

    @Override
    public String[][] sort() {
        System.out.println("Sort Paragraphs by amount of sentences: ");
        String swap;
        int swap2 = 0;
        for (int k = 0; k < 100; k++) {
            for (int j = 0; j < ntoken[0][0] - 1; j++) {
                if (nmtoken2[j][0] < nmtoken2[j + 1][0]) {
                    swap = text[j][0];
                    text[j][0] = text[j + 1][0];
                    text[j + 1][0] = swap;
                    swap2 = nmtoken2[j][0];
                    nmtoken2[j][0] = nmtoken2[j + 1][0];
                    nmtoken2[j + 1][0] = swap2;
                }
            }
        }
        int f = 0;
        while (text[f][0] != null) {
            System.out.println((text[f][0]));
            f++;
        }

        System.out.println("Sort Sentences by amount of words: ");
        String swap3;
        int swap4 = 0;
        int z = 0;
        for (int k = 0; k < 100; k++) {
            for (int j = 0; j < ntoken[0][0]; j++) {
                for (int h = 0; h < nmtoken2[j][0]; h++) {
                    if (nmtoken2[h][0] > nmtoken2[h + 1][0]) {
                        swap3 = str[j][z];
                        str[j][z] = str[j + 1][z];
                        str[j + 1][z] = swap3;
                        swap4 = nmtoken2[h][0];
                        nmtoken2[h][0] = nmtoken2[h + 1][0];
                        nmtoken2[h + 1][0] = swap4;

                    }
                }
            }
        }
        int r = 0;
        for (int j = 0; j < ntoken[0][0]; j++) {
            while (str[j][r] != null) {
                System.out.println((str[j][r]));
                r++;
            }
            r = 0;
        }
        return text;
    }
}