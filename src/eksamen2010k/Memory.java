package eksamen2010k;

import java.util.ArrayList;
import java.util.Scanner;

public class Memory {
	
	private ArrayList<Integer> numbers = new ArrayList<Integer>();
	
	public int nextNumber() {
		int next = (int)(Math.random()*10);
		numbers.add(next);
		return next;
	}
	
	public int digitValue(char digit) {
		return digit - '0';
	}
	
	public boolean compareNumbers(String digits) {
		if (digits.length() != this.numbers.size()) {
			return false;
		}
		for (int i = 0; i < digits.length(); i++) {
			if (digitValue(digits.charAt(i)) != this.numbers.get(i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Memory memory = new Memory();
		Scanner sc = new Scanner(System.in);
		while (true) {
			int next = memory.nextNumber();
			System.out.println("Tall " + memory.numbers.size() + ": " + next);
			String line = sc.nextLine();
			if (line == null) {
				break;
			} else if (memory.compareNumbers(line)) {
				System.out.println("Riktig!");
			} else {
				System.out.println("Feil!");
				break;
			}
		}
		System.out.println("Du klarte " + (memory.numbers.size() -1) + " tall!");
		sc.close();
	}
}
