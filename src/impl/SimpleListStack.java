package impl;

import exceptions.StructureEmptyException;
import exceptions.StructureFullException;
import interfaces.DataStructure;
import interfaces.Stack;

public class SimpleListStack implements Stack {

	
	public SimpleListStack() {
		list = new SimpleLinkedList();
	}
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean contains(Object obj) {
		return list.contains(obj);
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public boolean equals(DataStructure otherStructure) {
		return list.equals(otherStructure);
	}

	@Override
	public void push(Object element) throws StructureFullException {
		list.insertLast(element);
	}

	@Override
	public Object pop() throws StructureEmptyException {
		return list.removeLast();
	}

	@Override
	public Object top() throws StructureEmptyException {
		return list.getLast();
	}
	
	@Override
	public String toString() {
		return list.toString();
	}




	private SimpleLinkedList list;

}
