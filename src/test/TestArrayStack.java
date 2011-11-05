package test;

import java.util.Random;

import impl.ArrayStack;

public class TestArrayStack {
	
	
	public static ArrayStack arrayStackGenerator(int n) {
		ArrayStack as = new ArrayStack(n);
		
		Random rnd = new Random();
		
		for (int i = 0; i < n; i++) {
			as.push(rnd.nextInt(100));
		}
		
		return as;
	}
	
	public static void main(String[] args) {
		ArrayStack as = arrayStackGenerator(10);
		ArrayStack as2 = arrayStackGenerator(10);
		
		
		System.out.println(as);
		int x = 10;
		System.out.println(as.equals(as2));

		
	}

}
