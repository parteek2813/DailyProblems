package AdvTrees;

import AdvLinkedList.LinkedList;
import AdvLinkedList.Queue;
import org.w3c.dom.Node;

public class printAllLevels extends BinaryTree{

    static void levelOrderTraversal(Node root){

    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Queue<Node> q = new LinkedList<Node>();
        q.addLast(root);

        while(!q.empty()){
            Node f = q.poll();
            System.out.println(f.data);
            if(f.left != null){
                q.add(f.left);
            }
            if(f.right != null){
                q.add(f.right);
            }
        }
    }
}
