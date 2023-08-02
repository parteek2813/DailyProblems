package AdvBacktracking;

// Question

// Count the number of subsets with the sum K (target)
// Using the concept of backtracking with pruning
public class countSubsetSizeK {

    public static int countSubsets(int[] input, int i , int currentSum , int k){
        // base case
        // case where the array is finished

        if(i== input.length){
            if(currentSum == k){
                return 1;
            }

            return 0;
        }

        // pruning the search space
        if(currentSum > k){
            return 0;
        }

        // rec case


        int x = countSubsets(input, i+1, currentSum+input[i], k);
        int y = countSubsets(input, i+1, currentSum, k);

        return x+y; // included or excluded
    }

    public static void main(String[] args) {
        int[] input = {1,1,5,2,7,0};

        int res = countSubsets(input, 0, 0, 9);
        System.out.println(res);
    }
}
