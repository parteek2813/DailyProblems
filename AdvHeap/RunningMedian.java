package AdvHeap;

import java.util.PriorityQueue;

/*
* Question: Running Median!
*
*
*
* */
public class RunningMedian {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

            int[] arr = {1,5,0,3,5};
            int[] arr1 = {1,32,12,12,14,3,3};
            for(int elem: arr1){
                pq.add(elem);
            }

        System.out.println(pq);

    }

}
