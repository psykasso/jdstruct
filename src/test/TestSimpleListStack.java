package test;

import impl.SimpleListStack;

public class TestSimpleListStack {
	public static void main(String[] args) {
		SimpleListStack list = new SimpleListStack();
		
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		
		System.out.println(list);
		
		System.out.println(list.pop());
		System.out.println(list.top());
		
		System.out.println(list);
	}
}
