package AdvDp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Question
// Given N chopstivsk with their lengths, two chopsticks can be paired if |li-l2| <= D
// Find out the maximum number of chopsticks that can be paired
public class MacChopstick {

    static int Maxchop(int[] chopStick,int d){
        int n = chopStick.length;
        int count = 0;
        ArrayList<ArrayList<Integer>> ll = new ArrayList<>();


        Arrays.sort(chopStick);

        for(int i =0; i<n-1; i++){
            if(Math.abs(chopStick[i] - chopStick[i+1]) <= d ){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(chopStick[i]);
                pair.add(chopStick[i+1]);
                ll.add(pair);
                System.out.println(pair);
                count++;
                i++;
            }
        }
        return count;
    }

    static int MaxchopRec(int[] chopStick, int d, int idx) {
        int n = chopStick.length;

        // Base case: If all chopsticks are considered or there's only one chopstick left
        if (idx >= n - 1) {
            return 0;
        }

        // If the current chopstick can be paired with the next one
        int countIfPaired = 0;
        if (Math.abs(chopStick[idx] - chopStick[idx + 1]) <= d) {
            countIfPaired = 1 + MaxchopRec(chopStick, d, idx + 2);
        }

        // If the current chopstick is not paired with the next one
        int countIfNotPaired = MaxchopRec(chopStick, d, idx + 1);

        // Return the maximum count among the two possibilities
        return Math.max(countIfPaired, countIfNotPaired);
    }



    public static void main(String[] args) {
        int[] chopStick = {5, 3, 10, 15, 12, 14, 18};
        int d = 3;
        int res = Maxchop(chopStick, d);
//        int res = MaxchopRec(chopStick, d, 0);


        System.out.println(res);
    }
}
