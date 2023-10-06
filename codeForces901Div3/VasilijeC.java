package codeForces901Div3;

import java.util.Scanner;

public class VasilijeC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            long n = sc.nextLong();
            long k = sc.nextLong();
            long x = sc.nextLong();

            long mn = ((k * (k + 1)) / 2);
            long mx = (k * (2 * n - k + 1)) / 2;

            if (x >= mn && x <= mx) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
