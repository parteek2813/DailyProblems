package AdvRecursion;

import java.util.* ;
import java.io.*;

class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
};
public class findPathsTrees {

    static void findAllPaths(BinaryTreeNode root, ArrayList<Integer> path, ArrayList<String> res) {
        // base case
        if (root == null) {
            return;
        }

        // base case 2
        if (root.left == null && root.right == null) {
            path.add(root.data);
            StringBuilder sb = new StringBuilder(); // using a stringBuilder() class and when the integer arraylist added all node of single path, just add that in string sb
            for (int data : path) {
                sb.append(data).append(" ");
            }
            res.add(sb.toString().trim()); // add in the string lists trim() function is used to remove trailing whitespaces
            path.remove(path.size() - 1);  // remove the last node from the list
            return;
        }

        // rec case
        path.add(root.data);
        findAllPaths(root.left, path, res);
        findAllPaths(root.right, path, res);
        path.remove(path.size() - 1);
    }

    public static ArrayList<String> allRootToLeaf(BinaryTreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        findAllPaths(root, path, res);
        return res;
    }

    public static void main(String[] args) {
        // Constructing the binary tree
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);

        // Finding all root-to-leaf paths
        ArrayList<String> result = allRootToLeaf(root);

        // Printing the output
        for (String path : result) {
            System.out.println(path);
        }
    }
}



