package AdvTrees;


public class TreesTest extends TNode{
    TreesTest(int d) {
        super(d);
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.print();
//        System.out.println(tree.getHeight());
        System.out.println(tree.getCalcNodes());


    }
}
