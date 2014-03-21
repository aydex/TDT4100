package oving8;

import java.util.Stack;

public class RPNCalculator extends SimpleCalculator {
	
	private Stack<Double> stack = new Stack<Double>();
	private double output;

	@Override
	public void takeInputNumber(double number) {
		System.out.println("Getting input " + number);
		super.hasOutput = false;
		stack.push(number);
	}
	
	@Override
	public void takeInputOperator(char operator) {
		System.out.println("Getting operator " + operator);
		if (stack.size() >= 2) {
			super.setRightOperand(stack.pop());
			super.setLeftOperand(stack.pop());
			super.setOperator(operator);
			super.hasOutput = true;
			stack.push(getResult());
			output = stack.peek();
			getOutput();
		}
	}
	
	@Override
	public boolean hasOutput() {
		return super.hasOutput;
	}
	
	@Override
	public double getOutput() {
		if (hasOutput()) {
			System.out.println(output);
			return output;			
		} else {
			System.out.println(Double.NaN);
			return Double.NaN;
		}
	}
}
