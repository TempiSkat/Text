package TextParser;

import TextParser.Composite.Department;

import java.text.BreakIterator;
import java.util.*;

public class Word implements DispenseChain, Department {

    private DispenseChain chain;
    private int[][] ntoken;
    private String[][] text;
    private int[][] nmtoken2;
    private String[][] words;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
        this.ntoken = new int[100][1];
        this.text = new String[100][100];
    }

    @Override
    public void dispense(Chain cur) {
        if (cur.getText() != null) {
            System.out.println("Words : ");
            text = cur.getText();
            words = new String[20][150];
            nmtoken2 = new int[10][10];
            ntoken = cur.getAmount();
            int q = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < ntoken[i][0]; j++) {
                    String data = text[i][j];
                    BreakIterator bi = BreakIterator.getWordInstance(Locale.US);
                    bi.setText(data);
                    System.out.println("Iterates each word: ");
                    int lastIndex = bi.first();
                    while (lastIndex != BreakIterator.DONE) {
                        int firstIndex = lastIndex;
                        lastIndex = bi.next();

                        if (lastIndex != BreakIterator.DONE
                                && Character.isLetterOrDigit(data.charAt(firstIndex))) {
                            words[q][nmtoken2[q][0]] = data.substring(firstIndex, lastIndex);
                            System.out.printf("'%s' found at (%s, %s)%n", words[q][nmtoken2[q][0]], firstIndex, lastIndex);
                            nmtoken2[q][0]++;

                        }

                    }
                    q++;
                    nmtoken2[q][0]=0;
                }
            }
        }
    }

    public String[][] getText() {
        return this.words;
    }

    public int[][] getAmount() {
        return this.nmtoken2;
    }

    @Override
    public void DPCmethod() {

    }

    @Override
    public String[][] sort() {
        System.out.println("Sort words by Length in each sentence: \n");
        for (int k = 0; k < 100; k++) {
            for (int j = 0; j < 6; j++) {
                    for (int l = 0; l < nmtoken2[j][0]-1; l++) {
                        String swap;
                        if (words[j][l].length() > words[j][l + 1].length()) {
                            swap = words[j][l];
                            words[j][l] = words[j][l + 1];
                            words[j][l + 1] = swap;
                        }
                    }

            }
        }
        for (int j = 0; j < 6; j++) {
        for (int l = 0; l < nmtoken2[j][0]; l++) {
                    if(words[j][l]!=null){
                    System.out.print(words[j][l] + " ");}

                }
            System.out.println();
            if(j==1 || j==3 || j==4 || j==5)System.out.println();
            }


        return words;
    }

    }



