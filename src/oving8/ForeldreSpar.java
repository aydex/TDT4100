package oving8;

public class ForeldreSpar extends SavingsAccount {
	
	private int withdrawLimit;
	private int withdraws;

	ForeldreSpar(double interestRate, int withdrawLimit) {
		super(interestRate);
		this.withdrawLimit = withdrawLimit;
		withdraws = 0;
	}
	
	public int getRemainingWithdrawals() {
		return withdrawLimit-withdraws;
	}
	
	@Override
	public void deposit(double amount) {
		super.deposit(amount);
	}
	
	@Override
	public void withdraw(double amount) {
		if (withdraws >= withdrawLimit) {
			throw new IllegalStateException("No more withdraws on this account");
		} else {
			super.withdraw(amount);
			withdraws++;
		}
	}
	
	@Override
	public void endYearUpdate() {
		balance += balance*interestRate;
		withdraws = 0;
	}
	
	public static void main(String[] args) {
		ForeldreSpar fs = new ForeldreSpar(0.04, 3);
		fs.deposit(10000);
		System.out.println(fs.getRemainingWithdrawals());
		fs.withdraw(1000);
		System.out.println(fs.getRemainingWithdrawals());
		fs.withdraw(1000);
		System.out.println(fs.getRemainingWithdrawals());
		fs.withdraw(1000);
		System.out.println(fs.getRemainingWithdrawals());
		fs.withdraw(1000);
		System.out.println(fs.getRemainingWithdrawals());
		fs.endYearUpdate();
	}
}
