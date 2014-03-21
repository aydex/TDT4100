package oving8;

public class SimpleCalculator {
	
	protected double leftOperand;
	protected double rightOperand;
	protected char operator;
	private boolean lastInputOperator = false;
	protected boolean hasOutput = false;
	
	protected void setLeftOperand(double operand) {
		leftOperand = operand;
	}
	
	protected void setRightOperand(double operand) {
		rightOperand = operand;
	}
	
	protected void setOperator(char operator) {
		if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
			lastInputOperator = true;
			this.operator = operator;			
		}
	}
	
	protected double getResult() {
		switch (operator) {
		case '+':
			return leftOperand + rightOperand;
		case '-':
			return leftOperand - rightOperand;
		case '*':
			return leftOperand * rightOperand;
		case '/':
			return leftOperand / rightOperand;
		default:
			return 0;
		}
	}
	
	public void takeInputNumber(double number) {
		System.out.println("Getting input " + number);
		if (lastInputOperator) {
			setRightOperand(number);
			hasOutput = true;
			getOutput();
		} else {
			setLeftOperand(number);
		}
	}

	public void takeInputOperator(char operator) {
		System.out.println("Getting operator " + operator);
		setOperator(operator);
	}
	
	public boolean hasOutput() {
		return hasOutput;
	}
	
	public double getOutput() {
		if (hasOutput()) {
			setLeftOperand(getResult());
			lastInputOperator = false;
			hasOutput = false;
			System.out.println(leftOperand);
			return leftOperand;
		} else {
			System.out.println(Double.NaN);
			return Double.NaN;
		}
	}
}
