package dpCollection;

import java.util.Arrays;

// Important question to look out for DP review
// adds a new angle of looking out prev solution
public class NinjaTraining7 {

    public static int f(int day, int last, int[][] points, int[][] dp){

        // base case
        if(day == 0){
            int maxi = 0;
            for(int task=0; task<3; task++){
                if(task != last){
                    maxi = Math.max(maxi, points[0][task]);
                }
            }

            return maxi;
        }


        // dp condition
        if(dp[day][last] != -1){
            return dp[day][last];
        }

        // rec case
        int maxi =0;

        for(int task=0; task<3; task++){
            if(task != last){
                // the points i will generate would be adding this day and then call to next day with
                // updated last day

                int point = points[day][task] + f(day-1, task, points, dp);
                maxi = Math.max(maxi, point);
            }
        }
        return dp[day][last] = maxi;
    }

    public static int NinjaTraining(int n , int[][] points){

        int[][] dp = new int[n][4];

        // for storing the -1 in each cell
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return f(n-1, 3, points, dp);
    }


    public static int NinjaTrainingTabu(int n , int[][] points){


        // TIME: O(N*4*3);
        // SPACE: O(N*4)

        // Let's proceed to space optimization

        int[][] dp = new int[n][4];

        dp[0][0] = Math.max(points[0][1] , points[0][2]);
        dp[0][1] = Math.max(points[0][0] , points[0][2]);
        dp[0][2] = Math.max(points[0][0] , points[0][1]);
        dp[0][3] = Math.max(points[0][0] , Math.max(points[0][1], points[0][2]));


        // day starts from 1 till n
        for(int day=1; day<n; day++){
            for(int last =0; last < 4; last++){
                dp[day][last]=0; // we're trying to compute this


                //copy-paste the entire rec code from top down approach from above
                for(int task=0; task<3; task++){
                    if(task != last){
                        int point = points[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }

        return dp[n-1][3];

    }

    public static int NinjaTrainingTabuSpace(int n , int[][] points){
        int[] prev = new int[4];

        // For space optimization, what we need to require is only 2 array
        // one for storing the prev value and other one for curr values
        // then prev array becomes equal to curr and so on

        // TIME: O(N*4*3);
        // SPACE: O(4)


        prev[0] = Math.max(points[0][1] , points[0][2]);
        prev[1] = Math.max(points[0][0] , points[0][2]);
        prev[2] = Math.max(points[0][0] , points[0][1]);
        prev[3] = Math.max(points[0][0] , Math.max(points[0][1], points[0][2]));


        // day starts from 1 till n
        for(int day=1; day<n; day++){

            int[] temp = new int[n];

            for(int last =0; last < 4; last++){
                temp[last]=0; // we're trying to compute this


                //copy-paste the entire rec code from top down approach from above
                for(int task=0; task<3; task++){
                    if(task != last){
                        int point = points[day][task] + prev[task];
                        temp[last] = Math.max(temp[last], point);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];
    }


    public static void main(String[] args) {
        int[][] points = {{1,2,5}, {3,1,1}, {3,3,3}};

        int n = 3;

        int res = NinjaTrainingTabu(n, points);
        System.out.println(res);
    }
}
