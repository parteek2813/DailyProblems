package AdvLinkedList;

import AdvTrees.TNode;

public class Queue {
    // AdvLinkedList.Queue of Ints
    int arr[];
    int front;
    int rear;
    int cs;
    int maxSize;


    Queue(int defaultSize){
        maxSize = defaultSize;
        arr = new int[defaultSize];
        front =0;
        rear=0;
    }

    void push(int x){
        if(!full()){
            arr[rear] = x;
            rear= (rear+1)%maxSize;
            cs++;
        }
    }
    void pop(){
        if(!empty()){
        front = (front +1)% maxSize;
        cs--;
        }
    }

    boolean empty(){
        return cs==0;
    }

    boolean full(){
        return cs==maxSize;
    }

    int getFront(){
        if(!empty()){
            return arr[front];
        }else {
            System.out.println("AdvLinkedList.Queue is Empty");
            return -1;
        }

    }

    public void addLast(TNode root) {
    }
}
