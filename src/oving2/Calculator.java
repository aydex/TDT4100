package oving2;

import java.util.Scanner;

public class Calculator {
	
	public double firstOperand;
	public double secondOperand;
	public char operator;
	
	public Calculator() {
		firstOperand = Double.NaN;
		secondOperand = Double.NaN;
	}

	public void setFirstOperand(double operand) {
		this.firstOperand = operand;
	}
	
	public void setSecondOperand(double operand) {
		this.secondOperand = operand;
	}
	
	public void setOperator(char operator) {
		this.operator = operator;
	}
	
	public double calculateResult() throws IllegalArgumentException {
		if (firstOperand != Double.NaN && secondOperand != Double.NaN) {			
			if (operator == '+') {
				return this.firstOperand + this.secondOperand;
			} else if (operator == '-') {
				return this.firstOperand - this.secondOperand;
			} else if (operator == '*') {
					return this.firstOperand*this.secondOperand;
			} else if (operator == '/') {
				if (this.secondOperand != 0) {
					return this.firstOperand/this.secondOperand;
				} else {
					throw new IllegalArgumentException("You can't divide by zero");					
				}
			} else if (operator == '%') {
				return this.firstOperand%this.secondOperand;
			} else if (operator == '^') {
				return Math.pow(this.firstOperand, this.secondOperand);
			} else {
				throw new IllegalArgumentException(operator + " is not a legal operator");
			}
		} else {
			return Double.NaN;
		}
	}
	
	public void calculateAndSetFirstOperand() {
		this.firstOperand = calculateResult();
	}
	
	public String toString() {
		return String.format("%s %s %s = %s", this.firstOperand,  this.operator, this.secondOperand, this.calculateResult());
	}
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.setFirstOperand(1.0);
		calc.setOperator('+');
		calc.setSecondOperand(2.0);
		System.out.println(calc);
		
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			if (sc.hasNextDouble()) {
				calc.setFirstOperand(sc.nextDouble());
			} else {
				String operator = sc.next();
				calc.setOperator(operator.charAt(0));
				if(sc.hasNextDouble()) {
					calc.setSecondOperand(sc.nextDouble());
					System.out.println(calc);
					calc.calculateAndSetFirstOperand();
				}
			}
		}
		sc.close();
	}

}
