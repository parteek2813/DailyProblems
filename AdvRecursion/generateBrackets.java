package AdvRecursion;


// question

// given a value N, we have to generate an expression containing N pairs of brackets
// such that all are balanced

// EXAMPLE: IF N = 3:
// Output could be - ((())) or ()()() or (())() or ()(()) or (()())


// if we wanna do it by brute force.... then we will remove the if conditon
// and then generate all the strings possible and then we would be using the stack
// based algo to filter out the correct one .... push all open in stack and
// whenever the close bracket appears , we would be removing them ... and then
// at last , we would be see if the stack is empty -> If it is then we got the
// correct string and print them ... otherwise go on
// The string we can get here can be 2^n and then we will check each of them
// so time complexity would be very high


public class generateBrackets {

    static void generateBrackets(String s , int n, int open , int close){
        // base case
        if(s.length() == 2*n){
            System.out.println(s);
            return;
        }


        // rec case

        // these if condition are helping that we goes to the right branch only
        // and don't go to the wrong branch .... if these condition wouldn't be there
        // we will be moving to the all branch possible in the recursion tree.

        if(open <n){
            generateBrackets(s+ "(" , n, open +1, close );
        }

        if(close<open){
            generateBrackets(s+")", n, open, close+1);
        }


    }
    public static void main(String[] args) {
        generateBrackets("", 3, 0, 0);
    }
}
