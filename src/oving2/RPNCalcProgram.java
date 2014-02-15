package oving2;

import java.util.Scanner;

public class RPNCalcProgram {
	private RPNCalc rpnCalc;
	
	void init() {
		rpnCalc = new RPNCalc();
	}
	
	void run() {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			if (sc.hasNextDouble()) {
				rpnCalc.push(sc.nextDouble());
				if (sc.hasNextDouble()) {
					rpnCalc.push(sc.nextDouble());
				} else if (sc.hasNextDouble() == false) {
					rpnCalc.performOperation(sc.next().charAt(0));					
				}
			} else {
				rpnCalc.performOperation(sc.next().charAt(0));
			}
			System.out.println(rpnCalc);
		}
		sc.close();
	}
	
	public static void main(String[] args) {
		RPNCalcProgram rpnCalcProgram = new RPNCalcProgram();
		rpnCalcProgram.init();
		rpnCalcProgram.run();
	}
}