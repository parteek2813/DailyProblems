package AdvStack;

import java.util.Arrays;
import java.util.Stack;

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

    static int[] stackSpan(int[] arr){
        int n = arr.length;
        int[] span = new int[n];
        Stack<Integer> sc = new Stack<>();
        for(int i=0; i<n; i++){
            while (!sc.empty() && arr[i] >= arr[sc.peek()]){
                sc.pop();
            }
            if(!sc.empty()){
                span[i] = i-sc.peek(); // subtract the current index from stack index stored;
            }else{
                span[i] = i+1;
            }
            sc.push(i);


        }
        return span;
    }


    public static void main(String[] args) {
        int[] arr = {100,80,60,70,60,75,85};
//        int[] res = bruteSpan(arr);
        int[] res = stackSpan(arr);
        System.out.println(Arrays.toString(res));
    }
}
