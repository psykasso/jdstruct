package test;

import impl.SimpleLinkedList;

public class TestSimpleLinkedList {
	public static void main(String[] args) {
		SimpleLinkedList list1 = new SimpleLinkedList();
		SimpleLinkedList list2 = new SimpleLinkedList();

		for (int i = 0; i < 10; i++) {
			list1.insertLast(i);
			if(i == 9)
				list2.insertLast(i+10);
			else
				list2.insertLast(i);
		}
		
		System.out.println(list1.equals(list2));
		System.out.println(list1);
		System.out.println(list2);

	}
}
