package eksamen2010;

public class Date {
	
	private int day;
	private int month;
	private int year;
	
	public Date(int day, int month, int year) {
		check(day, month, year);
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	private void check(int day, int month, int year) {
		if (day < 1 || day > numberOfDays(month, year)) {
			throw new IllegalArgumentException("Illegal day: " + day);
		}
		if (month < 1 || month > 12) {
			throw new IllegalArgumentException("Illegal month: " + month);
		}
	}
	
	private int numberOfDays(int month, int year) {
		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
		case 4: case 6: case 11: return 30;
		case 2: return(isLeapYear(year) ? 29 : 28);
		}
		return -1;
	}
	
	private boolean isLeapYear(int year) {
		return true;
	}
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		check(day, month, year);
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		check(day, month, year);
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		check(day, month, year);
		this.year = year;
	}
	
	public void nextDay() {
		day++;
		if (day > numberOfDays(month, year)) {
			day = 1;
			month++;
			if (month > 12) {
				month = 1;
				year++;
			}
		}
	}
	
	public void prevDay() {
		day--;
		if (day < 1) {
			month--;
			if (month < 1) {
				month = 12;
				year--;
			}
			day = numberOfDays(month, year);
		}
	}
}
