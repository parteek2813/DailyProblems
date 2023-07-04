package PatternMatching;

import java.sql.Array;
import java.util.Arrays;

public class lpsBrute {

    static int[] computeLPS(String pattern) {
        int len = 0;
        int i = 1;
        int[] lps = new int[pattern.length()];

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
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
        int[] lps = computeLPS(pattern);
        int n = text.length();
        int m = pattern.length();
        int count = 0;

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                count++;
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
        String text = "abacaabacdacd";
        String pattern = "acd";

        int count = bruteForceSubstringCount(text, pattern);
        System.out.println("Substring count: " + count);
    }
}
