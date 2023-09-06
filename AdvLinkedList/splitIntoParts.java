package AdvLinkedList;

import javax.swing.*;
import java.util.List;


public class splitIntoParts {


    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode[] IntoParts(ListNode head, int k) {
        ListNode[] parts = new ListNode[k];

        int len =0;

        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // declare n and k
        int n = len/k;
        int r = len % k;

        temp = head;

        // iterate
        for(int i =0; temp != null && i < k; i++, r--){
            parts[i] = temp;
            for(int j =0; j< n+(r>0 ? 1 : 0); j++){
                head = temp;
                temp = temp.next;

            }

            // if prev is not null, when one part is over
            if( head != null){
                head.next = null;
            }
        }

        return parts;

    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next= new ListNode(7);

        int k = 2;

        ListNode[] parts = IntoParts(head,k);


        // print the result

        for(int i =0; i< parts.length; i++){
            System.out.print("Part " + i + ": ");

            ListNode current = parts[i];
            while (current != null){
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }

    }
}
