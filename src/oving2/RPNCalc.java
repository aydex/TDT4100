package oving2;

import java.util.ArrayList;

public class RPNCalc {
	ArrayList<Double> rpnList;
	
	public RPNCalc() {
		rpnList = new ArrayList<Double>();		
	}
	
	public void push(double d) {
		this.rpnList.add(0, d);
	}
	
	public double pop() {
		if (this.rpnList.size() > 0) {
			Double retval = this.rpnList.get(0);
			this.rpnList.remove(0);
			return retval;
		} else {
			return Double.NaN;
		}
	}
	
	public double peek(int index) {
		if (index < this.getSize() && index >= 0) {
			return this.rpnList.get(index);			
		} else {
			return Double.NaN;
		}
	}
	
	public int getSize() {
		return this.rpnList.size();
	}
	
	public void performOperation(char c) {
		if (this.getSize() >= 2) {
			if (c == '+') {
				this.push(this.pop() + this.pop());
			} else if (c == '-') {
				this.push(- this.pop() + this.pop());
			} else if (c == '/') {
				if (this.peek(1) != 0) {					
					Double newVal = this.peek(1) / this.peek(0);
					this.pop();
					this.pop();
					this.push(newVal);
				} else {
					throw new IllegalArgumentException("You can't divide by zero");
				}
			} else if (c == '*') {
				this.push(this.pop()*this.pop());
			} else if (c == '~') {
				Double val1 = this.pop();
				Double val2 = this.pop();
				this.push(val1);
				this.push(val2);
			}  else {
				throw new IllegalArgumentException("Not a valid operator");
			}
		} else if (c == '|' && this.getSize() >= 1) {
				this.push(Math.abs(this.pop()));
		} else {				
			throw new IllegalArgumentException("You need to input more numbers first");
		}
	}
	
	public void performOperation(String str) {
		if (str == "pi" || str == "\u03C0") {
			this.push(Math.PI);
		} else {
			throw new IllegalArgumentException("Not a valid operator");
		}
	}
	
	public String toString() {
		String returnString = "";
		for (Double d : this.rpnList)
		{
		    returnString += d + "\t";
		}
		return returnString;
	}
}
