package AdvRecursion;

import java.util.ArrayList;
import java.util.List;

public class potdModerate {

    static ArrayList<ArrayList<Integer>> sumOfKxKMatrices(ArrayList<ArrayList<Integer>> arr, int k){
        int n = arr.size();

        // Store the result in a new ArrayList
        ArrayList<ArrayList<Integer>> resArr = new ArrayList<>();

        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                int sum = 0;
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        sum += arr.get(x).get(y);
                    }
                }
                ArrayList<Integer> subSumArr = new ArrayList<>();
                subSumArr.add(sum);
                resArr.add(subSumArr);
            }
        }

        return resArr;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(List.of(8,1,3)));
        arr.add(new ArrayList<>(List.of(2,9,3)));
        arr.add(new ArrayList<>(List.of(0,3,5)));


        int k = 2;
        ArrayList<ArrayList<Integer>> result = sumOfKxKMatrices(arr, k);
        System.out.println("Result: " + result);
    }
}
