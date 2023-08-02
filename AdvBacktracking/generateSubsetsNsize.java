package AdvBacktracking;

import java.util.ArrayList;
import java.util.Arrays;

// Question
// Given a array of size N , generate all subsets of it


public class generateSubsetsNsize {

    public static void generateSubsetActual(int[] arr , int i, ArrayList<Integer> output){


        // base case
       if(i == arr.length){
           System.out.println(output );
           return;
       }

        // rec case
        // 1. Include ith elements + do the work for remaining
        output.add(arr[i]);
        generateSubsetActual(arr, i+1, output);

        // 2. exclude ith element + do the work for remaining
        // also remove the element added in the rec case 1 for this part.
        Integer x = arr[i]; // typecasting int to Integer
        output.remove(x);  // backtracking steps....happening when we're coming back from the function call
        generateSubsetActual(arr, i+1, output);

    }
    public static void main(String[] args) {
            int[] arr = {1,2,3};
            int n = 3;

            ArrayList<Integer> output = new ArrayList<>();
            generateSubsetActual(arr, 0, output);

    }
}
