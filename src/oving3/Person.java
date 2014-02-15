package oving3;

import java.util.Calendar;
import java.util.Date;

public class Person {
	private String name;
	private String email;
	private Date birthday;
	private char gender;
	
	Person() {
		this.name = "";
		this.email = null;
		this.gender = '\0';
	}

	public void setName(String name) {
		if (name.indexOf(" ", 0) == name.lastIndexOf(" ") && name.length() >= 4) {
			String firstName = name.substring(0, name.indexOf(" ")-1);
			String lastName = name.substring(name.indexOf(" ")+1, name.length());
			if (firstName.length() >= 2 && lastName.length() >= 2) {
				this.name = name;
			} else {
				throw new IllegalArgumentException("You have to input a name with at least two letters");
			}
			
		} else {
			throw new IllegalArgumentException("You have to input both first name and last name, with one space in between");
		}
	}

	public void setEmail(String email) {
		String emailTest = email.toUpperCase();
		String nameTest = name.toUpperCase();
		if (emailTest.matches("^([0-9a-zA-Z]+[.])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$")) {
			if (emailTest.substring(0, emailTest.indexOf(".")).equals(nameTest.substring(0, nameTest.indexOf(" "))) && 
					emailTest.substring(emailTest.indexOf(".")+1, emailTest.indexOf("@")).equals(nameTest.substring(nameTest.indexOf(" ")+1, nameTest.length()))) {
				this.email = email;
			} else {
				throw new IllegalStateException("Email needs to match the persons name");
			}
		} else {
			throw new IllegalArgumentException("Email needs to be of the form firstname.lastname@domain.countrycode");
		}
	}

	public void setBirthday(Date birthDate) {
		Date present = new Date();
		Calendar date = Calendar.getInstance();
		present = date.getTime();
		if (birthDate.before(present)) {
			this.birthday = birthDate;			
		} else {
			throw new IllegalArgumentException("The date you entered is ");
		}
	}

	public void setGender(char gender) {
		if (gender == 'M' || gender == 'F' || gender == '\0') {
			this.gender = gender;			
		} else {
			throw new IllegalArgumentException("Gender needs to be M, F or \0");
		}
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public char getGender() {
		return this.gender;
	}
	
	public static void main(String[] args) {
		Person person = new Person();
		person.setName("Ola Nordmann");
		System.out.println(person.getName());
		person.setEmail("ola.nordmann@ntnu.no");
		System.out.println(person.getEmail());
	}
	
}
