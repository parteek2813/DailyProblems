package codeForces892;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UnitedWeStandA {
    public static void main(String[] args) {
            solve();
    }

    public static void solve() {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt(); // Length of array a
            int[] a = new int[n]; // Array a
            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);
            ArrayList<Integer> b = new ArrayList<>();
            ArrayList<Integer> c = new ArrayList<>();

            b.add(a[0]);
            int i = 1;
            while (i < n && a[i - 1] == a[i]) {
                b.add(a[i++]);
            }

            while (i < n) {
                c.add(a[i++]);
            }

            if (c.size() == 0) {
                System.out.println("-1");
            } else {
                System.out.println(b.size() + " " + c.size());
                for (int num : b) {
                    System.out.print(num + " ");
                }
                System.out.println();
                for (int num : c) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
}
