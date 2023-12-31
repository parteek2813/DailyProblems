package AdvDp;

import java.util.ArrayList;
import java.util.List;

public class diceGameUsingMatrix {
    public static long[][] multiplyMatrices(long[][] A, long[][] B) {
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;
        long[][] C = new long[m][p];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
    public static long findWaysToSum(int k, int n) {
        // Create the transition matrix
        long[][] T = new long[k + 1][k + 1];
        for (int i = 0; i <= k; i++) {
            T[0][i] = 1;
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= k; j++) {
                if (i <= j) {
                    T[i][j] = 1;
                }
            }
        }

        // Compute T^n using matrix exponentiation
        long[][] result = matrixExponentiation(T, n);

        // The answer is in result[0][k]
        return result[0][k];
    }

    public static List<List<Integer>> findCombinationsToSum(int k, int n) {
        // Create the transition matrix
        long[][] T = new long[k + 1][k + 1]; // T= [7][7]

        // store the first row with 1
        for (int i = 0; i <= k; i++) { // run till 0.1.2.3.....7
            T[0][i] = 1;
        }


        // store rest of matrix with 1 where i = j;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= k; j++) {
                if (i <= j) {
                    T[i][j] = 1;
                }
            }
        }

        // Compute T^n using matrix exponentiation
        long[][] result = matrixExponentiation(T, n);

        // Build combinations
        List<List<Integer>> combinations = new ArrayList<>();
        buildCombinations(result, n, k, new ArrayList<>(), combinations);

        return combinations;
    }


    public static void buildCombinations(long[][] result, int target, int current, List<Integer> combination, List<List<Integer>> combinations) {
        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int i = 1; i <= current; i++) {
            if (target >= i && result[i][current] > 0) {
                combination.add(i);
                buildCombinations(result, target - i, i, combination, combinations);
                combination.remove(combination.size() - 1);
            }
        }
    }

    public static long[][] matrixExponentiation(long[][] M, long exponent) {
        int n = M.length;
        if (exponent == 1) {
            return M;
        }
        if (exponent % 2 == 0) {
            long[][] halfExponentiation = matrixExponentiation(M, exponent / 2);
            return multiplyMatrices(halfExponentiation, halfExponentiation);
        } else {
            long[][] halfExponentiation = matrixExponentiation(M, (exponent - 1) / 2);
            long[][] result = multiplyMatrices(halfExponentiation, halfExponentiation);
            return multiplyMatrices(result, M);
        }
    }

    public static void main(String[] args) {
        int k = 6; // Number of faces on the dice
        int n = 4; // Desired sum

//        long ways = findWaysToSum(k, n);
//        System.out.println("Number of ways to get a sum of " + n + " with " + k + " dice is: " + ways);

        List<List<Integer>> combinations = findCombinationsToSum(k, n);
        System.out.println("Combinations to get a sum of " + n + " with " + k + " dice are:");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }

    }
}


