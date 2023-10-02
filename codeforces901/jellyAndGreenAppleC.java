package codeforces901;

import java.util.Scanner;

public class jellyAndGreenAppleC {

    static void findGreenApple() {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while(t-- > 0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int ans = 0;
            int i = 0;
            while (n != 0 && i < 1000) {
                if (n >= m) {
                    n = n % m;
                } else {
                    ans += n;
                    n = n * 2;
                }
                i++;
            }

            if (n == 0) {
                System.out.println(ans);
            } else {
                System.out.println(-1);
            }
        }

    }


    public static void main(String[] args) {
        findGreenApple();
    }
}
