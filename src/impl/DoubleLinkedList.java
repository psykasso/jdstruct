package impl;

/** <p> This class describes a double linked list data structure </p>
 * 	@author Samaras Apostolis e-mail: samarasa@it.teithe.gr
 * 	@version Last modified: 3/2/2004
 */

import interfaces.DataStructure;
import interfaces.List;

import java.util.Arrays;

import exceptions.StructureEmptyException;
import exceptions.StructureFullException;

public class DoubleLinkedList implements List {

    /**
     * Default constructor
     */
    public DoubleLinkedList() {
        firstNode = null;
        lastNode = null;
    }

    public Object getFirst() throws StructureEmptyException {

        if (isEmpty())
            throw new StructureEmptyException("The List is Empty!");

        return firstNode.getNodeItem();
    }

    public Object getLast() throws StructureEmptyException {

        if (isEmpty())
            throw new StructureEmptyException("The List is Empty!");

        return lastNode.getNodeItem();
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public boolean isFull() {
        return false;
    }

    public int size() {

        // This is different way of calculating size()

        int count = 0;
        DLListNode tempNode = firstNode;

        while (tempNode != null) {
            tempNode = (DLListNode) tempNode.getNextNode();
            count++;
        }

        return count;
    }

    public boolean contains(Object obj) {

        ListNode tempNode = firstNode;

        while (tempNode != null) {

            Object item = tempNode.getNodeItem();

            if (item.equals(obj))
                return true;

            tempNode = tempNode.getNextNode();
        }

        return false;
    }

    public void clear() {
        firstNode = null;
        lastNode = null;
    }

    // TODO change it
    public boolean equals(DataStructure otherStructure) {

        if (otherStructure.getClass() != DoubleLinkedList.class)
            return false;

        Object[] otherArray = ((DoubleLinkedList) otherStructure).toArray();
        Object[] thisArray = toArray();

        return Arrays.equals(otherArray, thisArray);
    }

    public Object[] toArray() {

        Object[] array = new Object[size()];

        ListNode iter = (ListNode) firstNode;

        int i = 0;
        while (iter != null) {
            array[i++] = iter.getNodeItem();
            iter = iter.getNextNode();
        }

        return array;
    }

    public void removeAll(DataStructure otherStructure) {

        Object[] array = ((DoubleLinkedList) otherStructure).toArray();

        for (int i = 0; i < array.length; i++)
            if (contains(array[i]))
                remove(array[i]);
    }

    public boolean addAll(DataStructure otherStructure) {

        Object[] array = ((DoubleLinkedList) otherStructure).toArray();

        for (int i = 0; i < array.length; i++)
            insertLast(array[i]);

        return true;
    }

    public boolean containsAll(DataStructure otherStructure) {

        Object[] array = ((DoubleLinkedList) otherStructure).toArray();

        for (int i = 0; i < array.length; i++)
            if (!contains(array[i]))
                return false;

        return true;
    }

    public void insertFirst(Object obj) throws StructureFullException {
        // TODO remove this
        if (isFull())
            throw new StructureFullException("The List is Full");

        if (isEmpty()) {
            firstNode = new DLListNode(null, obj, null);
            lastNode = firstNode;
        } else {
            DLListNode tempNode = new DLListNode(null, obj, firstNode);
            firstNode.setPreviousNode(tempNode);
            firstNode = tempNode;
        }
    }

    public void insertLast(Object obj) throws StructureFullException {
        // TODO remove this
        if (isFull())
            throw new StructureFullException("The List is Full");

        if (isEmpty()) {
            lastNode = new DLListNode(null, obj, null);
            firstNode = lastNode;
        } else {
            DLListNode tempNode = new DLListNode(lastNode, obj, null);
            lastNode.setNextNode(tempNode);
            lastNode = tempNode;
        }

    }

    public Object removeFirst() throws StructureEmptyException {

        // the list is empty
        if (isEmpty())
            throw new StructureEmptyException("The List is Empty!!");

        Object obj = firstNode.getNodeItem();

        // the list contains one node
        if (firstNode.getNextNode() == null)
            firstNode = lastNode = null;
        // the list contains more than one nodes
        else {
            DLListNode tempNode = (DLListNode) firstNode.getNextNode();
            firstNode.setNextNode(null);
            tempNode.setPreviousNode(null);
            firstNode = tempNode;
        }

        return obj;

    }

    public Object removeLast() throws StructureEmptyException {
        // the list is empty
        if (isEmpty())
            throw new StructureEmptyException("The List is Empty!!");

        Object obj = lastNode.getNodeItem();

        // the list contains one node
        if (lastNode.getPreviousNode() == null)
            firstNode = lastNode = null;
        // the list contains more than one nodes
        else {
            DLListNode tempNode = lastNode.getPreviousNode();
            lastNode.setPreviousNode(null);
            tempNode.setNextNode(null);
            lastNode = tempNode;
        }

        return obj;
    }

    public String toString() {

        String result = "[ "; // "Start <-->[ ";

        ListNode tempNode = firstNode;

        while (tempNode != null) {
            result += tempNode + " ";
            tempNode = tempNode.getNextNode();
        }

        return result + "]"; // <--> End";
    }

    // PRIVATE METHODS *********************************************************

    private void remove(Object obj) {

        DLListNode iter = firstNode;

        while (iter != null) {
            Object item = iter.getNodeItem();

            if (item.equals(obj)) {

                if (iter == firstNode)
                    removeFirst();
                else if (iter == lastNode)
                    removeLast();
                else {
                    DLListNode left = iter.getPreviousNode();

                    DLListNode right = (DLListNode) iter.getNextNode();

                    left.setNextNode(right);

                    right.setPreviousNode(left);
                }
            }

            iter = (DLListNode) iter.getNextNode();

        }// end while
    }

    // PRIVATE INSTANCE FIELDS *******************************************

    private DLListNode firstNode;
    private DLListNode lastNode;

    public DLListNode removeMin() {

        if (isEmpty())
            throw new StructureEmptyException("The List is Empty!!");

        DLListNode min = firstNode;
        DLListNode temp = firstNode;

        while (temp != null) {
            if ((Integer) temp.getNodeItem() < (Integer) min.getNodeItem())
                min = temp;
            temp = (DLListNode) temp.getNextNode();
        }

        if (min.equals(firstNode)) {
            removeFirst();
        } else if (min.equals(lastNode)) {
            removeLast();
        } else {
            // remove(min.getNodeItem());

            DLListNode left = min.getPreviousNode();
            DLListNode right = (DLListNode) min.getNextNode();
            left.setNextNode(right);
            right.setPreviousNode(left);

        }

        return min;

    }

    public DLListNode searchNode(Object data) {
        DLListNode temp = firstNode;

        while (temp != null) {
            if (temp.getNodeItem().equals(data))
                return temp;
            temp = (DLListNode) temp.getNextNode();
        }

        return new DLListNode(null, -1, null);
    }

    public DLListNode getFirstNode() {
        return firstNode;
    }

    public DLListNode getLastNode() {
        return lastNode;
    }

    public static void main(String args[]) {
        // thema 2o(reverse)
        /*
         * DoubleLinkedList list = new DoubleLinkedList();
         * 
         * for(int i=0; i<10; i++) list.insertLast((i+1));
         * 
         * System.out.println(list);
         * 
         * System.out.println("--------");
         * System.out.println(reverseList(list));
         * 
         * 
         * DoubleLinkedList list = new DoubleLinkedList();
         * 
         * list.insertLast(1); list.insertLast(2); list.insertLast(3);
         * list.insertLast(4); list.insertLast(5); list.insertLast(6);
         * list.insertLast(7); list.insertLast(8);
         * 
         * System.out.println(larger(list, 4));
         * 
         * 
         * 
         * DoubleLinkedList list = new DoubleLinkedList();
         * 
         * list.insertLast(5); list.insertLast(2); list.insertLast(3);
         * list.insertLast(1); list.insertLast(4); list.insertLast(5);
         * list.insertLast(1); list.insertLast(6); list.insertLast(7);
         * list.insertLast(1);
         * 
         * System.out.println(list); System.out.println("--------");
         * System.out.println(list.searchNode(10));
         * System.out.println("--------"); System.out.println(list);
         * 
         * *
         */

        DoubleLinkedList list1 = new DoubleLinkedList();
        list1.insertLast(1);
        list1.insertLast(2);
        list1.insertLast(3);
        list1.insertLast(4);
        list1.insertLast(5);

        DoubleLinkedList list2 = new DoubleLinkedList();
        list2.insertLast(6);
        list2.insertLast(7);
        list2.insertLast(8);
        list2.insertLast(9);
        list2.insertLast(10);
        list2.insertLast(11);

        System.out.println(listMerging2(list1, list2));
    }

    public static List larger(List inputList, int number) {

        List output = new DoubleLinkedList();

        ListNode temp = ((DoubleLinkedList) inputList).getFirstNode();

        while (temp != null) {

            if (number <= (Integer) temp.getNodeItem())
                output.insertLast(temp);

            temp = temp.getNextNode();
        }

        return output;
    }

    public static DoubleLinkedList listMerging(DoubleLinkedList list1,
            DoubleLinkedList list2) {
        DoubleLinkedList output = new DoubleLinkedList();

        ListNode temp = (DLListNode) list1.getFirstNode();

        while (temp != null) {
            output.insertLast(temp.getNodeItem());
            temp = temp.getNextNode();
        }

        temp = (DLListNode) list2.getFirstNode();

        while (temp != null) {
            output.insertLast(temp.getNodeItem());
            temp = temp.getNextNode();
        }

        return output;
    }

    public static DoubleLinkedList listMerging2(DoubleLinkedList list1,
            DoubleLinkedList list2) {
        DoubleLinkedList output = new DoubleLinkedList();

        ListNode temp1 = (DLListNode) list1.getFirstNode();
        ListNode temp2 = (DLListNode) list2.getFirstNode();

        ListNode tmp;

        if (list1.size() < list2.size()) {
            tmp = temp1;
            temp1 = temp2;
            temp2 = tmp;
        }

        while (temp1 != null) {
            output.insertLast(temp1.getNodeItem());

            if (temp2 != null)
                output.insertLast(temp2.getNodeItem());

            temp1 = temp1.getNextNode();

            if (temp2 != null)
                temp2 = temp2.getNextNode();
        }

        return output;
    }

    /**
     * Creates a new reversed Double Linked List from input list.
     * 
     * @param source
     * @return the source list in reverse order
     */
    public static DoubleLinkedList reverseList(List source) {
        // the reverse reverse that is going to be generated
        DoubleLinkedList reverse = new DoubleLinkedList();

        // get the size of source
        int s = source.size();

        // check if s is grater that zero and after substract it by 1
        while (s-- > 0) {
            // remove the last node
            Object obj = source.removeLast();
            // insert the above data to the beggining of the source reverse
            // after s iterations the reverse is going to transform to it's
            // original form.
            source.insertFirst(obj);

            // insert the content to the end of the generated reverse
            // that way the reverse is going to be reversed
            reverse.insertLast(obj);

        }
        return reverse;
    }

    public static DoubleLinkedList uniqueList(List source) {
        // the unique unique that is going to be generated
        DoubleLinkedList unique = new DoubleLinkedList();

        // get the size of source
        int s = source.size();

        // check if s is grater that zero and after substract it by 1
        while (s-- > 0) {
            // remove the last node
            Object obj = source.removeLast();
            // insert the above data to the beggining of the source unique
            // after s iterations the unique is going to transform to it's
            // original form.
            source.insertFirst(obj);

            // if the unique has no items or the objects are different
            // insert the item to the new unique
            if (unique.isEmpty() || unique.getFirst() != obj)
                // insert the content to the beggning of the unique to keep
                // the nodes in the correct order
                unique.insertFirst(obj);

        }
        return unique;
    }

    public static int elemLast(List source, int n) {
        // the item to return
        int item = -1;

        // get the size of source
        int s = source.size();

        // check if s is grater that zero and after substract it by 1
        while (s-- > 0) {
            // remove the last node
            Object obj = source.removeLast();
            // insert the above data to the beggining of the source unique
            // after s iterations the unique is going to transform to it's
            // original form.
            source.insertFirst(obj);

            // assuming that the 1st element from the end of the list
            // is the last element
            if (--n == 0)
                // java helps with primitives and objects
                item = (Integer) obj;

        }
        return item;
    }

    public static int lastSum(List source, int n) {
        // the sum
        int sum = 0;

        // get the size of source
        int s = source.size();

        // check if s is grater that zero and after substract it by 1
        while (s-- > 0) {
            // remove the last node
            Object obj = source.removeLast();
            // insert the above data to the beggining of the source unique
            // after s iterations the unique is going to transform to it's
            // original form.
            source.insertFirst(obj);

            // assuming that the 1st element from the end of the list
            // is the last element
            if (n-- > 0)
                // java helps with primitives and objects
                sum += (Integer) obj;

        }
        return sum;
    }
    
    public static int removeMin(List source) {
        // we assume that the last element is the smallest
        int min = (Integer) source.getLast();

        // get the size of source
        int s = source.size();

        // check if s is grater that zero and after substract it by 1
        while (s-- > 0) {
            // remove the last node
            Object obj = source.removeLast();
            // insert the above data to the beggining of the source unique
            // after s iterations the unique is going to transform to it's
            // original form.
            source.insertFirst(obj);

            // assuming that the 1st element from the end of the list
            // is the last element
            if (min > (Integer) obj)
                min = (Integer) obj;

        }
        
        removeElement(source, min);
        
        return min;
    }
    
    public static boolean removeElement(List source, int element) {
        int s = source.size();
        boolean found = false;
        // check if s is grater that zero and after substract it by 1
        while (s-- > 0) {
            // remove the last node
            Object obj = source.removeLast();
            // insert the above data to the beggining of the source unique
            // after s iterations the unique is going to transform to it's
            // original form.
            

            // assuming that the 1st element from the end of the list
            // is the last element
            if (element != (Integer) obj) {
                source.insertFirst(obj);
                found = true;
            }

        }
        
        return found;
    }
}