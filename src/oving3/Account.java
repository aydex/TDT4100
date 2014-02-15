package oving3;

public class Account {
	private Double balance;
	private Double interestRate;
	
	public Account(double start, double interest) {
		if (start >= 0 && interest >= 0) {
			this.balance = start;
			this.interestRate = interest;
		} else {
			throw new IllegalArgumentException("Start value and interest rate must be positive");
		}
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public Double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		if (interestRate >= 0) {
			this.interestRate = interestRate;
		} else {
			throw new IllegalArgumentException("Interest rate cannot be a negative number");
		}
	}
	
	public void deposit(double d) {
		if (d >= 0) {
			this.balance += d;
		} else {
			throw new IllegalArgumentException("Cannot deposit negative number");
		}
	}
	
	public void withdraw(double d) {
		if (d >=0) {
			if (this.balance-d < 0) {
				throw new IllegalStateException("Insufficient Balance");
			} else {
				this.balance -= d;
			}
		} else {
			throw new IllegalArgumentException("Cannot withdraw negative number");
		}
		
	}
}