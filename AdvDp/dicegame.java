package AdvDp;

import java.util.Arrays;

// if asked in interview, first say that I know the top down approach and the
// bottom one too. I will code in top down manner. The most efficient solution
// is the bottom one but sometimes hard to code so try to move with top down

// we can do the space optimize version too
// where we can create a 1 arrays of size 6... because at any stage we need only the last
// 6 elements or we can also use 1 queue to bring down the space to O(1);

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

    public static int findUsingBottomUp(int n){
        // time = O(N)
        // Space = O(N)
        int dp[] = new int[n+1];
        Arrays.fill(dp,0);


        dp[0] =1;
        for(int i =1; i<=n; i++){
            int ans=0;
            for(int j=1; j<=6; j++ ){
                if(i-j>=0){
                    ans = ans + dp[i-j];
                }
            }
            dp[i] = ans;
        }
        return dp[n];
    }

    // ladder problem
    // child has grown up and can take jumps of sizes = 1,2,3,4,5....k
    // How many ways he can reach the Nth Step.

    // INPUT : N , K

    // Run the summation = loop from n-1 to ... n-k
    // recurrence
    // f(i) + f(i-1) + f(i-2) + ..... + f(i-k)

    // Rec: K^n
    // Top Down DP: n*k
    // Bottom Up DP: n*k

    // loop from k times for n states
    public static int findUsingK(int n, int k){
        int dp[] = new int[n+1];
        Arrays.fill(dp, 0);

        dp[0] = 1;
        for(int i =1; i<=n; i++){
            int ans =0;
            for(int j =1; j<=k; j++){
                if(i-j>0){
                    ans = ans + dp[i-j];
                }
            }
            dp[i] = ans;
        }
        return dp[n];
    }

    // Can I do better?
    // USing Sliding Window + DP
    // DP[i] = subtract first + add 3 elements/ add dp[i-1]] + add dp[i-1]
    // dp[i]= 2*dp[i-1] - dp[i-k-1]

    public static int ladderUsingSlidingWindow(int n , int k){
        int dp[] = new int[n+1];
        Arrays.fill(dp, 0);


        dp[0]=dp[1] = 1;
        for(int i =2 ; i<=n ; i++){
                if(i<=k){
                    dp[i] = 2*dp[i-1];
                }else{
                    dp[i] = 2*dp[i-1] - dp[i-k-1];
                }
        }
        return dp[n];
    }

    // Can I still do better?
    // Mathematical Technique : Matrix Exponentiation O(N)
    // The time complexity for this approach comes out to be O(K^3 logN)
    // This technique is also used to solve fibonacci too (Which is the fastest way to
    // solve the fibonacci)




    public static void main(String[] args) {
        int n = 4;
//        int res= findUsingRec(n);
//        int res1= findUsingRec(6);

//        int dp[] = new int[n+1];
//        Arrays.fill(dp,0);
//        int res = findUsingTopDp(n,dp);

//        int res = findUsingBottomUp(n);
        int res = ladderUsingSlidingWindow(8,3);

        System.out.println(res);
    }
}
