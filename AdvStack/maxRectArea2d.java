package AdvStack;

// question

// given a 2d Matrix of 0's and 1's find out maximum Rectangular area which contains
// all 1's

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

// brute force
// generate all rectangles (x1,x2,y1,y2) ---> O(N^4) TIME
// then checking the at each elem if it is 1 or not ----> O(N^2) TIME
// Total time ==> O(N^6)
public class maxRectArea2d {

    static int getMin(int[] arr, int s , int e ){
        int min = arr[s];
        for(int i = s+1; i<= e; i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }

    static int[][] findPrefixArr(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        int[][] prefixArray = new int[n][m];

        // Initialize prefix array with the first row of the matrix
        for (int j = 0; j < m; j++) {
            prefixArray[0][j] = arr[0][j];
        }

        // Construct prefix array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    prefixArray[i][j] = 0;
                } else {
                    prefixArray[i][j] = prefixArray[i - 1][j] + arr[i][j]; // cal prefix sum as prefix sum of [previous row + current elem ]
                }
            }
        }

        return prefixArray;
    }
    static int findMaxAreawithStack(int[][] arr){
        int[][] prefixArr = findPrefixArr(arr);
        int maxArea = 0;
        int n = prefixArr.length;
        int m = prefixArr[0].length;

        for (int i = 0; i < n; i++) {
            int[] span = new int[m];
            Stack<Integer> sc = new Stack<>();

            for (int j = 0; j < m; j++) {
                while (!sc.empty() && prefixArr[i][j] <= prefixArr[i][sc.peek()]) {
                    sc.pop();
                }
                if (!sc.empty()) {
                    span[j] = j - sc.peek();
                } else {
                    span[j] = j + 1;
                }
                sc.push(j);
            }

            while (!sc.empty()) {
                sc.pop();
            }

            for (int j = m - 1; j >= 0; j--) {
                while (!sc.empty() && prefixArr[i][j] <= prefixArr[i][sc.peek()]) {
                    sc.pop();
                }
                if (!sc.empty()) {
                    span[j] += sc.peek() - j - 1;
                } else {
                    span[j] += m - j - 1;
                }
                sc.push(j);
            }

            for (int j = 0; j < m; j++) {
                int width = span[j];
                int height = prefixArr[i][j];
                int area = width * height;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    static int findMaxArea(int[][] arr){
        int[][] prefixArr = findPrefixArr(arr);

        int n = prefixArr.length;
        int m = prefixArr[0].length;


        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = j; k < m; k++) {
                    int width = k - j + 1;
                    int height = getMin(prefixArr[i], j, k);
                    int area = width * height;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;

    }
    public static void main(String[] args) {

        int[][] arr = {
                {1,1,0,1,0,1},
                {0,1,1,1,1,1},
                {1,1,1,1,1,0},
                {1,0,1,0,0,1},
                {1,1,0,0,1,1},
        };
//        int res = findMaxArea(arr);
//        System.out.println(res);
//        for (int i = 0; i < res.length; i++) {
//            System.out.println(Arrays.toString(res[i]));
//        }

        int res = findMaxAreawithStack(arr);
        System.out.println(res);


    }
}
