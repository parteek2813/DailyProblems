package AdvArray;

import java.util.ArrayList;

public class advArrays {

    static boolean filterSum(int no, int[] arr, int X){
        ArrayList<Integer> list = new ArrayList<>();

        int j = arr.length -1;
        int sum =0;
        while (no > 0){
            int lastBit = (no & 1);
            if(lastBit ==1){
                list.add(0 , arr[j]);
                sum = sum + arr[j];
            }
            j--;
            no = no >>1; //for removing the last bit from no.
        }
        if(sum == X){
            System.out.println(list);
            return true;
        }
        return false;

    }
    static void filter(int no, int[] arr){
        ArrayList<Integer> list = new ArrayList<>();

        int j = arr.length -1;

        while (no > 0){
            int lastBit = (no & 1);
            if(lastBit ==1){
                list.add(0 , arr[j]);
            }
            j--;
            no = no >>1; //for removing the last bit from no.
        }
        System.out.println(list);

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int n = arr.length;

        for(int i =0; i< (1<<3); i++){
//            filter(i, arr);
            System.out.println(filterSum(i, arr , 4));
        }
    }
}
