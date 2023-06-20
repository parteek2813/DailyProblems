package AdvRecursion;

// question

import java.util.Arrays;

// Given an array of size,  check if it sorted or not.
public class arrayStoredUsingRec {

    static  boolean isSorted(int[] arr, int n){

        // base case
        if(n == 0 || n==1){
            return true;
        }

        // Taking up extra O(N) time , to reduce this will modify the approach
        int[] newArr = Arrays.copyOfRange(arr, 1 ,5);
        // rec case
        return arr[0] < arr[1] && isSorted(newArr, n-1);
    }

    static  boolean isSortedFromRight(int[] arr, int n){

        // base case
        if(n == 0 || n==1){
            return true;
        }

        // rec case
        return arr[n-1]>arr[n-2] && isSorted(arr, n-1);
    }

    static  int SumOfDigits(int digits){

        //base case
        if(digits == 0){
            return 0;
        }


        // rec case
        return digits%10 + SumOfDigits(digits/10);
    }
    public static void main(String[] args) {

        int[] arr = {1,3,5,7,10};
        int n = arr.length;
//        boolean res = isSorted(arr, n);
//

//        boolean res = isSortedFromRight(arr,n);
//        System.out.println(res);

        int digits = 1256;
        int sumRes=  SumOfDigits(digits);
        System.out.println(sumRes);
    }
}
