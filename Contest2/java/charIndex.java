package Contest2.java;

//Shivam has string A of size N containing only lowercase characters  He will update the string by insertin a num after every char which will be the index
// of that char. Return result string!

//Given azd
// output- a1z26d4


import java.util.Scanner;

public class charIndex {
    public static void main(String[] args) {

        Scanner sc = new Scanner((System.in));
        System.out.println("Enter the string:");
        String A = sc.nextLine();
        String ans = "";
        for(int i=0; i< A.length(); i++){
            int charAtEach= A.charAt(i);
            int temp = (charAtEach - 97 + 1);
            ans = ans + A.charAt(i) + temp;
        }
        System.out.println(ans);
    }
}
