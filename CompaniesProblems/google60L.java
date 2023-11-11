package CompaniesProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class google60L {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[] dp = new long[250000];
        long[] g = new long[250000];

        long n = scanner.nextLong();
        Map<Long, Long> kk = new HashMap<>();
        for (long i = 1; i <= n; i++) {
            long yy = scanner.nextLong();
            kk.put(yy, kk.getOrDefault(yy, 0L) + 1);
        }

        long answer = 0;
        for (long i = 1; i <= 100000 + 1; i++) {
            if (kk.getOrDefault(i, 0L) >= 1) { // agar current wala ki freq greater than or equal to 1
                dp[(int) i] = 1 + dp[(int) (i - 1)];
            } else {
                if (kk.getOrDefault(i - 1, 0L) >= 1) { // agar piche wali ki freq. greater than equal to 1 hein to 1 + piche wala g[i-1] add hojayega
                    dp[(int) i] = 1 + g[(int) (i - 1)];
                } else { // else dp[i] set kardo 0 agaain
                    dp[(int) i] = 0;
                }
            }

            if (kk.getOrDefault(i, 0L) >= 2) {
                g[(int) i] = 1 + dp[(int) (i - 1)];
            } else if (kk.getOrDefault(i, 0L) == 1) {
                if (kk.getOrDefault(i - 1, 0L) >= 1) {
                    g[(int) i] = 1 + g[(int) (i - 1)];
                } else {
                    g[(int) i] = 0;
                }
            } else {
                g[(int) i] = 0;
            }

            answer = Math.max(answer, dp[(int) i]);
            // System.out.println(dp[(int) i]);
            // System.out.println();
        }
        System.out.println(answer);
    }
}
