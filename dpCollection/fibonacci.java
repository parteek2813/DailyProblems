package dpCollection;

import java.util.Arrays;
import java.util.Scanner;

/*
Time Complexity: O(N) ---> Because we are going to call f(5) sure... then f(4)
then F(3) -> F(2)-> F(1) after that return but the second call of F(5) to F(4) in tree
remains saved due to pre-computed.

Hence, call goes in same line only and after that time becomes O(1) for remaining functions
Without DP, The time go upto 2^n [Exponential]

Space Complexity: O(N) [Recursive Stack Space] + O(N) [DP Array]
                         F(5)
                     /        \
               F(4)             F(3)
            /      \            /     \
        F(3)       F(2)      F(2)    F(1)
       /    \      /    \     /    \
    F(2)  F(1)  F(1)   F(0) F(1)  F(0)
   /   \
 F(1)  F(0)

 */
public class fibonacci {

    public static int fibonacci(int n, int[] dp){
        // base case
        if(n<=1){
            return n;
        }


        Arrays.fill(dp,-1);

        if(dp[n] != -1){
            return dp[n];
        }


        // rec case
        dp[n] = fibonacci(n-1, dp)+fibonacci(n-2, dp);
        return dp[n];

    }

    public static int fibonacciUsingBottomUp(int n){

        // TIME- O(N)
        // SPACE- O(1)
        int prev2 = 0;
        int prev = 1;

        for(int i =2; i<=n; i++){
            int curri = prev + prev2;
            prev2 = prev;
            prev = curri;
        }

        return prev;
    }
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] dp = new int[n+1];
//        int result = fibonacci(n, dp);
        int res = fibonacciUsingBottomUp(10);
        System.out.println(res);



        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time: " + elapsedTime + " ms");
    }
}
