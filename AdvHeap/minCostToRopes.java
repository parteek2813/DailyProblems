package AdvHeap;


/*
* Question
* Given a lengths of N ropes , the cost merging two ropes is equal to the sum of their lengths
* Find the min cost to merge all ropes into a single rope.
*
*
* */

import java.util.PriorityQueue;

public class minCostToRopes {
    public static void main(String[] args) {

        int[] arr_ropes = {1,4,5,2,7};

        PriorityQueue<Integer> pq  = new PriorityQueue<Integer>();

        // Build a priority queue first
        for(int ropes: arr_ropes){
            pq.add(ropes);
        }

        // Get the max element R1 and R2 and remove them and add to cost

        int cost = 0;
        while (pq.size() != 1){
            int R1 = pq.poll();
            int R2 = pq.poll();

            cost += (R1 + R2);
            pq.add(R1+ R2);

        }

        // print the pq queue
        System.out.println(cost);
    }
}
