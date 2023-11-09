package LeetcodeContest;

public class findChampion1 {
    public static int findChampion(int[][] grid) {
        int n = grid.length;
        boolean[] isChampion = new boolean[n];

        for (int i = 0; i < n; i++) {
            boolean stronger = true;
            for (int j = 0; j < n; j++) {
                if (i != j && grid[j][i] == 1) {
                    stronger = false;
                    break;
                }
            }
            isChampion[i] = stronger;
        }

        for (int i = 0; i < n; i++) {
            if (isChampion[i]) {
                return i;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
//        int[][] grid = {{0,1},{0,0}};
        int[][] grid = {{0,0,1},{1,0,1},{0,0,0}};
        int result = findChampion(grid);
        System.out.println(result);

    }
}
