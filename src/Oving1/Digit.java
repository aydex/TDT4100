package Oving1;

public class Digit {
	
	public int numSys;
	public int digit;
	public String str;
	
	
	public Digit(int i) {
		this.numSys = i;
		this.digit = 0;
	}
	
	public int getValue() {
		return this.digit;
	}
	
	public boolean increment() {
		this.digit++;
		if (this.digit == this.numSys) {
			this.digit = 0;
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		this.str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return "" + str.charAt(this.digit);
	}

	public static void main(String[] args) {
		/*
		Digit d = new Digit(15);
		System.out.println(d.getValue());
		d.increment();
		System.out.println(d.getValue());
		d.increment();
		d.increment();
		d.increment();
		d.increment();
		d.increment();
		d.increment();
		d.increment();
		d.increment();
		d.increment();
		d.increment();
		d.increment();
		System.out.println(d);
		*/
	}
}
