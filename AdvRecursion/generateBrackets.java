package AdvRecursion;


// question

// given a value N, we have to generate an expression containing N pairs of brackets
// such that all are balanced

// EXAMPLE: IF N = 3:
// Output could be - ((())) or ()()() or (())() or ()(()) or (()())



public class generateBrackets {

    static void generateBrackets(String s , int n, int open , int close){
        // base case
        if(s.length() == 2*n){
            System.out.println(s);
            return;
        }


        // rec case
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
