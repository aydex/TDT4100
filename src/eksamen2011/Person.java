package eksamen2011;

public class Person {

	private Date birthdate;
	private final char gender;
	private int[] personNumber = new int[10];
	private static final int[] f = {3, 7, 6, 1, 8, 9, 4, 5, 2};
	private static final int[] g = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};
	
	public Person(char gender) {
		if (gender == 'm' || gender == 'f') {
			this.gender = gender;			
		} else {
			throw new IllegalArgumentException("Illegal gender: " + gender);
		}
		int d1, d2, m1, m2, y1, y2, k1 = 0, k2 = 0;
		d1 = birthdate.getDay()/10;
		d2 = birthdate.getDay()%d1;
		m1 = birthdate.getMonth()/10;
		m2 = birthdate.getMonth()%m1;
		y1 = birthdate.getYear()/10;
		y2 = birthdate.getYear()%y1;
		personNumber[0] = d1;
		personNumber[1] = d2;
		personNumber[2] = m1;
		personNumber[3] = m2;
		personNumber[4] = y1;
		personNumber[5] = y2;
		personNumber[6] = (int) (Math.random()*10);
		personNumber[7] = (int) (Math.random()*10);
		if(gender == 'm') {
			personNumber[8] = (int) (Math.random()*20-1);
		} else {
			personNumber[8] = (int) (Math.random()*20);
		}
		
		for (int i = 0; i < f.length; i++) {
			k1 += personNumber[i]*f[i];
			k2 += personNumber[i]*g[i];
		}
		k2 += k1*g[9];
		k1 = 11-(k1%11);
		k2 = 11-(k2%11);
		personNumber[9] = k1;
		personNumber[10] = k2;
	}
	
	public void setPersonNumber(int[] personNumber) {
		if (personNumber.length != 11) {
			throw new IllegalArgumentException("Illegal person number: " + personNumber);
		}
		if (gender == 'm' && personNumber[8]%2 == 0) {
			throw new IllegalArgumentException("Illegal person number: " + personNumber);			
		} else if (gender == 'f' && personNumber[8]%2 != 0) {
			throw new IllegalArgumentException("Illegal person number: " + personNumber);						
		}
		
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public char getSex() {
		return gender;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	
}
