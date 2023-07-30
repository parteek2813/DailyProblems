package codeForces888;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class prefixPermutationSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-->0){
            int n = sc.nextInt();
            long[] A = new long[n];


            // store (n-1) elements in Array
            for(int i  =0; i<n-1; i++){
                A[i] = sc.nextLong();
            }


            long sum = n;
            sum = sum * (sum + 1L);
            sum /= 2L;


            // CASE 1
            // if the las 2nd element of array is greater than the sum , then print No
            if(A[n-2] > sum){
                System.out.println("NO");
                continue;
            }


            Set<Long> avail = new HashSet<>();

            // add element in hashset to store uniqueness
            for(int i=1; i<=n; ++i){
                avail.add((long) i);
            }


            int c = 0;
            long  val = -1, star = -1;
            int f = 0;

            for(int i=1; i<n-1; ++i){
                long diff = A[i] - A[i-1];
                if(!avail.contains(diff)){ // if not contains , add to set
                    val = diff;
                }else{
                    avail.remove(diff);
                }
            }


            // CASE 2
            if(A[n-2] == sum){
                // either from start
                if(avail.size() == 2){
                    long cur_sum = 0;
                    for(long x : avail){
                        cur_sum += x;
                    }


                    if (cur_sum == A[0]) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }else if (avail.size() > 3) {
                    System.out.println("NO");
                }else {
                    // it means from middle
                    if (!avail.contains(A[0])) {
                        System.out.println("NO");
                    } else {
                        avail.remove(A[0]);
                        long cur_sum = 0;
                        for (long x : avail) {
                            cur_sum += x;
                        }
                        if (cur_sum == val) {
                            System.out.println("YES");
                        } else {
                            System.out.println("NO");
                        }
                    }
                }
            }else {
                // last value is removed
                if (avail.size() > 2) {
                    System.out.println("NO");
                } else if (!avail.contains(A[0])) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
    }
}
