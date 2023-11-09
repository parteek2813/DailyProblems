package codeForces906;

import java.util.HashSet;
import java.util.Scanner;

public class anonymousC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            long n = scanner.nextLong();
            long k = scanner.nextLong();

            long[] array = new long[(int) n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextLong();
            }

            long currentIndex = n - 1;
            boolean isValid = true;

            HashSet<Long> visitedIndices = new HashSet<>();
            for (int i = 0; i < k; i++) {
                if (visitedIndices.contains(currentIndex)) {
                    break;
                }
                if (array[(int) currentIndex] > n) {
                    isValid = false;
                    break;
                }
                visitedIndices.add(currentIndex);
                currentIndex = (currentIndex - array[(int) currentIndex] + n) % n;
            }

            System.out.println(isValid ? "YES" : "NO");
        }
    }
}
