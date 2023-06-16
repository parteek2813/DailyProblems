package AdvArray;


//Question - Mango Trees
// Ramu father has left a farm organizes as an N*N grid. Each square in the grid either has or does not have a mango tree
// He has to divide the farm with his three sisters as follows: he will draw one horizontal line and one vertical line to
// divide the field into four rectangles. His sisters will choose three of the four smaller fields and he gets th last one

// He wants to divide tht field so that he gets the maximum number of mangoes possible , assuming that his sisters will pick
// the best three rectangles

// FOr example , suppose the field looks as follows:

// Here # = Mangoes ; . = Nothing

//      .##...
//      #..##.
//      .#....
//      .##..#
//      #..##.
//      .#....

public class mangoTress {

    static int[][] PrefixSumBuild(int[][] newTwoArr){

        //Building the prefix sum array
        int row1Len = newTwoArr.length;
        int col1len = newTwoArr[0].length;

        int[][] prefixSum = new int[row1Len][col1len];

        //Compute prefix sum for rows
        for(int i=0; i< row1Len; i++){
            prefixSum[i][0] = newTwoArr[i][0];
            for (int j=1; j<col1len; j++){
                prefixSum[i][j] = prefixSum[i][j-1] + newTwoArr[i][j];
            }
        }

        // Compute prefix sum for columns
        for (int j = 0; j < col1len; j++) {
            for (int i = 1; i < row1Len; i++) {
                prefixSum[i][j] += prefixSum[i - 1][j];
            }
        }

        // returning prefixSum array to main
        return prefixSum;
    }

    static void findTheBestCut(int[][] PrefixSum){


        int N = PrefixSum.length; //rows
        int M = PrefixSum[0].length; //columns

        int ans=0;
        for(int x =0; x<= N-2; x++){
            for(int y=0; y<= M-2; y++){


                // Compute sum for each quadrant
                int Q1= PrefixSum[x][y];
                int Q2 = PrefixSum[x][M-1] - Q1;
                int Q3 = PrefixSum[N-1][y] - Q1;
                int Q4= PrefixSum[N-1][M-1] - Q1-Q2-Q3;

                int Ramu = Math.min(Math.min(Q1,Q2), Math.min(Q3,Q4)) ;

                // Find the best sum quadrant with max that ramu can get mangoes
                ans = Math.max(ans,Ramu);


            }
        }

        System.out.println(ans);


    }
    public static void main(String[] args) {
        int[][] twoArr = {
                {1,2,3,0},
                {5,0,7,0},
                {9,0,0,1},
        };

        int[][] PrefixSum =  PrefixSumBuild(twoArr);
        findTheBestCut(PrefixSum);
    }
}
