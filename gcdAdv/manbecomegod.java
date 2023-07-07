package gcdAdv;

import java.util.Scanner;

public class manbecomegod {


    public static int calculatePower(int[] villagers, int l, int r) {
        int power = 0;
        for (int i = l; i < r; i++) {
            power += Math.abs(villagers[i] - villagers[i + 1]);
        }
        return power;
    }


    public static int minimumSumOfPower(int[] villagers, int k) {
        int n = villagers.length;
        int[][] dp = new int[n + 1][k + 1]; // creating a dp 2d array

        // Calculate power for one group
        for (int i = 1; i < n; i++) {
            dp[i][1] = calculatePower(villagers, 0, i);
        }

        // Fill in the dp table
        for (int i = 2; i < n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x < i; x++) {
                    dp[i][j] = Math.min(dp[i][j], dp[x][j - 1] + calculatePower(villagers, x, i));
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases
        int t = scanner.nextInt();

        // Process each test case
        for (int testCase = 0; testCase < t; testCase++) {
            // Read the number of villagers and groups
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            // Read the suspicion levels of villagers
            int[] villagers = new int[n];
            for (int i = 0; i < n; i++) {
                villagers[i] = scanner.nextInt();
            }

            // Calculate and print the minimum sum of power
            int result = minimumSumOfPower(villagers, k);
            System.out.println(result);
        }
    }
}
