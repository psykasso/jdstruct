package impl;

import interfaces.BSTree;
import interfaces.DataStructure;
import exceptions.StructureEmptyException;
import exceptions.StructureFullException;

/**
 * <p>
 * This class represents a binary search tree
 * </p>
 * 
 * @version Last modified: 1/6/2011
 */

public class DBSTree implements BSTree {

    public DBSTree() {

        root = null;
    }

    public boolean isEmpty() {

        return (size() == 0);
    }

    public boolean isFull() {

        return false;
    }

    public int size() {

        return count(root);
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Comparable))
            throw new IllegalArgumentException(
                    "Argument is not instance of Comparable.");

        return (search(root, (Comparable) obj) != null);
    }

    public void clear() {

        root = null;
    }

    public boolean equals(DataStructure otherStructure) {

        if (otherStructure.getClass() != DBSTree.class)
            return false;

        if (otherStructure.size() != size())
            return false;

        if (size() == 0)
            return true;

        return contains(root, (DBSTree) otherStructure);
    }

    public void add(Comparable item) throws StructureFullException {

        if (isFull())
            throw new StructureFullException("The Tree is Full");

        if (isEmpty())
            root = new TreeNode(item);
        else
            place(root, item);

    }

    public void remove(Comparable item) throws StructureEmptyException {

        if (isEmpty())
            throw new StructureEmptyException("The Tree is Empty");

        delete(root, null, item);

        // 2h lysh: isodynamo einai na poume
        /*
         * if ( contains(item) ) root = delete(root, item);
         */
    }

    // if we use removeRoot() to remove all items from a tree, we can add them
    // back in the tree and make the exact same tree
    public Comparable removeRoot() throws StructureEmptyException {

        if (isEmpty())
            throw new StructureEmptyException("The Tree is Empty");

        Comparable temp = root.getNodeItem();
        root = delete(root, temp);
        return temp;
    }

    public void inOrderTraversal() {
        System.out.println("INORDER TRAVERSAL");
        inOrder(root);
        System.out.println();
    }

    public void preOrderTraversal() {
        System.out.println("PREORDER TRAVERSAL");
        preOrder(root);
        System.out.println();
    }

    public void postOrderTraversal() {
        System.out.println("POSTORDER TRAVERSAL");
        postOrder(root);
        System.out.println();
    }

    // RECURSIVE PRIVATE METHODS ***********************************************

    // Recursive place the item to the correct node
    private void place(TreeNode node, Comparable item) {

        if (item.compareTo(node.getNodeItem()) < 0) // move left
        {
            if (node.getLeftNode() == null)
                node.setLeftNode(new TreeNode(item));
            else
                place(node.getLeftNode(), item);
        } else // move right
        {
            if (node.getRightNode() == null)
                node.setRightNode(new TreeNode(item));
            else
                place(node.getRightNode(), item);
        }
    }

    // Recursive search that returns the node containing the item
    private TreeNode search(TreeNode node, Comparable item) {

        if (node == null)
            return null;

        if (node.getNodeItem().equals(item))
            return node;

        if (item.compareTo(node.getNodeItem()) > 0)
            return search(node.getRightNode(), item);
        else
            return search(node.getLeftNode(), item);
    }

    // Returns true if the items in node and its children are all contained
    // within otherTree
    private boolean contains(TreeNode node, DBSTree otherTree) {

        if (!otherTree.contains(node.getNodeItem()))
            return false;

        boolean result = true;

        if (node.getLeftNode() != null)
            result &= contains(node.getLeftNode(), otherTree);
        if (node.getRightNode() != null)
            result &= contains(node.getRightNode(), otherTree);

        return result;
    }

    // Recursive delete for the remove() method
    private void delete(TreeNode node, TreeNode parent, Comparable item) {

        if (node == null)
            return;

        // item to be removed is in node
        if (node.getNodeItem().equals(item)) {

            // node contains item and has no children
            if (node.isLeaf()) {
                if (node == root) {
                    root = null;
                    return;
                }
                if (parent.getLeftNode() == node)
                    parent.setLeftNode(null);
                else
                    parent.setRightNode(null);
                return;
            }

            // node contains item and has only a left node
            if (node.getRightNode() == null) {
                if (node == root) {
                    root = node.getLeftNode();
                    return;
                }
                if (parent.getLeftNode() == node)
                    parent.setLeftNode(node.getLeftNode());
                else
                    parent.setRightNode(node.getLeftNode());
                return;
            }

            // node contains item and has only a right node
            if (node.getLeftNode() == null) {
                if (node == root) {
                    root = node.getRightNode();
                    return;
                }
                if (parent.getLeftNode() == node)
                    parent.setLeftNode(node.getRightNode());
                else
                    parent.setRightNode(node.getRightNode());
                return;
            }

            // node contains item and has both left and right nodes
            TreeNode maxL = node.getLeftNode();
            TreeNode maxLParent = node;

            while (maxL.getRightNode() != null) {
                maxLParent = maxL;
                maxL = maxL.getRightNode();
            }

            node.setNodeItem(maxL.getNodeItem());

            if (maxLParent == node)
                maxLParent.setLeftNode(maxL.getLeftNode());
            else
                maxLParent.setRightNode(maxL.getLeftNode());

            return;
        }

        // node does not contain item
        else if (node.getNodeItem().compareTo(item) > 0)
            delete(node.getLeftNode(), node, item);
        else
            delete(node.getRightNode(), node, item);

    }

    // Recursive delete for the removeRoot() method
    // H me8odos epistrefei ena TreeNode. Autos pou kalei thn synarthsh me
    // parametro ena node prepei
    // na kataxwrei thn epistrefomenh timh sto idio to node to opoio edwse ws
    // parametro, p.x.:
    // root = delete(root,item);
    // Ean to node me to opoio klh8hke h me8odos einai null, epistrefetai null.
    // Ean to node einai
    // auto to opoio periexei to item pou 8eloume na diagrapsoume, tote yparxoun
    // 2 periptwseis:
    // an to node einai fyllo, tote epistrefoume null. An to node den htan
    // fyllo, tote epistrefoume
    // to idio to node, afou kanoume tis aparaithtes allages.
    private TreeNode delete(TreeNode node, Comparable item) {
        if (node == null)
            return node;

        if (node.getNodeItem().equals(item)) { // item to be deleted is in node
            if (node.isLeaf()) // node is leaf
                return null;

            if (node.getRightNode() == null) { // node is not leaf, has right
                                               // node null, so left node is not
                                               // null
                node.setNodeItem(node.getLeftNode().getNodeItem());
                node.setRightNode(node.getLeftNode().getRightNode());
                node.setLeftNode(node.getLeftNode().getLeftNode());
            } else { // node is not leaf and has a right node
                node.setNodeItem(node.getRightNode().getNodeItem());
                if (node.getLeftNode() == null) // node is not leaf, has a right
                                                // node but no left node
                    node.setLeftNode(node.getRightNode().getLeftNode());
                else { // node is not leaf, has a right node AND a left node
                    TreeNode rightmostLeftNode = node.getLeftNode();
                    while (rightmostLeftNode.getRightNode() != null)
                        rightmostLeftNode = rightmostLeftNode.getRightNode();
                    rightmostLeftNode.setRightNode(node.getRightNode()
                            .getLeftNode());
                }
                node.setRightNode(node.getRightNode().getRightNode());
            }
            return node;
        }
        // item to be deleted is NOT in node
        if (node.getNodeItem().compareTo(item) > 0) { // if item is smaller than
                                                      // the node item, move
                                                      // left
            node.setLeftNode(delete(node.getLeftNode(), item));
            return node;
        } else { // if item is greater than the node item, move right
            node.setRightNode(delete(node.getRightNode(), item));
            return node;
        }
    }

    // Recursive count
    private int count(TreeNode node) {

        if (node == null)
            return 0;

        return count(node.getLeftNode()) + count(node.getRightNode()) + 1;
    }

    // Recursive inOrder
    private void inOrder(TreeNode node) {

        // if the current node is null return one level up
        if (node == null)
            return;

        inOrder(node.getLeftNode());
        System.out.print(node.getNodeItem() + ", ");
        inOrder(node.getRightNode());
    }

    // Recursive preOrder
    private void preOrder(TreeNode node) {

        // if the current node is null return one level up
        if (node == null)
            return;

        System.out.print(node.getNodeItem() + ", ");
        preOrder(node.getLeftNode());
        preOrder(node.getRightNode());
    }

    // Recursive postOrder
    private void postOrder(TreeNode node) {

        // if the current node is null return one level up
        if (node == null)
            return;

        postOrder(node.getLeftNode());
        postOrder(node.getRightNode());
        System.out.print(node.getNodeItem() + ", ");
    }

    // PRIVATE INSTANCE FIELDS
    // **************************************************
    protected TreeNode root;

    public DoubleLinkedList toList() {
        DoubleLinkedList list = new DoubleLinkedList();

        toListHelper(root, list);

        return list;
    }

    private void toListHelper(TreeNode node, DoubleLinkedList list) {
        // if the current node is null return one level up
        if (node == null)
            return;

        toListHelper(node.getLeftNode(), list);
        list.insertLast(node.getNodeItem());
        toListHelper(node.getRightNode(), list);
    }

    public int depth() {
        return treeDepth(root);
    }

    // TODO check
    private int treeDepth(TreeNode node) {
        if (node == null)
            return 0;

        int depth = 0;

        if ((node.getLeftNode() != null) && (node.getRightNode() != null))
            depth += treeDepth(node.getLeftNode())
                    + treeDepth(node.getRightNode()) + 1;
        else if (node.getLeftNode() != null)
            depth += treeDepth(node.getLeftNode()) + 1;
        else if (node.getRightNode() != null)
            depth += treeDepth(node.getRightNode()) + 1;

        return depth;
    }

    public int rightNodeCount() {
        return rightNodeCountHelper(root);
    }

    private int rightNodeCountHelper(TreeNode node) {
        if (node == null)
            return 0;

        int count = 0;

        if (node.getLeftNode() != null)
            count += treeDepth(node.getLeftNode()) + 0;
        if (node.getRightNode() != null)
            count += treeDepth(node.getRightNode()) + 1;

        return count;
    }

    public Comparable largestItem() {
        return largestItemHelper(root);
    }


    private Comparable largestItemHelper(TreeNode node) {
        if (node == null)
            return 0;

        Comparable max = node.getNodeItem();

        if (node.getLeftNode() != null) {
            largestItemHelper(node.getLeftNode());

            if (node.getLeftNode().getNodeItem().compareTo(max) > 0)
                max = node.getLeftNode().getNodeItem();
        }
        if (node.getRightNode() != null) {
            largestItemHelper(node.getRightNode());

            if (node.getRightNode().getNodeItem().compareTo(max) > 0)
                max = node.getRightNode().getNodeItem();
        }

        return max;

    }

}
