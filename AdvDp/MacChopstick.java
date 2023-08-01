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


    public static void main(String[] args) {
        int[] chopStick = {5, 3, 10, 15, 12, 14, 18};
        int d = 3;
        int res = Maxchop(chopStick, d);


        System.out.println(res);
    }
}
