package AdvRecursion;


//Given the root of a binary tree, flatten the tree into a "linked list":
// The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
//The "linked list" should be in the same order as a pre-order traversal of the binary tree.


import java.util.ArrayList;

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

     static public TreeNode deleteNode(TreeNode root, int key) {
        // searching
        if(root == null){
            return null;
        }

        // key is less than root
        if(key < root.val){
            root.left = deleteNode(root.left, key);
            return root;
        }

        // key is greater than root
        else if(key > root.val){
            root.right = deleteNode(root.right, key);
            return root;
        }


        // deletion
        // key == root (this node should be deleted)
        // no child, 1 child, 2 child
        else{
            // if deletion node is leaf node , just return from it

            // no child
            if(root.left == null && root.right == null){
                return null;
            }
            // 1 child
            else if(root.left != null && root.right == null){
                return root.left;
            }else if(root.left == null && root.right != null){
                return root.right;
            }

            else{
                // 2 children
                TreeNode temp = root.left;
                // find max
                while(temp.right != null){
                    temp = temp.right; // go to exteme right
                }
                // replace root data with largest in LST
                root.val = temp.val;

                // delete the largest node too at last
                root.left = deleteNode(root.left,temp.val);

                return root;

            }
        }
    }

    public static int findClosestElement(TreeNode node, int k) {
        TreeNode temp = node;
        ArrayList<Integer> closestElements = new ArrayList<>();


        int minDiff = Integer.MAX_VALUE;

        while (temp != null) {
            int d = Math.abs(k - temp.val);
            if (d < minDiff) {
                closestElements.clear();
                closestElements.add(temp.val);
                minDiff = d;
            } else if (d == minDiff) {
                closestElements.add(temp.val);
            }

            if (temp.val < k ) {
                temp = temp.right;
            } else if (temp.val > k ) {
                temp = temp.left;
            } else {
                return temp.val;
            }
        }

        int minElement = closestElements.get(0);
        for(int i =1; i<closestElements.size(); i++){
            if(closestElements.get(i) < minElement){
                minElement = closestElements.get(i);

            }
        }
        return minElement;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(5);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right.right = new TreeNode(6);
//        Pair result = ConvertTree2LL(root);
//        System.out.println(result.head);
//        printLinkedList(result.head);

        TreeNode root = new TreeNode(17);
        root.left = new TreeNode(8);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(25);
//        System.out.println(findClosestElement(root, 19));

        TreeNode res = deleteNode(root, 18);
        printLinkedList(res);

    }



}
