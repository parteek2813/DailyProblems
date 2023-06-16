package AdvArray;

// Question

// Given a 2d array which is sorted along the rows and columns and we are given an element to search
// for the element in the array


import java.util.Arrays;
import java.util.HashSet;

public class elementSearch {

    static void UpdateArrayWithZero(int[][] arr){
        HashSet<Integer> RHS = new HashSet<>();
        HashSet<Integer> CHS = new HashSet<>();

        int N = arr.length;
        int M = arr[0].length;

        for(int i=0; i<=N-1; i++){
            for (int j=0; j<=M-1; j++){
                if(arr[i][j]==0){
                    RHS.add(i);
                    CHS.add(j);
                }
            }
        }

        for(int row: RHS){
            for(int k =0; k<=M-1; k++){
                arr[row][k]=0;
            }
        }
        for(int col: CHS){
            for(int k =0; k<=N-1; k++){
                arr[k][col]=0;
            }
        }

    }
    public static void main(String[] args) {

        int[][] arr = {
                {2,1,2,3},
                {4,0,1,2},
                {6,-1,2,6},
                {7,5,0,4},
        };

        UpdateArrayWithZero(arr);
        for(int[] row: arr){
            System.out.println(Arrays.toString(row));
        }
    }
}
