package oving2;

import java.util.ArrayList;

public class Stack {
	ArrayList<String> stringList;
	
	public Stack() {
		stringList = new ArrayList<String>();
	}
	
	public void push(String string) {
		this.stringList.add(0, string);
	}
	
	public String pop() {
		if (stringList.size() > 0) {
			String returnval = stringList.get(0);
			this.stringList.remove(0);
			return returnval;			
		} else {
			return null;
		}
	}
	
	public String peek(int index) {
		if (index >= 0 && index < this.stringList.size()) {
			return stringList.get(index);			
		} else {
			return null;
		}
	}
	
	public int getSize() {
		return this.stringList.size();
	}
	
	public String toString() {
		String returnString = "";
		for (String s : this.stringList)
		{
		    returnString += s + "\t";
		}
		return returnString;
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push("Hei");
		System.out.println(stack);
		System.out.println(stack.peek(0));
		stack.push("yo");
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
	}
}
