package oving8;

import java.util.Scanner;

public class CalculatorProgram {
	
	SimpleCalculator calc;
	Scanner sc = new Scanner(System.in);
	
	private void init() {
		System.out.println("Do you want a \n (1)Simple Calculator \nor a\n (2)RPN Calculator?");
		int input = sc.nextInt();
		if (input == 1) {
			System.out.println("Simple Calculator activated");
			calc = new SimpleCalculator();
		} else if (input == 2) {
			System.out.println("RPN Calculator activated");
			calc = new RPNCalculator();
		}
	}
	
	private void run() {
		while (sc.hasNext()) {
			if (sc.hasNextDouble()) {
				calc.takeInputNumber(sc.nextDouble());
			} else {
				calc.takeInputOperator(sc.next().charAt(0));
			}
		}
	}
	
	public static void main(String[] args) {
		CalculatorProgram cp = new CalculatorProgram();
		cp.init();
		cp.run();
	}
}
