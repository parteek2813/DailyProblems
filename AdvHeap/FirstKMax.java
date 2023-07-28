package AdvHeap;

// Question
// Given a marks of student in the array form for 1000 students, we have to find the first k
// Max marks from that array

// Sorting in desc order[merge sort] + get first k elements ....{extra memory is waster to sort unneeded elements}
// Heap

// Class for the heap
class Heap {
    int maxCap ;
    int size;
    int[] arr ;
    boolean minHeap;

    Heap(int c, boolean heaptype){
        this.maxCap = c;
        this.size =0;
        this.arr = new int[maxCap + 1];
        this.minHeap = heaptype;
    }


    void swap (int a, int b ){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    void add(int data ){

        if(size >= maxCap){
            System.out.println("Heap is full, can't add more elements");
            return;
        }
        size++;
        int idx = size;
        arr[idx] = data;

        int i = idx;
        while (i > 0 && (minHeap ? arr[i] < arr[i / 2] : arr[i] > arr[i / 2])) {
            swap(i, i / 2);
            i = i / 2;
        }

    }

    int getMax(){
        return arr[1];
    }

    int removeMax(){
        if(size == 0){
            System.out.println("Heap is empty, can't remove maximum");
            return -1;
        }

        int max = arr[1];
        arr[1] = arr[size];
        size--;

        int i =1;

        while (i<= size){

            int maxIndex  = i;
            int left = 2*i;
            int right = 2*i + 1;
            if(left <= size && arr[left] > arr[i]){
                maxIndex = left;
            }

            if(right <= size && arr[right] > arr[i]){
                maxIndex= right;

            }
            if(max ==i){
                break;
            }

            swap(arr[i], maxIndex);
            i = maxIndex;
        }
        return max;
    }

    void empty(){
        size= 0;
    }


}

public class FirstKMax {
    public static void main(String[] args) {
        Heap maxHeap = new Heap(10, false);
        maxHeap.add(5);
        maxHeap.add(10);
        maxHeap.add(7);
        maxHeap.add(3);
        maxHeap.add(20);
        System.out.println(maxHeap);
    }
}
