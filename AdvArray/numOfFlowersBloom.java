package AdvArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class numOfFlowersBloom {

    // Brute Force Solution
    public static int[] fullBloomFlowers(int[][] flowers, int[] people){

        // iterate over people array and keep count of person whose start < target

        int n = people.length;
        int[] result = new int[n];

        for(int i =0; i<n; i++){

            int target = people[i];
            int count = 0;

            // Count flowers that are in full bloom when the person arrives
            for(int j =0; j<flowers.length; j++){
                if(flowers[j][0] <= target && flowers[j][1] >= target){
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }


    // Optimized Solution using the binary search approach

    public static int[] fullBloomFlowersUsingBS(int[][] flowers, int[] people){
        int n = flowers.length;
        int[] start = new int[n];
        int[] end = new int[n];


        // storing the first and end of each pair in seprate array
        for(int i =0; i<n; i++){
            start[i] =flowers[i][0];
            end[i] = flowers[i][1];
        }


        Arrays.sort(start);
        Arrays.sort(end);

        int[] res = new int[people.length];



        for(int i =0; i<people.length; i++){
            int target = people[i];
            int started = binarySearchUpperBound(start,target);
            int ended = binarySearchLowerBound(end,target);
            res[i] = started - ended;
        }

        return res;
    }

    public static int binarySearchUpperBound(int[] arr, int target){
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static int binarySearchLowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[][] flowers = {{1,6},{3,7},{9,12},{4,13}};
        int[] people = {2,3,7,11};

//        int[][] flowers = {{1,10},{3,3}};
//        int[] people = {3,3,2};

        int[] result = fullBloomFlowersUsingBS(flowers, people);
        System.out.println(Arrays.toString(result));
    }
}
