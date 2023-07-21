package AdvTrees;

import java.util.ArrayList;

import static AdvTrees.contructLevelBST.insertIntoBST;

public class LeftViewTree extends BinaryTreeNode<Integer> {

    LeftViewTree(Integer data) {
        super(data);
    }

    static int maxLvl = 0;

    static ArrayList<Integer> findLeftView(BinaryTreeNode<Integer> root, int lvl) {
        ArrayList<Integer> arr = new ArrayList<>();

        // Base case
        if (root == null) {
            return arr;
        }

        if (lvl > maxLvl) {
            arr.add(root.data);
            maxLvl = lvl;
        }

        // Recursive case

        // interchanging these two lines one above the other can be made to switch the left sub tree
        // as well as the right sub tree

        ArrayList<Integer> leftViewLeft = findLeftView(root.left, lvl + 1);
        ArrayList<Integer> leftViewRight = findLeftView(root.right, lvl + 1);

        // Combine the left views of left and right subtrees
        if (!leftViewLeft.isEmpty()) {
            arr.addAll(leftViewLeft);
        } else {
            arr.addAll(leftViewRight);
        }

        return arr;
    }

    static BinaryTreeNode<Integer> constructBstMethod1(ArrayList<Integer> levelOrder) {
        BinaryTreeNode<Integer> root = null;
        for (int i = 0; i < levelOrder.size(); i++) {
            root = insertIntoBST(root, levelOrder.get(i));
        }
        return root;
    }

    public static void main(String[] args) {
        ArrayList<Integer> levelOrderLeft = new ArrayList<>();
        levelOrderLeft.add(4);
        levelOrderLeft.add(2);
        levelOrderLeft.add(6);
        levelOrderLeft.add(1);
        levelOrderLeft.add(3);
        levelOrderLeft.add(5);
        levelOrderLeft.add(7);
        BinaryTreeNode<Integer> bst1 = constructBstMethod1(levelOrderLeft); // final root node
        ArrayList<Integer> res = findLeftView(bst1, 1);
        for (Integer num : res) {
            System.out.println(num);
        }
    }
}
