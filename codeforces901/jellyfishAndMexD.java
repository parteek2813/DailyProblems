package codeforces901;

import java.util.Scanner;

public class jellyfishAndMexD {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] cnt = new int[n+1];

        // storing freq of each element
        for(int i =0; i<n; i++){
            a[i] = scanner.nextInt();
            if(a[i] < n){
                cnt[a[i]]++;
            }
        }

        // find which first non negative integer is not present , then there m would stop
        int m =0;
        while (cnt[m] > 0){
            m++;
        }

        long[][] dp = new long[m][n+1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = (cnt[0] - 1) * i;
        }

        for(int i =1; i < m; i++){
            for(int j=0; j <= n; j++){
                dp[i][j] = dp[i-1][j];
                long curr = (cnt[i] - 1) * j + i + dp[i - 1][i];
                dp[i][j] = Math.min(dp[i][j], curr);
            }
        }

        System.out.println(dp[m - 1][n]);

    }
}
