package AdvHeap;

import java.util.PriorityQueue;

public class maxTwoELemProduct {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < 2; i++) {
            pq.add(nums[i]);
        }
        for (int i = 2; i < nums.length; i++) {
            if (pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return (pq.poll() - 1) * (pq.poll() - 1);
    }

    public static void main(String[] args) {
        maxTwoELemProduct maxProductFinder = new maxTwoELemProduct();

        // Test case 1
        int[] nums1 = {1, 2, 3, 4, 5};
        int result1 = maxProductFinder.maxProduct(nums1);
        System.out.println("Test case 1 - Result: " + result1); // Output: 6 (2 * 3)

        // Test case 2
        int[] nums2 = {4, 2, 1, 5, 3};
        int result2 = maxProductFinder.maxProduct(nums2);
        System.out.println("Test case 2 - Result: " + result2); // Output: 12 (4 * 3)

        // Test case 3
        int[] nums3 = {10, 9, 8, 7, 6};
        int result3 = maxProductFinder.maxProduct(nums3);
        System.out.println("Test case 3 - Result: " + result3); // Output: 63 (9 * 7)
    }
}
