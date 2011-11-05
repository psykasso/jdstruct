package impl;

import exceptions.StructureEmptyException;
import exceptions.StructureFullException;
import interfaces.DataStructure;
import interfaces.List;

/** <p> This class describes a simple linked list obj structure </p>
* 	@version Last modified: 31/3/2010
*/

public class SimpleLinkedList implements List {

	public SimpleLinkedList() {
		firstNode = null;
		lastNode = null;
		counter = 0;
	}

	public boolean isEmpty() {
		return  (size()==0);
	}

	public boolean isFull() {
		return false;
	}

	public int size() {
		return counter;

	// Alternative implementation, without the need for the counter variable

	/*	ListNode p = firstNode;
		int c = 0;
		while (p!=null) {
			c++;
			p = p.getNextNode();
		}
		return c;
	*/
	}

	public boolean contains(Object obj) {

		ListNode tempNode = firstNode;

		while (tempNode!=null){

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
		counter = 0;
	}

	public boolean equals(DataStructure otherStructure) {

		if (otherStructure.getClass() != SimpleLinkedList.class) return false;

		if(otherStructure.size() != size() ) return false;

		int s = size();
		boolean flag = true;
		SimpleLinkedList otherList = (SimpleLinkedList)otherStructure;
//		SimpleLinkedList tempList1 = new SimpleLinkedList();
//		SimpleLinkedList tempList2 = new SimpleLinkedList();

		int i = 0;
		
		while (flag && i < s) {
//			Object temp1, temp2;
//			temp1 = otherList.removeFirst();
//			temp2 = removeFirst();
//			tempList1.insertFirst(temp1);
//			tempList2.insertFirst(temp2);
			insertLast(removeFirst());
			otherList.insertLast(otherList.removeFirst());
			
			if( !getLast().equals(otherList.getLast()) ) {
				flag = false;
			}
			i++;
		}

		while ( i < s ) {
//			otherList.insertFirst(tempList1.removeFirst());
//			insertFirst(tempList2.removeFirst());
			insertLast(removeFirst());
			otherList.insertLast(otherList.removeFirst());
			i++;
		}

		return flag;

	}

	public void insertFirst(Object obj) throws StructureFullException {

		if (isFull()) throw new StructureFullException("The List is Full");

		if (isEmpty())
		{
			firstNode = new ListNode(obj);
			lastNode = firstNode;
		}
		else
		{
			ListNode tempNode = new ListNode(obj,firstNode);
			firstNode = tempNode;
		}
		counter++;
	}

	public void insertLast(Object obj) throws StructureFullException {

		if (isFull()) throw new StructureFullException("The List is Full");

		if (isEmpty())
		{
			lastNode = new ListNode(obj);
			firstNode = lastNode;
		}
		else
		{
			ListNode tempNode = new ListNode(obj);
			lastNode.setNextNode(tempNode);
			lastNode = tempNode;
		}
		counter++;
	}

	public Object getFirst() throws StructureEmptyException {

		if (isEmpty()) throw new StructureEmptyException("The List is Empty!");

		return firstNode.getNodeItem();
	}

	public Object getLast() throws StructureEmptyException {

		if (isEmpty()) throw new StructureEmptyException("The List is Empty!");

		return lastNode.getNodeItem();
	}

	public Object removeFirst() throws StructureEmptyException {

		if (isEmpty()) throw new StructureEmptyException("The List is Empty!!");

		Object obj = firstNode.getNodeItem();

		if (size()==1)
			firstNode = lastNode = null;
		else
			firstNode = firstNode.getNextNode();

		counter--;

		return obj;
	}

	public Object removeLast() throws StructureEmptyException {

		if (isEmpty()) throw new StructureEmptyException("The List is Empty!!");

		Object obj = lastNode.getNodeItem();

		if (size()==1)
			firstNode = lastNode = null;
		else
		{
				ListNode tempNode = firstNode;

				while(tempNode.getNextNode()!=lastNode)
					tempNode = tempNode.getNextNode();

				tempNode.setNextNode(null);
				lastNode = tempNode;
		}

		counter--;

		return obj;
	}

	public String toString() {

		String result="Start <-->[ ";

		ListNode tempNode=firstNode;

		while (tempNode!=null)
		{
			result += tempNode + " ";
			tempNode = tempNode.getNextNode();
		}

		return result+" ]<--> End";
	}

	// PRIVATE INSTANCE FIELDS *************************************************
	private ListNode firstNode,lastNode;
	private int counter;
}
