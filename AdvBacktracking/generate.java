package AdvBacktracking;

import java.util.ArrayList;
import java.util.Arrays;

public class generate {

    public static void generateBooleanString(int n ,int i, Integer output[], ArrayList<Integer[]> arrayList){
        // base case
        if(i==n){
            // store
            arrayList.add(output.clone()); // pushing the copy of array not the actual output
//            System.out.println(Arrays.toString(output));
            return;
        }

        // rec case
        output[i]=4;
        generateBooleanString(n, i+1, output,arrayList);

        output[i] = 5;
        generateBooleanString(n, i+1, output,arrayList);

        output[i] = 6;
        generateBooleanString(n, i+1, output,arrayList);

    }
    public static void main(String[] args) {
        int n =3;
        ArrayList<Integer[]> arrList = new ArrayList<>();

        Integer[] output = new Integer[n];

        generateBooleanString(n, 0, output, arrList);

        for(Integer[] arr: arrList){
            System.out.println(Arrays.toString(arr));
        }
    }
}
