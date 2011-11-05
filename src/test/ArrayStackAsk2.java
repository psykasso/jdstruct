package test;

import exceptions.StructureEmptyException;
import impl.ArrayStack;
import interfaces.Stack;

public class ArrayStackAsk2 {
	
	public static boolean checkPalindrome(String str) {
		Stack source = new ArrayStack();
		Stack reverse = new ArrayStack();
		
		int first = 0;
		int last = str.length() - 1;
		
		for (int i = 0; i < str.length(); i++) {
			source.push(str.charAt(first++));
			reverse.push(str.charAt(last--));
		}
		
		System.out.println(source);
		System.out.println(reverse);
		
		
		boolean flag = true;
		
		while( ! source.isEmpty() && flag) {
			flag = source.pop() == reverse.pop();
		}
		
		return flag;
	}

	public static Stack reverseStack(Stack source) {
		
		Stack reverse = new ArrayStack();
		
		Stack temp = new ArrayStack();
		
		int size = source.size();
		
		for (int i = 0; i < size; i++) {
			reverse.push(source.pop());	
			temp.push(reverse.top());
		}
		
		while( ! temp.isEmpty() )
			source.push(temp.pop());
		
		return reverse;	
	}
	
	public static void checkParentheses(String expr) {

		ArrayStack stack = new ArrayStack();

		//deiktis gia to se poion xaraktira eimaste
		//mpainei edo gia na mporei na xrisimopoiithei kai sto catch
		int i = -1;

		try {
			//pernas enan enan tous xaraktires
			for (i = 0; i < expr.length(); i++) {
				//gia kathe ( kaneis push tin trexousa thesi
				if (expr.charAt(i) == '(')
					stack.push(i);
				//gia kathe ) kaneis pop
				else if (expr.charAt(i) == ')')
					stack.pop();
			}

			//ean ta zeygaria einai okey, to stack tha einai adeio
			if (stack.isEmpty())
				System.out.println("Okey!");
			//diaforetika ean exoume stoixeia pernoume to teleytaio
			//gia na mas deiksei pou exoume sfalma
			else
				System.out.println("Error at position : " + stack.pop());
			
		} catch (StructureEmptyException e) {
			System.out.println("Error at position : " + i);
		}
	}

	public static void main(String[] args) {
		String expr = "(1 + 3 ∗ 3 ∗ ((2 + 2)";

		checkParentheses(expr);
		
		//askisi 2.4
		Stack source = new ArrayStack();
		
		char c = 'a';
		
		for (int i = 0; i < 26; i++) 
			source.push(c++);

		Stack reverse = reverseStack(source);
		
//		System.out.println(source);
//		System.out.println(reverse);
		
		String str = "serres1";
		
		System.out.println(checkPalindrome(str));
	}
}
