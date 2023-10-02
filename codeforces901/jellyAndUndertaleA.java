package codeforces901;

import java.util.Scanner;

public class jellyAndUndertaleA {

    public static void findUndertale(){

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();

            // store in the array
            int[] nums = new int[n];
            for(int i =0; i<n; i++){
                nums[i] = sc.nextInt();
            }



            long ans = b-1;
            long c = 1;

            for(int i =0; i<n; i++){
                ans = ans + Math.min(c+nums[i], a) -1;
            }

            System.out.println(ans+1);
        }

    }
    public static void main(String[] args) {


        findUndertale();

    }
}
