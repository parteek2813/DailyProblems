package AdvStack;
import java.util.Arrays;
import java.util.Stack;

// Given an array of size N, find the nearest smaller number for every element
// that is present on the left

// Example would be:
// INPUT ARR = [1,6,4,12,3,8];
// OUTPUT ARR = [-1,1,1,4,1,3];
public class LNearestSmallerNum {

    static int[] bruteSmaller(int[] arr){
        int n = arr.length;
        int[] output = new int[n];
        output[0] = -1;
        for(int i =1; i<=n-1; i++){
            for(int j=i-1; j>=0; j--){
                if(arr[j] < arr[i]){
                    output[i] = arr[j];
                    break;
                }
                if(j==-1){
                    output[i] = -1;
                }
            }

        }
        return output;
    }



    public static void main(String[] args) {

       int[] arr = {1,6,4,12,3,8};
       int[] res = bruteSmaller(arr);
        System.out.println(Arrays.toString(res));
//
//        int[] res = stackSmaller(arr);
//        System.out.println(Arrays.toString(res));

    }
}
