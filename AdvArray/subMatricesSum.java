package AdvArray;

// Question

// given a matrix of size N*M , calculate the sum of all sub-matrics.


// Brute force time would be nearly - O(N6)
// Brute force for generating all submatrices + then calculate sum using prefixSum - O(N4)

// Optimized Approach - Hint!

// How many submatrices will include the given element A[i][j] ..?

// We can find out which element is being repeated how many times and then traverse matrix
// and multiply it with and then sum ..?


public class subMatricesSum {

    static int totalSubArray(int[][] twoArr){
        int N = twoArr.length;
        int M = twoArr[0].length;
        int sum =0;

        for(int i =0; i<N; i++){
            for(int j=0; j<M; j++){
                sum = sum + twoArr[i][j] *  (i+1)* (j+1) * (N-i)* (M-j);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[][] twoArr = {
                {3,1},
                {1,-2},
                {2,4},
        };

        int res = totalSubArray(twoArr);
        System.out.println(res);
    }
}
