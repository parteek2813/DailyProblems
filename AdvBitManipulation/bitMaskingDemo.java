package AdvBitManipulation;


// Question

// Given an array containing 3N + 1 no's every elements repeats twice except 1 unique
// number . find the unique Number

// Ex- 6,5,8,7,7,8,8,5, [2] ,5,6,6,7

// Here all elements are repeated three times except the 2

import java.lang.reflect.Array;
import java.util.Arrays;

public class bitMaskingDemo {

    static int uniqueNumber(){
        int[] arr = {6,5,8,7,7,8,8,5,2,5,6,6,7};
        int n = arr.length;

        int[] freq = new int[32];
        for(int x : arr){

            int j =0;

            //extract every bit of given number and add it to the sum at correct indx (j)
            while (x>0){
                int lastBit = (x&1);

                // if lastbit ==1; increase the frequency correspondingly
                if(lastBit==1){
                    freq[j]++;
                }
                j++;
                //remove the last bit
                x= x >> 1;
            }

        }

        //iterate over freq array to generate the numbner
        int p =1;
        int ans=0;
        for (int x : freq){

            ans = ans + (x%3)* p;
            p = p<<1;
        }
        System.out.println(ans);

        // freq array
        System.out.println(Arrays.toString(freq));
        return 1;

    }

    public static void main(String[] args) {
//        System.out.println(-8 >> 1);
//        System.out.println(-8 >>> 1); // Rarely Used
        uniqueNumber();
    }
}
