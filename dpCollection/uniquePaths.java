package dpCollection;

import java.util.Arrays;

public class uniquePaths {

    public static int findUniquePaths(int m , int n){

        // TIME: O(2^m*n)
        // SPACE: O(path length)


        // base case
        if(m==0 && n==0){
            return 1;
        }

        if(m<0 || n<0){
            return 0;
        }


        // rec case
        int left = findUniquePaths(m-1, n);
        int right = findUniquePaths(m, n-1);

        return left+right;
    }

    public static int findUniquePathsDp(int m , int n, int[][] dp){

        // TIME: O(2^m*n)
        // SPACE: O(path length)


        // base case
        if(m==0 && n==0){
            return 1;
        }

        if(m<0 || n<0){
            return 0;
        }

        // dp condition
        if(dp[m][n] != -1){
            return dp[m][n];
        }

        // rec case
        int left = findUniquePathsDp(m-1, n, dp);
        int right = findUniquePathsDp(m, n-1, dp);

        return dp[m][n]= left+right;
    }


    public static int findUniqueTabu(int m, int n){

        // STEPS:
        /*
        1. Declare the base case
        2. Express all states in for LOop
        3. Copy thr recurrence and code
         */


        // TIME: O(N*M)
        // SPACE: O(N*M) [no recursion used]

        int[][] dp = new int[m][n];
        dp[0][0] = -1;

        for(int i =0; i <= m-1; i++){
            for(int j=0; j <= n-1; j++){

                if(i==0 && j==0) dp[0][0] = 1;
                else{
                    int up=0, left=0;
                    if(i>0) {
                         up = dp[i-1][j];
                    }
                    if(j>0){
                        left = dp[i][j-1];
                    }

                    dp[i][j] = up+left;
                }
            }
        }

        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        int m = 2;
        int n = 2;

        int[][] dp = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        int res = findUniquePathsDp(m-1, n-1, dp);
        System.out.println(res);
    }
}
