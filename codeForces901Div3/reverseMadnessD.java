package codeForces901Div3;


import java.util.Scanner;
import java.util.*;

public class reverseMadnessD {

    static final int MOD = 1000000007;

    public static int upperBound(int[] list, int value) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (list[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();

        int[] l = new int[k];
        int[] r = new int[k];


        for (int i = 0; i < k; i++) {
            l[i] = sc.nextInt() - 1;
        }


        for (int i = 0; i < k; i++) {
            r[i] = sc.nextInt() - 1;
        }

        int q = sc.nextInt();
        int[] queries = new int[q];
        for (int i = 0; i < q; i++) {
            queries[i] = sc.nextInt() - 1;
        }

        int[] pref = new int[n];



        Map<Integer, Integer> mp = new HashMap<>();
        boolean[] visited = new boolean[n];

        for (int x : queries) {
            int itr = upperBound(l, x);
            itr--;

            int idx = itr - l[0];


            int left = Math.min(x, l[idx] + r[idx] - x);
            int right = Math.max(x, l[idx] + r[idx] - x);
            pref[left]++;
            pref[right]--;
        }

        for (int i = 0; i < k; i++) {
            int a = l[i];
            int b = r[i];
            while (a <= b) {
                mp.put(a, b);
                mp.put(b, a);
                a++;
                b--;
            }
            int cnt = 0;
            for (int j = l[i]; j <= r[i] + l[i] - j; j++) {
                cnt += pref[j];
                if ((cnt & 1) == 1) {
                    char[] chars = s.toCharArray();
                    char ch = chars[j];
                    chars[j] = chars[mp.get(j)];
                    chars[mp.get(j)] = ch;
                    s = new String(chars);
                }
            }
        }
        System.out.println(s);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            solve(sc);
        }
        sc.close();
    }
}





