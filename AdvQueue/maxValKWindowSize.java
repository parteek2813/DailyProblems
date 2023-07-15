package AdvQueue;


// Question

// Given an array containing N elements , find out the max val of every window of size k

import java.util.Deque;
import java.util.LinkedList;

// EXAMPLE: arr = {10,11,8,9,7,6,5,11,3};
// Output would be : {11 11 9 9 7 11 11  };
public class maxValKWindowSize {

    static void bruteMax(int[] arr, int k){
        int n = arr.length;

        for(int i = 0; i <= n - k; i++){
            int max = arr[i];
            for(int j = i + 1; j < i + k; j++){
                if (arr[j] > max)
                    max = arr[j];
            }
            System.out.print(max + " ");
        }
    }

    static void dequeMax(int[] arr, int k){
        Deque<Integer> dq = new LinkedList<>();

        int n = arr.length;
        for(int i =0; i<k; i++){
            // remove smaller elements
            while(!dq.isEmpty() && arr[i]>= arr[dq.peekLast()]){
                dq.removeLast();
            }


            dq.addLast(i);
        }

        // for remaining elements
        // max element is always at front of the deque
        for(int i =k ; i<= n-1; i++){
            int output = arr[dq.peekFirst()];
            System.out.print(output + " ");


            // remove elements from front whose indices outside the window
            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.removeFirst();
            }

            // remove smaller element from back before pushing curr element

            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
                dq.removeLast();
            }

            // add curr element now
            dq.addLast(i);
        }
        System.out.print(arr[dq.peekFirst()]);
    }

    public static void main(String[] args) {
        int[] arr = {10, 1, 8, 9, 7, 6, 5, 11, 3};
        int k = 3;
//        bruteMax(arr, k);
        dequeMax(arr,k);

    }
}
