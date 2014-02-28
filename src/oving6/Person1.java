package oving6;

public class Person1 implements Named {
	private String given;
	private String family;
	
	Person1 (String given, String family) {
		setGivenName(given);
		setFamilyName(family);
	}
	@Override
	public void setGivenName(String name) {
		this.given = name;
	}

	@Override
	public String getGivenName() {
		return this.given;
	}

	@Override
	public void setFamilyName(String name) {
		this.family = name;
	}

	@Override
	public String getFamilyName() {
		return this.family;
	}

	@Override
	public void setFullName(String name) {
		this.given = name.substring(0, name.indexOf(" "));
		this.family = name.substring(name.indexOf(" ")+1, name.length());
	}

	@Override
	public String getFullName() {
		return this.given + " " + this.family;
	}

}
