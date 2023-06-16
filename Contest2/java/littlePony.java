package Contest2.java;

//given a string A consisting only of lowercase chars. We can swap any 2 characters of String A
// any no. of times. Return 1 if it possible to convert The string A to palindromic String


import java.util.Arrays;
import java.util.Scanner;

public class littlePony {


    static int isPalindrome(String A){
        char[] charString = A.toCharArray();

        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        for(char x: charString){
            freq[x-97]++;
        }

        // Computing odd freq. from freq[] array
        int oddFreq =0;
        for(int y : freq){
        if(y%2 != 0){
            oddFreq++;
            }
        }

        //Checking oddfreq
        if(oddFreq <=1){
            return 1;
        }else {
            return 0;
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String A = sc.nextLine();

        int result = isPalindrome(A);
        System.out.println(result);
    }
}
