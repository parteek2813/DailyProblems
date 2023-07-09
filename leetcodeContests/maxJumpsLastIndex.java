package leetcodeContests;

import java.util.Arrays;

public class maxJumpsLastIndex {

    static int getMaximum(int[] nums, int target){
        int n = nums.length;
        int ans=0;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0]=0;


        for(int i =1; i<n; i++){
            for(int j = 0; j<i; j++){

                if(Math.abs(nums[j] - nums[i]) <= target && dp[j] != -1){
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }

            }
        }
        return  dp[n-1];

    }
    public static void main(String[] args) {
        int[] nums = {0,2,1,3};
        int target = 1;

        int res = getMaximum(nums, target);
        System.out.println(res);
    }
}
