package eksamen2013;

public abstract class TaxEntity {

	final private String idnr;
	private String name;
	private long income;
	private long deduction;
	private long fortune;
	private long debt;
	private double percent;
	
	protected TaxEntity(String idnr, String name, double percent) {
		if (checkId(idnr)) {
			this.idnr = idnr;
		} else {
			throw new IllegalArgumentException("Illegal ID: " + idnr);
		}
		setName(name);
		setPercent(percent);
	}
	
	private boolean checkPositive(long number) {
		return number >= 0;
	}
	
	private boolean checkPercent(double percent) {
		return percent <= 100 && percent >= 0;
	}
	
	private boolean checkName(String name) {
		int letters = 0;
		for (char c : name.toLowerCase().toCharArray()) {
			if ("abcdefghijklmnopqrstuvwxyzæøå".contains("" + c)) {
				letters++;
			}
		}
		return letters >= 3;
	}
	
	protected abstract boolean checkId(String id);
	
	public void setName(String name) {
		if (checkName(name)) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("Illegal name: " + name);
		}
	}
	
	public void setPercent(double percent) {
		if (checkPercent(percent)) {
			this.percent = percent;
		} else {
			throw new IllegalArgumentException("Illegal percentage: " + percent);
		}
	}
	
	public double getTax() {
		long tax = 0;
		if (fortune > debt) {
			tax+=(fortune-debt)*0.01;						
		}
		if (income > deduction) {
			tax += ((income-deduction)*percent/100);						
		}
		return tax;
	}

	public String getId() {
		return idnr;
	}

	public String getName() {
		return this.name;
	}
}
