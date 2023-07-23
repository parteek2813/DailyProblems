package AdvRecursion;


//Given the root of a binary tree, flatten the tree into a "linked list":
// The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
//The "linked list" should be in the same order as a pre-order traversal of the binary tree.


 class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){this.val = val;}
     TreeNode(int val, TreeNode left, TreeNode right){
         this.val = val;
         this.left = left;
         this.right = right;
    }
}


class Pair{
     TreeNode head;
     TreeNode tail;

     Pair(TreeNode head, TreeNode tail){
         this.head= head;
         this.tail = tail;
     }
}


public class ConvertTree2Node {

    static Pair ConvertTree2LL(TreeNode root){

        if (root == null) {
            return null;
        }

        Pair leftLL = ConvertTree2LL(root.left);
        Pair rightLL = ConvertTree2LL(root.right);

        if(leftLL != null){
            leftLL.tail.right = root.right;
            root.right = root.left;
            root.left = null;

        }

        if(rightLL != null){
            return new Pair(root, rightLL.tail);
        }


        if(leftLL != null){
            return new Pair(root, leftLL.tail);
        }

        return new Pair(root, root);


    }

    static void printLinkedList(TreeNode head){
        TreeNode current = head;
        while (current != null){
            System.out.print(current.val + "->");
            current = current.right;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        Pair result = ConvertTree2LL(root);
        System.out.println(result.head);
        printLinkedList(result.head);

    }
}
