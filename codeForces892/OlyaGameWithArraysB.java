package codeForces892;

import java.util.*;

import java.util.*;

public class OlyaGameWithArraysB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Number of arrays
            long ans = 0;
            long mn1_m = Long.MAX_VALUE;
            long mn_m = Long.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int m = scanner.nextInt(); // Number of elements in the array
                long mn = Long.MAX_VALUE;
                long mn1 = Long.MAX_VALUE;

                for (int j = 0; j < m; j++) {
                    long x = scanner.nextLong();

                    if (x <= mn) {
                        mn1 = mn;
                        mn = x;
                    } else if (x < mn1) {
                        mn1 = x;
                    }

                    mn1_m = Math.min(mn1, mn1_m);
                    mn_m = Math.min(mn, mn_m);
                }

                ans += mn1;
            }

            ans += mn_m;
            ans -= mn1_m;

            System.out.println(ans);
        }
    }
}

