package oving6;

public class Person2 implements Named {
	
	private String fullname;
	
	Person2 (String name) {
		setFullName(name);
	}
	@Override
	public void setGivenName(String name) {
		if (fullname.contains(" ")) {
			fullname = name + " " + fullname.substring(fullname.indexOf(" ")+1, fullname.length());			
		} else {
			fullname = name + " " + fullname;
		}
	}

	@Override
	public String getGivenName() {
		if (fullname.contains(" ")) {
			return fullname.substring(0, fullname.indexOf(" "));			
		} else {
			return fullname;
		}
	}

	@Override
	public void setFamilyName(String name) {
		if (fullname.contains(" ")) {
			fullname = fullname.substring(0, fullname.indexOf(" ")) + name;			
		} else {
			fullname += " " + name;
		}
	}

	@Override
	public String getFamilyName() {
		return fullname.substring(fullname.indexOf(" ")+1, fullname.length());
	}

	@Override
	public void setFullName(String name) {
		this.fullname = name;
	}

	@Override
	public String getFullName() {
		return this.fullname;
	}
}
