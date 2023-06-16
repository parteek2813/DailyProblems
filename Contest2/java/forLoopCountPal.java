package Contest2.java;

import java.util.Scanner;

public class forLoopCountPal {
    static int countSubstrings(String s) {
        int count =0;
        String str = "";
        int n = s.length();

        //Iterate through each character in the string

        for(int i =0; i<n; i++){
            str="";
            for(int j=i; j<n;j++){
                Character ch=s.charAt(j);
                str=str+ch; // adding the jth charactrer to the String
                boolean bool=isPalindrome(str);
                if(bool) count++;  // If palindrome==true , increase the count correspondingly
            }
        }

        return count;
    }

    static boolean isPalindrome(String str){
        int n = str.length();
        int i=0,j=n-1; // using two pointer approach
        while(i<=j){
            char a=str.charAt(i);
            char b=str.charAt(j);
            if(a!=b) return false;
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String:");
        String s = sc.nextLine();

        int result = countSubstrings(s);
        System.out.println(result);
    }
}
