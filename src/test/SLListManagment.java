package test;

import impl.SimpleLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SLListManagment {

	private SimpleLinkedList list;

	public SLListManagment() {
		list = new SimpleLinkedList();
	}

	public int userInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			return Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out
					.println("Invalid Input ... try with some integer please.");
			return userInput();
		}
	}

	public void printMenu() {
		System.out.println("\n** Simple Linked List Managment **");
		System.out.println("----------------------------------");
		System.out.println("1- INSERT ELEMENT AT THE BEGINNING OF THE LIST");
		System.out.println("2- INSERT ELEMENT AT THE END OF THE LIST");
		System.out.println("3- DELETE FROM THE BEGINNING OF THE LIST");
		System.out.println("4- DELETE FROM THE END OF THE LIST");
		System.out.println("5- LIST LENGTH");
		System.out.println("6- IS THE LIST EMPTY");
		System.out.println("7- PRINT LIST");
		System.out.println("8- EXIT");
		System.out.print("INPUT YOUR CHOICE (E.G. 5):");
	}

	public void startProgram() {
		printMenu();
		int choise = -1;
		Object obj;
		while ((choise = userInput()) != 8) {
			System.out.println();
			switch (choise) {
			case 1:
				System.out.print("Enter a number to insert to list :");
				list.insertFirst(userInput());
				break;
			case 2:
				System.out.print("Enter a number to insert to list :");
				list.insertLast(userInput());
				break;
			case 3:
				obj = list.removeFirst();
				System.out.println("Removed item : " + obj);
				break;
			case 4:
				obj = list.removeLast();
				System.out.println("Removed item : " + obj);
				break;
			case 5:
				System.out.println("List length : " + list.size());
			case 6:
				if (list.isEmpty())
					System.out.println("The list is empty");
				else
					System.out.println("The list is not empty");
				break;
			case 7:
				System.out.println(list);
				break;

			} // end of switch

			printMenu();
		} // end of while

		System.out.println("Bye bye ...");
	}

	public static void main(String[] args) {
		new SLListManagment().startProgram();
	}

}
