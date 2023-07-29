package codeForces888;

import java.util.Scanner;

public class ParitySortB {

    static boolean solveParity(int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((arr[i] % 2 == 0 && arr[j] % 2 == 0) || (arr[i] % 2 != 0 && arr[j] % 2 != 0)) {
                    if (arr[i] > arr[j]) {
                        // Swap
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            // Store the elements in the array
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            boolean res = solveParity(n, arr);
            System.out.println(res ? "YES" : "NO");
        }
    }
}
