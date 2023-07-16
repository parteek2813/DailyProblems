package AdvTrees;
import java.util.ArrayList;
import java.util.Collections;

class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    public void cleanUp() {
        if (left != null) {
            left.cleanUp();
            left = null;
        }
        if (right != null) {
            right.cleanUp();
            right = null;
        }
    }
}
public class contructLevelBST {

    static BinaryTreeNode<Integer> insertIntoBST(BinaryTreeNode<Integer> root, int key) {
        if (root == null) {
            root = new BinaryTreeNode<Integer>(key);
            return root;
        }
        if (root.data > key) {
            root.left = insertIntoBST(root.left, key);
        } else {
            root.right = insertIntoBST(root.right, key);
        }
        return root;
    }
    static BinaryTreeNode<Integer> constructBstMethod1(ArrayList<Integer> levelOrder) {
        BinaryTreeNode<Integer> root = null;
        for (int i = 0; i < levelOrder.size(); i++) {
            root = insertIntoBST(root, levelOrder.get(i));
        }
        return root;
    }
    static BinaryTreeNode<Integer> constructUsingInorder(ArrayList<Integer> levelOrder, int s, int end) {
        if (s > end) {
            return null;
        }
        int mid = (end - s) / 2 + s;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(levelOrder.get(mid));
        root.left = constructUsingInorder(levelOrder, s, mid - 1);
        root.right = constructUsingInorder(levelOrder, mid + 1, end);
        return root;
    }
    static BinaryTreeNode<Integer> constructBstMethod2(ArrayList<Integer> levelOrder) {
        Collections.sort(levelOrder);
        BinaryTreeNode<Integer> root = null;
        root = constructUsingInorder(levelOrder, 0, levelOrder.size() - 1);
        return root;
    }
    static void inorderTraversal(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        // Method 1
        ArrayList<Integer> levelOrder1 = new ArrayList<>();
        levelOrder1.add(4);
        levelOrder1.add(2);
        levelOrder1.add(6);
        levelOrder1.add(1);
        levelOrder1.add(3);
        levelOrder1.add(5);
        levelOrder1.add(7);
        BinaryTreeNode<Integer> bst1 = constructBstMethod1(levelOrder1);
        System.out.print("Method 1: Inorder Traversal of Constructed BST: ");
        inorderTraversal(bst1);
        System.out.println();

        // Method 2
        ArrayList<Integer> levelOrder2 = new ArrayList<>();
        levelOrder2.add(4);
        levelOrder2.add(2);
        levelOrder2.add(6);
        levelOrder2.add(1);
        levelOrder2.add(3);
        levelOrder2.add(5);
        levelOrder2.add(7);
        BinaryTreeNode<Integer> bst2 = constructBstMethod2(levelOrder2);
        System.out.print("Method 2: Inorder Traversal of Constructed BST: ");
        inorderTraversal(bst2);
        System.out.println();

        // Clean up memory
        if (bst1 != null) {
            bst1.cleanUp();
        }
        if (bst2 != null) {
            bst2.cleanUp();
        }
    }
}

