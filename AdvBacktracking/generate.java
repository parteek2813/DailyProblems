package AdvBacktracking;

import java.util.Arrays;

public class generate {

    public static void generateBooleanString(int n ,int i, int output[]){
        // base case
        if(i==n){
            System.out.println(Arrays.toString(output));
            return;
        }

        // rec case
        output[i]=0;
        generateBooleanString(n, i+1, output);

        output[i] = 1;
        generateBooleanString(n, i+1, output);

    }
    public static void main(String[] args) {
        int n =3;
        int[] output = new int[n];

        generateBooleanString(n, 0, output);
    }
}
