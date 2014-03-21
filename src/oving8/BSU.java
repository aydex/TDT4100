package oving8;

public class BSU extends SavingsAccount {
	
	private double yearlyDeposit;
	private double yearlyLimit;

	BSU (double interestRate, double yearly) {
		super(interestRate);
		this.yearlyLimit = yearly;
	}
	
	@Override
	public void deposit(double amount) {
		if (yearlyDeposit + amount > yearlyLimit) {
			throw new IllegalStateException("Amount exceeds yearly amount");
		} else {
			super.deposit(amount);
			yearlyDeposit += amount;
		}
	}
	
	@Override
	public void withdraw(double amount) {
		if (amount > yearlyDeposit) {
			throw new IllegalStateException("Amount exceeds this years deposit");
		} else {
			super.withdraw(amount);
			yearlyDeposit -= amount;
		}
	}
	
	@Override
	public void endYearUpdate() {
		balance += balance*interestRate;
		yearlyDeposit = 0;
	}
	
	public double getTaxDeduction() {
		return yearlyDeposit*0.2;
	}
	
	public static void main(String[] args) {
		BSU bsu = new BSU(0.5, 25000);
		bsu.deposit(10000);
		bsu.deposit(20000);
		bsu.endYearUpdate();
		bsu.deposit(20000);
	}

}
