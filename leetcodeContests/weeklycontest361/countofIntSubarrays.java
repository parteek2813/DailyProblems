package leetcodeContests.weeklycontest361;

// Question
/*
You are given a 0-indexed integer array nums, an integer modulo, and an integer k.

Your task is to find the count of subarrays that are interesting.

A subarray nums[l..r] is interesting if the following condition holds:

Let cnt be the number of indices i in the range [l, r] such that nums[i] % modulo == k. Then, cnt % modulo == k.
Return an integer denoting the count of interesting subarrays.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class countofIntSubarrays {


        public static long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
            Map<Long, Long> mp = new HashMap<>();

            long ans =0, prefix=0;
            int n =  nums.size();

            mp.put(0L, 1L);

            for(int i =0 ; i<n; i++){
                int num = nums.get(i);
                if(num % modulo  == k){
                    prefix++;
                }

                prefix %= modulo;

                long target = (prefix - k + modulo) % modulo;
                ans += mp.getOrDefault(target,0L);

                mp.put(prefix, mp.getOrDefault(prefix, 0L) + 1);
            }
            return ans;
        }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(2);
        arr.add(4);


        long ans = countInterestingSubarrays(arr, 2, 1);
        System.out.println(ans);
    }
}
