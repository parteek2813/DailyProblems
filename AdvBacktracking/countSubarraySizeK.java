package AdvBacktracking;


// Question

// Given an array of integers nums and an integer k, return the total number of
// subarrays whose sum equals to k.

import java.util.HashMap;

// A subarray is a contiguous non-empty sequence of elements within an array.
public class countSubarraySizeK {

    public  static int subarraySum(int[] nums, int k){
        int count = 0;
        int cumulativeSum = 0;
        HashMap<Integer, Integer> sumFrequency = new HashMap<>();

        // Initializing the HashMap with cumulative sum 0 and frequency 1.
        sumFrequency.put(0, 1);

        for (int num : nums) {
            cumulativeSum += num;

            // Check if there is a subarray with sum equal to k.
            if (sumFrequency.containsKey(cumulativeSum - k)) {
                count += sumFrequency.get(cumulativeSum - k);
            }

            // Increment the frequency of cumulativeSum in the HashMap.
            sumFrequency.put(cumulativeSum, sumFrequency.getOrDefault(cumulativeSum, 0) + 1);
        }

        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k =2;

        int res = subarraySum(nums, k);
        System.out.println(res);
    }
}
