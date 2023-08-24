package PatternMatching;

public class smallestSubstring {

    public static String smallestSubstringContaingAllChars(String s, String p){
        s = s.toLowerCase();
        p=p.toLowerCase();
        int[] charCount = new int[26];

        // count the freq of chars in string p
        for(char c: p.toCharArray()){
            charCount[c - 'a']++;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int reqChars = p.length();
        String result = "";

        for(int right =0; right <s.length(); right++){
            // check if the substring matches with the target string p
            // if yes then just decrement reqChars by 1;

            if(charCount[s.charAt(right) - 'a'] > 0){
                reqChars--;
            }

            // decrement in charCount too
            charCount[s.charAt(right) - 'a']--;

            while (reqChars == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    result = s.substring(left, right + 1);
                }

                charCount[s.charAt(left) - 'a']++;

                if (charCount[s.charAt(left) - 'a'] > 0) {
                    reqChars++;
                }

                left++;
            }


        }
        result = result.toUpperCase();
        return result;
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String p = "ABC";

//        String s= "hajkmop";
//        String p = "hjk";

        System.out.println(smallestSubstringContaingAllChars(s,p));
    }
}
