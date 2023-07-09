package AdvLinkedList;

public class reverseLinkedList2 {

    static Node reverseBetween(Node head, int left, int right){
        Node dummy = new Node(0);  // Create a dummy node
        dummy.next = head;
        Node prev = dummy;

        // Move prev to the node before the sublist to be reversed
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        Node current = prev.next;
        for (int i = 0; i < right - left; i++) {
            Node nextNode = current.next;  // current node = 2 nextNode = 3
            current.next = nextNode.next;   // nextNode =3 . next = 4 so current.next = 4!
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        return dummy.next;
    }
    public static void main(String[] args) {

    }
}
