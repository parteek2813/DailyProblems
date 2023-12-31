package AdvBacktracking;


// Question:

// Given a array of size n .... we have to construct the subset such that the sum of the element
// of the subset is a Prime number. Calculate the count of number of prime number of sum of elemenets

import java.util.ArrayList;
import java.util.List;

public class countSubsetsPrime {

    public static boolean isPrime(int num){
        if(num <= 1){
            return false;
        }
        // 2 is prime num
        if(num == 2){
            return true;
        }

        // for divisibility
        for(int i =2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }

    public static void generateSubsets(int[] arr, int i , int currSum, int[] count){
            // base case
            if(i == arr.length){
                if(isPrime(currSum)){
                    count[0]++;

                }
                return;
            }


            // rec case
        // Include the current element in the subset and move to the next index
        generateSubsets(arr, i + 1, currSum + arr[i], count);

        // Exclude the current element from the subset and move to the next index
        generateSubsets(arr, i + 1, currSum, count);

    }

    public static int countSubsetsPrimeActual(int[] arr){
        int[] count = new int[1];
        generateSubsets(arr, 0, 0, count);
        return count[0];
    }


    public static void printAllSubsets(int[] arr, int index, List<Integer> currentSubset,List<List<Integer>> subsets){
        subsets.add(new ArrayList<>(currentSubset));

        // logic
        for(int i =index; i<arr.length; i++){
            currentSubset.add(arr[i]);

            // rec call
            printAllSubsets(arr, i+1, currentSubset, subsets);

            // for exact backtracking
            currentSubset.remove(currentSubset.size() -1);

        }


    }
    public static List<List<Integer>> getSubsets(int[] arr){
        // define the arraylist here
        List<List<Integer>> subsets = new ArrayList<>();
        printAllSubsets(arr, 0, new ArrayList<>(), subsets);
        return subsets;
   }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
//        int res = countSubsetsPrimeActual(arr);
//        System.out.println(res);
        List<List<Integer>> subsets = getSubsets(arr);
        for(List<Integer> subset: subsets){
            System.out.println(subset);
        }


    }



    // subsets of {1,3,2,4}
    // []
    //  [1]
    //  [1, 3]
    //  [1, 3, 2]
    //  [1, 3, 2, 4]
    //  [1, 3, 4]
    //  [1, 2]
    //  [1, 2, 4]
    //  [1, 4]
    //  [3]
    //  [3, 2]
    //  [3, 2, 4]
    //  [3, 4]
    //  [2]
    //  [2, 4]
    //  [4]
}
