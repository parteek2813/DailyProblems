package dpCollection;

import java.util.Arrays;

/*
Technique to solve in 3 steps

1. Index
2. Do all stuffs on that index
3. Take the minimum(on all stuffs)


Recursive to DP soln :

- Look at the parameters changing


 SPACE OPTIMIZATION THUMB RULE:

 Anytime there is something index-1 / index-2 , there would always be space optimization
 in which we can use only 2-3 variable and reduce the space of array size

 */
public class frogJump3 {

    static int right;
    public static int frogJumpRec(int[] arr, int n){


        // base case
        if(n==0) return 0;

        // rec case
        int left = frogJumpRec(arr, n-1) +  Math.abs(arr[n] - arr[n-1]);

        if(n>1){
            right = frogJumpRec(arr, n-2) + Math.abs(arr[n] - arr[n-2]);
        }

        return Math.min(left, right);

    }


    public static int frogJumpMemo(int[] arr, int n , int[] dp){

        // TIME- O(N)
        // SPACE- O(N) + O(N)

        // base case
        if(n==0) return 0;

        // dp case
        if(dp[n] != -1){
            return dp[n];
        }

        // rec case
        int left = frogJumpMemo(arr, n-1, dp) +  Math.abs(arr[n] - arr[n-1]);

        if(n>1){
            right = frogJumpMemo(arr, n-2,dp) + Math.abs(arr[n] - arr[n-2]);
        }

        return dp[n] = Math.min(left, right);

    }

    public static int frogJumpMemoTab(int n , int[] arr){
        int[] dp = new int[n+1];

        Arrays.fill(dp,0);
        dp[0] = 0;

        for(int i=1; i<n; i++){
            int fs = dp[i-1] + Math.abs(arr[i] - arr[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i>1) ss = dp[i-2] + Math.abs(arr[i] - arr[i-2]);
            dp[i] = Math.min(fs, ss);
        }

        return dp[n-1];

    }


    public static void main(String[] args) {

        int[] arr = {10,20,30,10};
        int n = arr.length;
//        int result = frogJumpRec(arr, n-1);

//        int[] dp = new int[n+1];
//        Arrays.fill(dp, -1);

//        int res = frogJumpMemo(arr, n-1, dp);


        int res = frogJumpMemoTab(n, arr);

        System.out.println(res);
    }
}
