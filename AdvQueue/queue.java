package AdvQueue;

import java.util.PriorityQueue;

class QNode {
    int data;
    QNode next;


    public QNode(int d) {
        this.data = d;
        this.next = null;
    }

}

class Queue {
    QNode head, tail;

    public Queue() {
        this.head = this.tail = null;
        int size =0;

    }

    void enqueue(int data){

        QNode temp = new QNode(data);

        // if queue is empty,then new node will point to head and tail both

        if(this.head == null){
            this.head = this.tail = temp;

        }else{
            tail.next = new QNode(data);
             tail = tail.next;
        }

    }

    void dequeue(){

        if(this.head == null){
            return;
        }

        QNode temp = this.head;
        this.head = this.head.next;

        // make both head and tail null
        if(this.head == null){
            this.tail = null;
        }


        // IN C++ , No garbage collection
        // So to clear up ---> make new temp and then make temp.next = null!
    }
}

public class queue {

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    

}
