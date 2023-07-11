package AdvStack;

import java.util.Arrays;

public class stockSpan {

    static int[] bruteSpan(int[] arr){
        int n = arr.length;
        int[] span = new int[n];
        for (int i =0; i<n; i++){
            span[i]=1;
            for(int j=i-1; j>=0; j--){
                if(arr[j]>arr[i]){
                    break;
                }
                span[i]++;
            }
        }
        return span;
    }
    public static void main(String[] args) {
        int[] arr = {100,80,60,70,60,75,85};
        int[] res = bruteSpan(arr);
        System.out.println(Arrays.toString(res));
    }
}
