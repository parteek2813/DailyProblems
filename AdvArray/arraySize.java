package AdvArray;

// Question
// Given a matrix of size N*M and we are Q queries, find the sum of a given sub matrix. Each query will have 4 integers
// x1,y1,x2,y2 denoting the sub matrix

import java.util.Scanner;


public class arraySize {

    static void prefixSum(int[][] newTwoArr, int x1, int x2 , int y1 , int y2){

        int row1Len = newTwoArr.length;
        int col1len = newTwoArr[0].length;

        int[][] prefixSum = new int[row1Len][col1len];

        //Compute prefix sum for rows
        for(int i=0; i< row1Len; i++){
           prefixSum[i][0] = newTwoArr[i][0];
           for (int j=1; j<col1len; j++){
               prefixSum[i][j] = prefixSum[i][j-1] + newTwoArr[i][j];
           }
        }

        // Compute prefix sum for columns
        for (int j = 0; j < col1len; j++) {
            for (int i = 1; i < row1Len; i++) {
                prefixSum[i][j] += prefixSum[i - 1][j];
            }
        }

        // Submatrix Sum
        int submatrixSum =0;
        if(x1>0 && y1>0){
            submatrixSum = prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
        }else if(x1>0){
            submatrixSum = prefixSum[x2][y2] - prefixSum[x1 - 1][y2];
        } else if (y1>0) {
            submatrixSum = prefixSum[x2][y2] - prefixSum[x2][y1 - 1];
        } else{
            submatrixSum = prefixSum[x2][y2];
        }

//        submatrixSum = prefixSum[x2][y2] - prefixSum[x2][y1-1] - prefixSum[x1-1][y2] + prefixSum[x1-1][y1-1];

        System.out.println("Sum of the submatrix: " + submatrixSum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of queries:");
        int q = sc.nextInt();



        int[][] twoArr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
        };

        for(int i =0; i<q; i++){
            System.out.println("Enter x1");
            int x1 = sc.nextInt();
            System.out.println("Enter y1");
            int y1 = sc.nextInt();
            System.out.println("Enter x2");
            int x2 = sc.nextInt();
            System.out.println("Enter y2");
            int y2 = sc.nextInt();

            prefixSum(twoArr,x1,x2,y1,y2);
        }


    }
}
