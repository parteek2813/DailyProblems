package AdvDp;

import java.util.Arrays;

public class dicegame {

    public static int findUsingRec(int n ){
        // base case
        if(n==0){
            return 1;
        }

        // rec case
        int ans =0;
        for(int j=1; j<=6; j++ ){
            if(n-j>=0){
                ans = ans + findUsingRec(n-j);
            }
        }
        return ans;
    }

    // top down DP
    public static int findUsingTopDp(int n , int[] dp){
        // base case
        if(n==0){
            return 1;
        }

        // check before computing
        if(dp[n] != 0){
            return dp[n];
        }

        // rec case
        int ans =0;
        for(int j=1; j<=6; j++ ){
            if(n-j>=0){
                ans = ans + findUsingTopDp(n-j, dp);
            }
        }

        // save before return
        return dp[n] = ans;

    }
    public static void main(String[] args) {
        int n = 4;
//        int res= findUsingRec(n);
//        int res1= findUsingRec(6);

        int dp[] = new int[n+1];
        Arrays.fill(dp,0);
        int res = findUsingTopDp(n,dp);
        System.out.println(res);
    }
}
