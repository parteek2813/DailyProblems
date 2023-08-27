package AdvPq;

import java.util.ArrayList;

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
        int i = size;
        arr.add(data);
        heapifyUp(i);

    }

    void heapifyUp(int index){
        int parent = index/2;
        while (parent  > 0 && compare(arr.get(index-1), arr.get(parent-1))){
            swap(index-1, parent-1);
            index= parent;
            parent = index/2;

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
        return arr.get(1);
    }

    void removeMax(){
        swap(arr.size(), 1);
        size--;
        int i =1;

        while(true){
            int left = 2*i;
            int right = 2*i + 1;
            int max = i;

            if(left<= size && arr.get(left) > arr.get(i)){
                max = left;
            } else if (right <= size && arr.get(right) > arr.get(max)) {
                max= right;
            }

            if(max==i){
                break;
            }

            swap(i,max);
            i=max;
        }
    }
}
public class implementPQ {

    public static void main(String[] args) {
        PriorityQueue minPq = new PriorityQueue(10,  true);
        minPq.add(5);
        minPq.add(3);
        minPq.add(7);
        minPq.add(1);

        int res = minPq.getMax();
        System.out.println(res);
    }
}
