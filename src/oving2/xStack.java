package oving2;

import java.util.ArrayList;
import java.util.Random;

public class xStack {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("First");
		list.add("Second");
		list.add("Third");
		System.out.println(list);
		System.out.println(list.get(0));
		list.remove(0);
		System.out.println(list);
		list.set(0, "TheVeryFirst");
		System.out.println(list);
		System.out.println(list.size());
		Random random = new Random();
		System.out.println(random.nextInt(100));
	}
}
