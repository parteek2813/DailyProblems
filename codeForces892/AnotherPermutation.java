package codeForces892;

import java.util.Scanner;

public class AnotherPermutation {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
           int n = sc.nextInt();

           int ans =0;
           int an1 = 0;

           for(int i =1; i<=n; i++){
               int temp = an1;
               int x = 0;

               int mx=0;

               for(int j=i; j<=n; j++){
                   mx = Math.max(mx, j*(n-x));
                   temp += (j*(n-x));
                   x++;
               }
               ans = Math.max(ans, temp-mx);
               an1 += (i*i);
           }
            System.out.println(ans);
        }

    }
}
