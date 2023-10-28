package CompaniesProblems;

public class googleOADp {


    public static void main(String[] args) {
        int[] a = {0,23,4,5,10};
        int[] b = {0,21,1,10,100};

        int n1 = a.length;
        int n2 = b.length;

        int[][] dp = new int[100005][2];

        dp[1][0] = a[1];
        dp[1][1] = b[1];

        for (int i = 2; i < Math.max(n1, n2); i++) {
            if (i < n1) {
                dp[i][0] = Math.max(dp[i - 1][0] + a[i], dp[i - 2][1] + a[i]);
            }
            if (i < n2) {
                dp[i][1] = Math.max(dp[i - 1][1] + b[i], dp[i - 2][0] + b[i]);
            }
        }
        System.out.println(dp[Math.max(n1, n2) - 1][0] + " " + dp[Math.max(n1, n2) - 1][1]);

    }
}
