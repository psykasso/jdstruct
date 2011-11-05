package impl;

import exceptions.StructureEmptyException;
import exceptions.StructureFullException;
import interfaces.DataStructure;
import interfaces.Queue;
/**
*	<p> This class constructs a Queue using an array</p>
*	@version Last modified: 16/3/2010
*/

public class ArrayQueue implements Queue {

	// Constructs an ArrayQueue with the default capacity
	public ArrayQueue() {

		this(DEFAULT_CAPACITY);
	}

	// Constructs an ArrayQueue with the given capacity
	public ArrayQueue(int cap) {

		pin = new Object[cap];
		first = last = 0;
	}

	public int size() {

		return last-first;
	}

	public boolean isEmpty() {

		return (size()==0);
	}

	public boolean isFull() {

		return (size()==pin.length);
	}

	public boolean contains(Object obj) {

		for (int i=first; i<last; i++)
			if (obj.equals(pin[i]))
				return true;

		return false;
	}

	public void clear() {

		// OPTIONAL 1
		// Good when there is little available memory space
		/*
		for (int i=first; i<last; i++)
			pin[i]=null;
		*/
		
		// OPTIONAL 2
		// Good when fast code is preferred
		/*
		int len = pin.length;
		pin = new Object[len];
		*/

		first=last=0;
	}

	/**
	*	<p>	Returns true if this structure is equal to the otherStructure.
	*	The other structure must be an ArrayQueue and must contain the exact same
	*	elements as this ArrayQueue and in the same order.
	*	@return boolean
	*	@param DataStructure
	*	</p>
	*/
	public boolean equals(DataStructure otherStructure) {

		if (otherStructure.getClass() != ArrayQueue.class) return false;

		if (otherStructure.size() != size()) return false;

		ArrayQueue tempQueue1 = new ArrayQueue(size());
		ArrayQueue tempQueue2 = new ArrayQueue(size());
			
		Object temp1, temp2;
			
		boolean flag = true;
			
		//scan the two stacks until they are empty or
		//find objects that do not match
		while ( ! isEmpty() ){
			temp1 = dequeue();
			temp2 = ((ArrayQueue)otherStructure).dequeue();
				
			tempQueue1.enqueue(temp1);
			tempQueue2.enqueue(temp2);
				
			if ( ! temp1.equals(temp2) ) {
				flag = false;
				//break; //WARNING error
			}
					
		}
			
		//restore the initial structures
		while( ! tempQueue1.isEmpty() ) {
			enqueue(tempQueue1.dequeue());
			((ArrayQueue)otherStructure).enqueue(tempQueue2.dequeue());
		}
			
		return flag;
	}

	public void enqueue(Object item) throws StructureFullException {

		if (isFull()) throw new StructureFullException("queue "+this+" is Full!");

		// ***** deals with the virtual overflow problem ****
		if (last==pin.length) alignment();

		pin[last++] = item;
	}

	public Object dequeue() throws StructureEmptyException {

		if (isEmpty()) throw new StructureEmptyException("queue "+this+" is Empty!");

		Object item = pin[first++];

		if (isEmpty()) clear(); //**** rewind first and last values ****

		return item;
	}

	public Object front() throws StructureEmptyException {

		if (isEmpty()) throw new StructureEmptyException("queue "+this+" is Empty!");

		return pin[first];
	}

	public String toString() {

		String out="<- [";

		for (int i=first;i<last;i++)
			out += " " + pin[i];

		return out+" ] <-";
	}

	// PRIVATE METHODS ***************************************************
	private void alignment() {

		for(int i=first; i<last; i++)
			pin[i-first] = pin[i]; // shift all pin[i] objects

		last -= first; // recalculate last value

		first = 0; // recalculate first value
	}


	// PRIVATE CONSTANTS *************************************************
	private static final int DEFAULT_CAPACITY = 100;
	// PRIVATE INSTANCE FIELDS *******************************************
	private Object[] pin;
	private int first,last;
}
