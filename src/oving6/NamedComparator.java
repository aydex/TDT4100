package oving6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NamedComparator implements Comparator<Named> {

	@Override
	public int compare(Named named1, Named named2) {
		switch (named1.getFamilyName().compareTo(named2.getFamilyName())) {
		case 0:
			return (named1.getGivenName().compareTo(named2.getGivenName()));

		default:
			return named1.getFamilyName().compareTo(named2.getFamilyName());
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Named> nameList = new ArrayList<Named>();
		nameList.add(new Person2("Odd odd"));
		nameList.add(new Person2("Jens jens"));
		nameList.add(new Person2("Adrian Bob"));
		nameList.add(new Person2("Jens Bob"));
		for (int i = 0; i < nameList.size(); i++) {
			System.out.println(nameList.get(i).getFullName());
		}
		Collections.sort(nameList, new NamedComparator());
		for (int i = 0; i < nameList.size(); i++) {
			System.out.println(nameList.get(i).getFullName());
		}
	}
}
