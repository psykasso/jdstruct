package test;

import java.util.ArrayList;

import impl.ArrayCircleQueue;
import impl.ArrayQueue;

public class TestQueue {
	
	public static void main(String[] args) {
		ArrayCircleQueue a1 = new ArrayCircleQueue(5);
		
		//a1.dequeue();
		
		a1.enqueue(1);
		a1.enqueue(2);
		a1.enqueue(3);
		a1.enqueue(4);
		a1.enqueue(5);
		
		a1.dequeue();
		a1.dequeue();
		a1.dequeue();
		a1.dequeue();
		
		a1.enqueue(6);
		a1.enqueue(7);
		a1.enqueue(8);
		a1.enqueue(9);
		
		
		a1.dequeue();
		a1.dequeue();
		a1.dequeue();
		a1.dequeue();

		//a1.enqueue(10);
		a1.enqueue(11);
		a1.enqueue(12);
		a1.enqueue(13);
		
		System.out.println(a1.contains(8));
		
		ArrayList<Integer> ar = new ArrayList<Integer>();
		
		System.out.println(a1);
	}

}
