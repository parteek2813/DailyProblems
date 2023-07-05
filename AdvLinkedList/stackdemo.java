package AdvLinkedList;

class Node1{
    int data;
    Node next;

    Node1 (int d){
        data=d;
        next=null;

    }
}

public class stackdemo {
    Node head;

    stackdemo(){
        head = null;

    }

    void push(int d){
        if(head == null){
            head = new Node(d);

        }else{
            Node n = new Node(d);
            n.next = head;
            head = n;

        }
    }
    void pop(){
        if(head != null){
            head = head.next;

        }

    }
    int  top(){
        return head.data;

    }
}
