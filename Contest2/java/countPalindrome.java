package Contest2.java;

import java.util.Scanner;

public class countPalindrome {

    static int countPalindromeString(String s){
        int count =0;
        int n = s.length();

        //Iterate through each character in the string

        for(int i =0; i<n; i++){
            count += expandPalindrome(s,i,i);

            count+= expandPalindrome(s,i,i+1);
        }

        return count;
    }

    static int expandPalindrome(String s, int left , int right){
        int count=0;

        //expand around the center characters
        while(left>=0 && right < s.length() && ( s.charAt(left) == s.charAt(right))){
            count++;
            left--;
            right++;

        }
        return count;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String:");
        String s = sc.nextLine();

        int result = countPalindromeString(s);
        System.out.println(result);
    }
}
