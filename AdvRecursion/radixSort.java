package AdvRecursion;

import java.util.Arrays;

public class radixSort {

    // get maximum elememt
    static int maxVal(int arr[], int n){
        int max = arr[0];
        for(int i =1; i<n ; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    static void countSort ( int arr[], int n, int exp){
        int[] output = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // store count of occurences
        for( i=0; i<n; i++){
            count[(arr[i] / exp) % 10]++;
        }

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // copy the output array
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }


    static void radixSort(int arr[] , int n){

        int m = maxVal(arr, n);
        for( int exp=1; m/exp>0; exp *= 10){
            countSort(arr, n , exp);
        }
    }

    public static void main(String[] args) {

        int[] arr = {180,230,1,2,23,5,343,443};
        int n = arr.length;

        radixSort(arr, n);
        for( int i=0; i<n; i++){
            System.out.println(arr[i] + " ");
        }

    }
}
