package AdvLinkedList;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
public class LinkedList {
    static Node CreateLL(int N){

        // Loop to create tje linkedlist
        Node head = new Node(1);
        Node tail = head;

        for(int i=2; i<=N; i++){
            tail.next = new Node(i);
            tail= tail.next;
        }

        return head;
    }

    static void printLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "-->");
            temp= temp.next;
        }
        System.out.println();
    }

    static int length(Node head){
        Node temp = head;
        int count =0;
        while(temp != null){
            count = count +1;
            temp= temp.next;
        }
       return count;
    }

    static Node insertAtHead(Node head, int data){
        Node n = new Node(data);
        n.next = head;

        head =n;
        return head; //return the new head

    }

    static Node insertInMiddle(Node head, int data, int pos){

        if(pos ==0){
            return insertAtHead(head, data);
        }
        if(pos> length(head)){
            return head; //if wanna insert at the end beyond the boundary just don't
        }


        Node temp = head;
        for(int jump =1; jump<=pos-1; jump++){
            temp= temp.next; //will reach / jump by the margin of 2
        }

        Node n = new Node(data);
        n.next = temp.next;
        temp.next =n;

        return head;
    }

    static int getKthElement(Node head, int K){
        Node temp = head;
        int i=0;
        if(K>length(head)){
            return -1;
        }
        while (i != K){
            temp = temp.next;
            i++;
        }
        if(temp == null) {
            return -1;
        }
        return temp.data;
    }

    public static void main(String[] args) {

        Node linkedList = CreateLL(7);
        System.out.println(length(linkedList));

        linkedList= insertAtHead(linkedList, 100); //updating of head
        printLL(linkedList);
        System.out.println(length(linkedList));


        linkedList = insertInMiddle(linkedList, 300, 3);
        printLL(linkedList);

        int resKth = getKthElement(linkedList, 3);
        System.out.println(resKth);
    }

}
