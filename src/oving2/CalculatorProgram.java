package oving2;

public class CalculatorProgram {
	
	Calculator calc;
	
	public void init() {
		calc = new Calculator();
	}
	
	public void run() {
		calc.setFirstOperand(1.0);
		calc.setSecondOperand(2.0);
		calc.setOperator('+');
		System.out.println(calc);
	}
	
	public static void main(String[] args) {
		CalculatorProgram c = new CalculatorProgram();
		c.init();
		c.run();
	}

}
