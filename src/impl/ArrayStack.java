package impl;

import interfaces.DataStructure;
import interfaces.Stack;

import exceptions.StructureEmptyException;
import exceptions.StructureFullException;

/**
*	<p> This class describes a Stack implementation through arrays </p>
*
*	@version Last modified: 10/3/2010
*/


public class ArrayStack implements Stack {
	
	/**
	*	<p> Constructs an array stack with the default capacity </p>
	*/
	public ArrayStack() {

		this(DEFAULT_CAPACITY);		
	}

	/**
	*	<p> Constructs an array stack with the given capacity
	*	@param int
	*	</p>
	*/
	public ArrayStack(int cap) {

		pin = new Object[cap];
		last = 0;
	}

	public int size() {

		return last;
	}

	public boolean isEmpty() {

		return (size()==0);
	}

	public boolean isFull() {

		return (size()==pin.length);
	}

	public boolean contains(Object obj) {

		for (int i=0; i<last; i++)
			if (obj.equals(pin[i]))
				return true;

		return false;
	}

	public void clear() {

		// OPTIONAL 1
		// Good when there is little available memory space
		/*
		for (int i=0; i<last; i++)
			pin[i]=null;
		*/
		
		// OPTIONAL 2
		// Good when fast code is preferred
		/*
		int len = pin.length;
		pin = new Object[len];
		*/

		last=0;
	}
	
	/**
	*	<p>	Returns true if this structure is equal to the otherStructure.
	*	The other structure must be an ArrayStack and must contain the exact same
	*	elements as this ArrayStack and in the same order.
	*	@return boolean
	*	@param DataStructure
	*	</p>
	*/
	public boolean equals(DataStructure otherStructure) {

		if (otherStructure.getClass() != ArrayStack.class) return false;

		if (otherStructure.size() != size()) return false;

		ArrayStack tempStack1 = new ArrayStack(size());
		ArrayStack tempStack2 = new ArrayStack(size());
			
		Object temp1, temp2;
			
		boolean flag = true;
			
		//scan the two stacks until they are empty or
		//find objects that do not match
		while ( ! isEmpty() ){
			temp1 = pop();
			temp2 = ((ArrayStack)otherStructure).pop();
				
			tempStack1.push(temp1);
			tempStack2.push(temp2);
				
			if ( ! temp1.equals(temp2) ) {
				flag = false;
				break;
			}
					
		}
			
		//restore the initial structures
		while( ! tempStack1.isEmpty() ) {
			push(tempStack1.pop());
			((ArrayStack)otherStructure).push(tempStack2.pop());
		}
			
		return flag;
	}

	public Object top() throws StructureEmptyException {

		if (isEmpty())
			throw new StructureEmptyException("stack "+this+" is Empty!");

		return pin[last-1];
	}

	public void push(Object item) throws StructureFullException {

		if (isFull())
			throw new StructureFullException("stack "+this+" is Full!");

		pin[last++]=item;
	}

	public Object pop() throws StructureEmptyException {

		if (isEmpty())
			throw new StructureEmptyException("stack "+this+" is Empty!");

		return pin[--last];
	}
	
	/**
	*	<p> Overrides the toString() method in class Object </p>
	*/
	public String toString() {

		String out="[";

		for (int i=0;i<last;i++)
			out += " " + pin[i];

		return out+" ] <-->";
	}

	// PRIVATE CONSTANT *****************************************
	private static final int DEFAULT_CAPACITY = 100;
	// PRIVATE INSTANCE FIELDS **********************************
	private int last;
	private Object[] pin;
}
