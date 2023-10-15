package AdvBitManipulation;

import java.util.Arrays;

// ref: https://leetcode.com/contest/weekly-contest-367/problems/shortest-and-lexicographically-smallest-beautiful-string/
public class BeautifulSubString {

    public static String shortestBeautifulSubstring(String s , int k){
        int len = s.length() + 1;
        String result = "";

        // find the minimum length String in which count(1) == k .

        int newI = 0;
        int newJ = 0;

        for (int i = 0; i < s.length(); i++) {
            int cnt = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    cnt++;
                }
                if (cnt == k) {
                    if (j - i + 1 < len) {
                        len = j - i + 1;
                        newI = i;
                        newJ = j;
                        break;
                    }
                }
            }
        }



        String maxi="";

        maxi = s.substring(newI, newJ+1);
//        for (int i = 0; i < s.length(); i++) {
//            int cnt = 0;
//            for (int j = i; j < s.length(); j++) {
//                if (s.charAt(j) == '1') {
//                    cnt++;
//                }
//                if (cnt == k) {
//                    if (j - i + 1 == len) {
//                        String substring = s.substring(i, j + 1);
//                        if (result.equals("")) {
//                            result = substring;
//                        } else {
//                            result = result.compareTo(substring) < 0 ? result : substring;
//                        }
//                    }
//                }
//            }
//        }

        return maxi;
    }
    public static void main(String[] args) {
        String s = "100011001";
        int k =3;
        String res = shortestBeautifulSubstring(s, k);
        System.out.println(res);
    }
}
