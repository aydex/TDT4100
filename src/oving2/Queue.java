package oving2;

import java.util.ArrayList;

public class Queue {
	
	ArrayList<String> queue;
	
	public Queue() {
		
	}
	
	public Queue(String str) {
		queue = new ArrayList<String>();
		queue.add(str);
	}
	
	public void push(String str) {
		queue.add(queue.size(), str);
	}
	
	public String pop() {
		String str = queue.get(0);
		queue.remove(0);
		return str;
	}
	
	public String peek(int index) {
		return queue.get(index);
	}
	
	public int getSize() {
		return queue.size();
	}
	
	public String toString() {
		return queue.toString();
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.push("First");
		queue.push("Second");
		queue.push("Third");
		System.out.println(queue);
		System.out.println(queue.pop());
		System.out.println(queue);
		

	}
}
