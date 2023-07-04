package PatternMatching;

// question

// We are tasked with implementing a brute-force pattern matching algorithm in Java.
// Write a Java program that takes two input strings: a main text string and a pattern
// string. Your program should efficiently find and print the index of the first occurrence
// of the pattern in the main text. If the pattern is not found in the main text, your
// program should output a message indicating the pattern was not found.
public class patternMatchbruteopti {

    static int bruteForcePatternMatch(String text, String pattern){
        int n = text.length();
        int m = pattern.length();

        for(int i =0; i<= n-m; i++){
            int j;
            for(  j=0; j<m; j++){
                if(text.charAt(i+j) != pattern.charAt(j)){
                    break;
                }
            }

            if(j ==m){
                return i; // found pattern at index i in text
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String text = "ababcababcabc";
        String pattern = "abc";

        int index = bruteForcePatternMatch(text, pattern);

        if(index != -1){
            System.out.println("Pattern found at index: " + index);
        }else {
            System.out.println("Pattern not found in the text.");
        }
    }
}
