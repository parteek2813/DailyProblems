package codeForces903;

import java.util.Scanner;


/*
The key reason for taking the maximum value in this code is to find the minimum number of operations required to make the matrix a perfect square.


        Let's break it down:

        - The matrix is split into 4 quadrants. For each cell (i,j) in the top left quadrant, the corresponding cells in the other 3 quadrants are: (n-1-j,i), (n-1-i,n-1-j) and (j,n-1-i).

        - These 4 cells should contain the same letter when the matrix is a perfect square.

        - To make them equal, we need to increment the letters until they match the maximum of the 4 letters.

        - So for each set of 4 cells, we find the maximum letter, and calculate the number of increments needed for each of the other 3 cells to reach the max.

        - Summing this for all cells gives the minimum ops needed to make the matrix a perfect square.

        - Taking the max is crucial - incrementing to any lower value than the max will not make the 4 cells equal, so it will not result in a perfect square.


 */

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int mod = 1000000007;
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            String[] vec = new String[n];

            for (int i = 0; i < n; i++) {
                vec[i] = scanner.next();
            }

            long ans = 0;
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    char[] arr = {
                            vec[i].charAt(j),
                            vec[n - 1 - j].charAt(i),
                            vec[n - 1 - i].charAt(n - 1 - j),
                            vec[j].charAt(n - 1 - i)
                    };
                    char ch = 'a';
                    for (int k = 0; k < 4; k++) {
                        ch = (char) Math.max(ch, arr[k]);
                    }

                    for (int k = 0; k < 4; k++) {
                        ans += (ch - arr[k]);
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
