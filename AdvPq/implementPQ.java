package AdvPq;

import java.util.ArrayList;

// Time Complexity
// MaxHeap()
// getMax() --> O(1)
// removeMax() --> O(LogN)
// insert(data) --> O(LogN)

// Heap can't be termed as BST as S stands for the search optimized tree but here
// The Heap is not search optimized tree as we really don't know in which directions
// would be even go [left or right]


class PriorityQueue{
    int initCap;
    int size;
    ArrayList<Integer> arr;
    boolean minHeap;

    PriorityQueue(int c , boolean minHeap){
        initCap = 1;
        size =0;
        arr = new ArrayList<Integer>();
        this.minHeap = minHeap;
    }

    void add(int data){
        this.size++;
        arr.add(data);
        heapifyUp(size - 1);

    }

    void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && compare(arr.get(index), arr.get(parent))) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }


    boolean compare(int a , int b ){
        return minHeap ? a<b : a>b;
    }

    void swap(int i , int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    int getMax(){
        return arr.get(0);
    }

    void removeMax() {
        swap(0, size - 1);
        arr.remove(size - 1);
        size--;

        int i = 0;

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < size && arr.get(left) < arr.get(smallest)) {
                smallest = left;
            }
            if (right < size && arr.get(right) < arr.get(smallest)) {
                smallest = right;
            }

            if (smallest == i) {
                break;
            }

            swap(i, smallest);
            i = smallest;
        }
    }

}
public class implementPQ {

    public static void main(String[] args) {
        PriorityQueue minPq = new PriorityQueue(10,  true);
//        minPq.add(5);
//        minPq.add(3);
//        minPq.add(7);
//        minPq.add(1);

        minPq.add(10);
        minPq.add(40);
        minPq.add(30);
        minPq.add(5);
        minPq.removeMax();


        int res = minPq.getMax();
        System.out.println(res);
    }
}
