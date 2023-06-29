package AdvSorting;


// question

// You are given a set of stalls in a barn and a set of cows. Each stall can
// accommodate only one cow. The goal is to assign the cows to the stalls in such
// a way that the minimum distance between any two cows is maximized. In other words,
// we want to find the largest possible value of the minimum distance between any two cows.

import java.util.Arrays;

// if we have the N stalls and C cows then the configuration we can make in the NCc Ways!
public class aggressiveCows {

    private static boolean canPlace(int[] stalls, int minSep, int C){
        int cows=1;
        int lastCow = stalls[0]; // here i had placed the one cow on first index with cnt++;

        for(int i=1; i<stalls.length; i++){

            if(stalls[i] - lastCow >= minSep) {
                cows++;
                lastCow = stalls[i];
                if (cows == C) {
                    return true; // if cows placed are equal to count, means cows are over
                }
            }
        }
        return false;
    }
    private static int binarySearch(int[] stalls, int C){
        int n = stalls.length;
        Arrays.sort(stalls);

        int s =0;
        int e = stalls[n-1] - stalls[0]; // max sepration at first

        int current_ans=-1;
        while (s<=e){
            int mid = (s+e)/2;
            if(canPlace(stalls, mid, C)){
                current_ans= mid;  //if not possible here then that means no need of going in right side array
                s = mid +1;
            }else{
                e = mid-1; // if we can't place
            }
        }
        return current_ans;
    }
    public static void main(String[] args) {
        int[] stalls = {1,2,8,4,9};

        int C = 3;
        int res = binarySearch(stalls, C);
        System.out.println(res);

    }
}
