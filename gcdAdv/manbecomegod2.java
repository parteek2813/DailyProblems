package gcdAdv;

import java.util.Arrays;
import java.util.Scanner;

public class manbecomegod2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter t");
        int t = sc.nextInt();

        while (t-->0){
            System.out.println("Enter n");
            int n = sc.nextInt();
            System.out.println("Enter k");
            int k = sc.nextInt();

            // storing in array
            int[] arr = new int[n];
            for(int i =0; i<n; i++){
                 arr[i] = sc.nextInt();
            }

            // calculating the absolute difference
            int[] ar = new int[n-1];
            for(int i=1; i<n; i++){
                ar[i-1] = Math.abs(arr[i] - arr[i-1]);
            }

            //sorting difference array
            // the main logic of doing the sorting is that we want that the largest element comes at the
            // end of the difference array so that either it will be left out or if calculated then
            // difference it will contributing will be least at least as compared to the other elements of
            // the array .

            // here we runs loop through n-k steps so that last element diff in ar array can be neglected
            // here

            Arrays.sort(ar);

            int sum =0;
            for(int i=0; i<n-k; i++){
                sum = sum +ar[i];
            }
            System.out.println(sum);

        }
        System.out.println(-1);
    }
}
