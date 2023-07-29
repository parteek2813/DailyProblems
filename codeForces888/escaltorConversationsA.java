package codeForces888;

import java.util.Scanner;

public class escaltorConversationsA {

//    private static int countConversations(int n, int m, int k, int H, int[] heights) {
//        int conversations = 0;
//
//        for (int i = 0; i < n; i++) {
//            int stepNumber = (heights[i] + k - 1) / k; // Calculate the corresponding step number
//
//            for (int j = 1; j <= m; j++) {
//                if (j != stepNumber && Math.abs(heights[i] - j * k) == Math.abs(H - j * k)) {
//                    conversations++;
//                    break;
//                }
//            }
//        }
//        return conversations;
//    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int H = scanner.nextInt();

            long[] ar = new long[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                ar[i] = scanner.nextLong();
                if (Math.abs(ar[i] - H) % k == 0) {
                    if (Math.abs(ar[i] - H) / k < m && Math.abs(ar[i] - H) != 0) { // if less than number of steps && diff b/w height is not zero
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }
    }

}



