package dpCollection;

import java.util.ArrayList;
import java.util.Arrays;

public class maxSum5 {

    public static int solve(int n, ArrayList<Integer> nums, int[] dp){

        // base case
        if(n==0){
            return nums.get(0);
        }

        if(n<0){
            return 0;
        }

        if(n==1){
            return Math.max(nums.get(0), nums.get(1));
        }

        if(dp[n] != -1){
            return dp[n];
        }

        // rec case

        int pick = nums.get(n) + solve(n-2, nums, dp);

        int notPick = solve(n-1, nums, dp);


        return dp[n] = Math.max(pick, notPick);

    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        int n = arr.size();

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        int res = solve(n-1, arr, dp);
        System.out.println(res);
    }
}
