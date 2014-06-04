package eksamen2008k;

public enum Country {
	DK (45), SE (46), NO (47);
	
	private final int code;
	
	private Country(int code) {
		this.code = code;
	}
	
	public int getCountryCode(Country c) {
		return c.code;
	}
	
	public static Country getCountryForCode(int countryCode) {
		for (Country c : Country.values()) {
			if (c.code == countryCode) {
				return c;
			}
		}
		return null;
	}
}


