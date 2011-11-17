package test;

import impl.DBSTree;

public class TestDBSTree {
    public static void main(String[] args) {
        DBSTree tree = new DBSTree();
        tree.add(11);
        tree.add(6);
        tree.add(18);
        tree.add(3);
        tree.add(8);
        tree.add(15);
        tree.add(20);
        tree.add(9);
        tree.add(10);
        
        tree.inOrderTraversal();
        tree.postOrderTraversal();
        tree.preOrderTraversal();
        
        System.out.println("DLList : " + tree.toList());
        System.out.println("Depth : " + tree.depth());
        System.out.println("Right node count : " + tree.rightNodeCount());
        System.out.println("Max " + tree.largestItem());
    }
}
