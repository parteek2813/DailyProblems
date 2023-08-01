package codeForces888;
import java.io.*;
import java.util.*;


//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt(); // Number of test cases
//
//        for (int testCase = 0; testCase < t; testCase++) {
//            int n = scanner.nextInt(); // Length of the sequence of martian numbers
//            int k = scanner.nextInt(); // Value of k
//
//            int[] sequence = new int[n];
//            for (int i = 0; i < n; i++) {
//                sequence[i] = scanner.nextInt(); // Input the sequence of martian numbers
//            }
//
//            int maxVal = 0; // Maximum calculated value
//            int x = 0; // The chosen x
//            int iIndex = 0; // The chosen i
//            int jIndex = 0; // The chosen j
//
//            // Iterate through all possible values of x and calculate (ai⊕x)&(aj⊕x)
//            for (int currX = 0; currX < (1 << k); currX++) {
//                int currVal = 0;
//
//                for (int i = 0; i < n; i++) {
//                    for (int j = i + 1; j < n; j++) {
//                        int val = (sequence[i] ^ currX) & (sequence[j] ^ currX);
//                        if (val > currVal) {
//                            currVal = val;
//                            iIndex = i + 1;
//                            jIndex = j + 1;
//                            x = currX;
//                        }
//                    }
//                }
//
//                if (currVal > maxVal) {
//                    maxVal = currVal;
//                }
//            }
//
//            // Output the chosen i, j, and x
//            System.out.println(iIndex + " " + jIndex + " " + x);
//        }
//
//
//    }
public class LisaAndMartians {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            solver();
    }

    static void solver() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0) {

            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            Integer[] ids = new Integer[n];
            for (int i = 0; i < n; i++) {
                ids[i] = i;
            }

            Arrays.sort(ids, new Comparator<Integer>() {
                @Override
                public int compare(Integer l, Integer r) {
                    return Integer.compare(a[l], a[r]);
                }
            });

            int f = (1 << k) - 1;
            int ll = 0, rr = 0;
            int mi = Integer.MAX_VALUE;

            for (int i = 1; i < n; i++) {
                int l = ids[i - 1];
                int r = ids[i];
                if ((a[l] ^ a[r]) < mi) {
                    mi = a[l] ^ a[r];
                    ll = l;
                    rr = r;
                }
            }

            System.out.println((ll + 1) + " " + (rr + 1) + " " + (f - a[ll]));
        }
    }
}
