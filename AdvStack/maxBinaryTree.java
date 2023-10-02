package AdvStack;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class maxBinaryTree {


    public static TreeNode ConstructMaxBinaryTreeStack(int[] nums){
        Stack<TreeNode> stack = new Stack<>();

        // The basic logic in the stack code is that if the number greater than stack ke peek ka aajaye
        // To unhe pop krke Us greater number ke left me daldo
        // Otherwise Right me dalte raho aur push karte raho

        for (int num : nums) {
            TreeNode currentNode = new TreeNode(num);
            while (!stack.isEmpty() && num > stack.peek().val) {
                currentNode.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().right = currentNode;
            }
            stack.push(currentNode);
        }
        return stack.isEmpty() ? null : stack.firstElement();
    }

    public static void printTree(TreeNode root){
        if (root == null) {
            System.out.print("null ");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);



        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    System.out.print(current.val + " ");
                    queue.offer(current.left);
                    queue.offer(current.right);
                } else {
                    System.out.print("null ");
                }
            }
        }
    }
    public static void main(String[] args) {

        int[] nums = {3,2,1,6,0,5};
        TreeNode finalRoot = ConstructMaxBinaryTreeStack(nums);

       printTree(finalRoot);


    }
}
