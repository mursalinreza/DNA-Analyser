package com.RMS;

import javax.swing.*;


import static javax.swing.JOptionPane.showConfirmDialog;

public class Main {
    public static void search(String txt, String pat)
    {
        int M = pat.length();
        int N = txt.length();

        /* A loop to slide pat one by one */
        for (int i = 0; i <= N - M; i++) {

            int j;

            /* For current index i, check for pattern
              match */
            for (j = 0; j < M; j++)
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;

            if (j == M) // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
                JOptionPane.showMessageDialog(null,"Pattern found at index " + i);
        }
    }

    public  static void main(String[] args) {
            int response = showConfirmDialog(null, "Do you want to sequence your DNA?", "", JOptionPane.YES_NO_OPTION);
            String dnaSeq ;
            while (response != JOptionPane.NO_OPTION ) {
                dnaSeq = JOptionPane.showInputDialog("Enter the DNA sequence: ");
                checkProtein(dnaSeq);
                JOptionPane.showMessageDialog(null, "The RNA Template is " + rnaTranslate(dnaSeq));
                JOptionPane.showMessageDialog(null, "The Complementary DNA strand is " + dnaComplementary(dnaSeq));
                search(dnaSeq,"CGT");
                response = showConfirmDialog(null, "Do you wish to continue", "", JOptionPane.YES_NO_OPTION);
                }
            }



    public static String rnaTranslate(String txt){
        String str = txt.replace('T','U');
        return str;
    }
    public static String dnaComplementary(String txt){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < txt.length();i++){

            if(txt.charAt(i)=='T')
                builder.append('A');
            if(txt.charAt(i)=='A')
                builder.append('T');
            if(txt.charAt(i)=='G')
                builder.append('C');
            if(txt.charAt(i)=='C')
                builder.append('G');
        }
        return builder.toString();
    }
    public static void checkProtein(String txt){
        int start = txt.indexOf("ATG");
        int end = txt.indexOf("TGA");
        String noProtein = "No Protein found.";

        if(start != -1 && end != -1 && (end - start) % 3 == 0){
            String protein = txt.substring(start,end+3);
            JOptionPane.showMessageDialog(null,"Protein: " + protein);
        }
        else{
            JOptionPane.showMessageDialog(null,noProtein);
        }
    }


}
