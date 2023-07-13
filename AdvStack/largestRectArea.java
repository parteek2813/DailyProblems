package AdvStack;

import java.util.Stack;

public class largestRectArea {

//    TIME- O(1)
//    static int getMin(int[] arr, int s , int e ){
//        int min = arr[s];
//        for(int i = s+1; i<= e; i++){
//            if(arr[i]<min){
//                min = arr[i];
//            }
//        }
//        return min;
//    }

    static int[] preprocessArray(int[] arr){
        int n =arr.length;
        int[] minArray  = new int[n];
        minArray[0] = arr[0]; // initially the min array is 0

        for(int i =1; i<n; i++){
            minArray[i] = Math.min(minArray[i-1], arr[i]);

        }
        return minArray;
    }

    static int getMin(int[] minArray , int s , int e){
        if(s == 0){
            // if start is 0;
            return minArray[e];
        }else{
            int min = minArray[e] = minArray[s-1];
            // else just return the min array diff to get the height we desire;
            return Math.min(min, minArray[e]);
        }
    }
    static int bruteArea(int[] arr){
        int n = arr.length;
        int[] minArray = preprocessArray(arr);
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int width = j - i + 1;
                int height = getMin(minArray, i, j);
                int area = width * height;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
    public static void main(String[] args) {
        int[] arr = {1,6,4,12,3,8};
        int res = bruteArea(arr);
        System.out.println(res);
    }
}
