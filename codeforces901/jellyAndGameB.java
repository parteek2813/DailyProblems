package codeforces901;

import java.util.Arrays;
import java.util.Scanner;

public class jellyAndGameB {

    public static void findGame() {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();


            int[] jellyfish = new int[n];
            int[] gellyfish = new int[m];

            int sumJelly = 0;
            for(int i =0; i<n; i++){
                jellyfish[i] = sc.nextInt();
                sumJelly = sumJelly + jellyfish[i];
            }

            int sumGelly = 0;
            for(int i=0; i<m; i++){
                gellyfish[i] = sc.nextInt();
                sumGelly = sumGelly + gellyfish[i];
            }


            if(k % 2 != 0){
                Arrays.sort(jellyfish);
                Arrays.sort(gellyfish);

                int max = gellyfish[m-1];
                int min = jellyfish[0];

                int ans = sumJelly - min + max;
                System.out.println(ans);

            }

            if(k % 2 == 0){
                System.out.println(sumJelly);
            }

        }
    }

    public static void main(String[] args) {
        findGame();
    }
}
