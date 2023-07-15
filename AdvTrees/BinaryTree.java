package AdvTrees;
import java.util.Scanner;

class TNode{
    int data;
    TNode left;
    TNode right;

    TNode (int d){
       data = d;
       left = right = null;
    }
}
public class BinaryTree {
//data
private TNode root;




//methods
    BinaryTree(){
        Scanner sc = new Scanner(System.in);
        root = buildTree(sc);

    }

    TNode buildTree(Scanner sc){

    int data = sc.nextInt();

        if(data == -1){
            return null;
        }

        TNode temp = new TNode(data);
        temp.left = buildTree(sc);
        temp.right = buildTree(sc);

        return temp;
    }

    void print(){
//         this.preOrderPrint(root);
           this.InOrderPrint(root);

    }

    void preOrderPrint(TNode root){
        //base case
        if(root==null){
            return;
        }

        // rec case
        System.out.println(root.data);
        preOrderPrint(root.left);
        preOrderPrint(root.right);

    }
    void InOrderPrint(TNode root){
        //base case
        if(root==null){
            return;
        }

        // rec case
        InOrderPrint(root.left);
        System.out.print(root.data + " ");
        InOrderPrint(root.right);

    }
    void postOrderPrint(TNode root){
        //base case
        if(root==null){
            return;
        }

        // rec case

        postOrderPrint(root.left);
        postOrderPrint(root.right);
        System.out.println(root.data);

    }

    int getHeight(){
        return height(root);
    }
    private int height(TNode root){

        //base case
        if(root == null){
            return 0;
        }

        //rec case
        int h1 = height(root.left);
        int h2 = height(root.right);

        return Math.max(h1,h2) + 1;
    }

    int getSum(){
        return sum(root);
    }

    private int sum(TNode root){

        // base case
        if(root == null ){
            return 0;
        }

        //rec case
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return (leftSum + rightSum) + root.data;
    }


    int  getCalcNodes(){
        int maxAnc= 0;
        int updatedMax = calcNodes( root, maxAnc);
        return updatedMax;

    }

    //Review this code and find the bug
    public int calcNodes(TNode root, int maxAnc){
        if(root == null){
            return 0;
        }
        int cnt =0; //local count
        if(root.data > maxAnc){
            cnt=1;
            maxAnc = root.data;
        }

        int lc = calcNodes(root.left, maxAnc);
        int rc = calcNodes(root.right, maxAnc);

        return lc+rc+cnt; //global count

    }
}
