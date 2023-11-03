package AdvGraph;
import java.util.Arrays;

public class redundantConnection {
    public static int[] parent;

    // finding the parent
    private static int find(int x) {
        if (parent[x] == x)
            return x;

        return find(parent[x]);
    }

    private static void union(int a, int b) {

        // find is giving us the representative
        a = find(a);
        b = find(b);

        parent[a] = b;
    }

    public static int[] findRedundantConnection(int[][] e) {
        int n = e.length; // e.length because there are extra edges

        parent = new int[n + 1];
        Arrays.fill(parent, 0);

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }


        // traversing our edge list
        for (int[] a : e) {
            if (find(a[0]) == find(a[1]))
                return a;

            union(a[0], a[1]);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3}, {2,3}};
        int[] result = findRedundantConnection(edges);
        System.out.println("Redundant Connection: [" + result[0] + ", " + result[1] + "]");
    }
}
