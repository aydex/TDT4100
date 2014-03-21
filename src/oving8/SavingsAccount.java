package oving8;

public class SavingsAccount implements Account {
	
	protected double balance;
	protected double interestRate;
	
	SavingsAccount(double interestRate) {
		this.interestRate = interestRate;
		this.balance = 0;
	}
	
	public void endYearUpdate() {
		balance += balance*interestRate;
	}

	@Override
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
		} else {
			throw new IllegalArgumentException("Amount must be positive");
		}
	}

	@Override
	public void withdraw(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Amount must be positive");
		} else if (this.balance-amount < 0) {
			throw new IllegalStateException("Insufficient balance");
		} else {
			this.balance -= amount;
		}
	}

	@Override
	public double getBalance() {
		return this.balance;
	}

}
