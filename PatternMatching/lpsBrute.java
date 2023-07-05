package PatternMatching;

import java.sql.Array;
import java.util.Arrays;

public class lpsBrute {

    static int[] computeLPS(String text) {
        int len = 0;
        int i = 1;
        int[] lps = new int[text.length()];

        while (i < text.length()) {
            if (text.charAt(i) == text.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    static int bruteForceSubstringCount(String text, String pattern) {
        int[] lps = computeLPS(text);
        int n = text.length();
        int m = pattern.length();
        int count = 0;
        int i =0, j=0;

        while (i<n){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            if(j==m){
                count++;
                j= lps[j-1];
            } else if (i<n && text.charAt(i) != pattern.charAt(j)) {
                if(j != 0){
                    j = lps[j-1];
                }else {
                    i++;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {

//        int index = patternLps(text, pattern);
//
//        if(index != -1){
//            System.out.println("Pattern found at index: " + index);
//        }else {
//            System.out.println("Pattern not found in the text.");
//        }
        String text = "asdsaaccacacacaadc";
        String pattern = "ac";

        int count = bruteForceSubstringCount(text, pattern);
        System.out.println("Substring count: " + count);
    }
}
