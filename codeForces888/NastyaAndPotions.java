package codeForces888;

import java.util.*;

public class NastyaAndPotions {

    static void solve() {


        Scanner sc = new Scanner(System.in);
        List<List<Integer>> results = new ArrayList<>();
        int t = sc.nextInt();


        for (int test = 0; test < t; test++) {
            int n, k;
            n = sc.nextInt();
            k = sc.nextInt();

            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a.add(sc.nextInt());
            }

            List<Integer> have = new ArrayList<>(Collections.nCopies(n, 0));
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                have.set(--x, 1);
            }

            List<List<Integer>> g = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                g.add(new ArrayList<>());
            }
            List<Integer> ind = new ArrayList<>(Collections.nCopies(n, 0));

            for (int i = 0; i < n; i++) {
                int q = sc.nextInt();
                for (int j = 0; j < q; j++) {
                    int x = sc.nextInt();
                    x--;

                    g.get(x).add(i);
                    ind.set(i, ind.get(i) + 1);
                }
            }

            Queue<Integer> q = new LinkedList<>();
            List<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));

            for (int i = 0; i < n; i++) {
                if (ind.get(i) == 0) {
                    q.add(i);
                    if (have.get(i) == 1) {
                        ans.set(i, 0);
                    } else {
                        ans.set(i, a.get(i));
                    }
                }
            }

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int child : g.get(node)) {
                    ind.set(child, ind.get(child) - 1);
                    ans.set(child, ans.get(child) + ans.get(node));

                    if (ind.get(child) == 0) {
                        if (have.get(child) == 1) {
                            ans.set(child, 0);
                        }
                        ans.set(child, Math.min(ans.get(child), a.get(child)));
                        q.add(child);
                    }
                }
            }

            results.add(ans);
        }

        // Print the results for all test cases
        for (List<Integer> ans : results) {
            for (int i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       solve();
    }
}
