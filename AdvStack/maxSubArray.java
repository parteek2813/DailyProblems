package AdvStack;

// question
// given an N array elememts , find the sum of maximum of every subarray

import java.util.Stack;

public class maxSubArray {
    static int[] getLeft(int[] arr){
        Stack<Integer> sc = new Stack<>();
        int n = arr.length;
        int[] p1 = new int[n];
        for(int i =0; i<n; i++){
            while (!sc.empty() && arr[i] >= arr[sc.peek()]){
                sc.pop();
            }
            if(!sc.empty()){
                p1[i] = i - sc.peek();
            }else{
                p1[i] = i+1;
            }
            sc.push(i);
        }
        return p1;
    }



    static int[] getRight(int[] arr){
        Stack<Integer> sc = new Stack<>();
        int n = arr.length;
        int[] p2 = new int[n];
        for(int i =n-1; i>=0; i--){
            while (!sc.empty() && arr[i] >= arr[sc.peek()]){
                sc.pop();
            }
            if(!sc.empty()){
                p2[i] = sc.peek() - i;
            }else{
                p2[i] = n - i;
            }
            sc.push(i);
        }
        return p2;

    }

    static int bruteSum(int[] arr){
        int n = arr.length;
        int ans =0;
        int[] p1 = getLeft(arr);
        int[] p2 = getRight(arr);

        int[] maxarr = new int[n*n];
        for(int i =0;i<n; i++){
            ans += (p1[i] ) * (p2[i] ) * arr[i];

        }
        return ans;
    }
    public static void main(String[] args) {

        int[] arr = { 1, 3, 2 };
        int res = bruteSum(arr);
        System.out.println(res);
    }
}
