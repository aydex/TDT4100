package Oving1;

public class Account {
	
	public double balance;
	public double interestRate;
	
	public void deposit(double in) {
		this.balance += in;
	}
	
	public void addInterest() {
		deposit(this.balance * this.interestRate);
	}
	
	public String toString() {
		return "Your balance is: " + balance;
	}
	
	public static void main(String[] args) {
		Account konto = new Account();
		konto.interestRate = 1.25;
		konto.deposit(100);
		konto.addInterest();
		System.out.println(konto);
	}
}
