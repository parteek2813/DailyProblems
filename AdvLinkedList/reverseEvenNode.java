package AdvLinkedList;




public class reverseEvenNode {

    static class RNode{
        int data;
        RNode next;
    }

    static RNode start = null;



    // add node at beginning
    static void push(int new_data){
        RNode new_node = new RNode();
        new_node.data = new_data;
        new_node.next = start;
        start = new_node;
    }



    static void printList(RNode node){
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
    }


    static RNode reverse_even(RNode A){
        // for even pos
        RNode even = null;

        // odd pos
        RNode odd = A;

        // for handling the 3 cases when 1st or 2nd or 3rd is null
        if(odd == null || odd.next.next == null || odd.next == null){
            return odd;
        }

        while(odd!= null && odd.next != null){
            RNode temp  =  odd.next; // add even in temp
            odd.next = temp.next; // now next odd is [temp.next] walaa

            temp.next = even; // point temp.next ---> to --> even
            even = temp; // aur even ko temp banadiya

            // move odd to next odd
            odd = odd.next;
        }
        odd = A; // reset the odd pointer again to head..... jo ki last me chala gya tha loop ke baad

        // Merge list
        while(even != null){
            RNode temp = even.next;

            even.next = odd.next; // even next ka odd me aagaya

            odd.next = even;

            even = temp;

            odd = odd.next.next;



        }
        return A;
    }

    public static void main(String[] args) {
        push(6);
        push(5);
        push(4);
        push(3);
        push(2);
        push(1);

        start = reverse_even(start);
        printList(start);
    }
}
