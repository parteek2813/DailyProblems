package AdvBacktracking;

// Question

import java.util.ArrayList;

// Count the number of subsets with the sum K (target)
// Using the concept of backtracking with pruning
public class countSubsetSizeK {

    public static int countSubsets(int[] input, int i , int currentSum , int k, ArrayList<Integer> arr){
        // base case
        // case where the array is finished

        if(i== input.length){
            if(currentSum == k){
                System.out.println(arr);
                return 1;
            }

            return 0;
        }

        // pruning the search space
        if(currentSum > k){
            return 0;
        }

        // rec case
        // include the ith element
        arr.add(input[i]);
        int x = countSubsets(input, i+1, currentSum+input[i], k, arr);


        int y = countSubsets(input, i+1, currentSum, k, arr);

        return x+y; // included or excluded
    }

    public static void main(String[] args) {
        int[] input = {3,2,6,7};

        ArrayList<Integer> arr = new ArrayList<>();

        int res = countSubsets(input, 0, 0, 9, arr);
        System.out.println(res);
    }
}
