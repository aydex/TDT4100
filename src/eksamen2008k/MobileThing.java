package eksamen2008k;

public abstract class MobileThing implements Comparable<MobileThing> {
	
	private final String brand, model;
	private Country country;
	protected final static String NUMBER_KEYS = "123457890";
	protected final static String QWERTY_KEYS = "QWERTYUIOPASDFGHJKLZXCVBNM";
	
	protected MobileThing(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public void setCountry(Country c) {
		this.country = c;
	}
	
	public Country getCountry() {
		return this.country;
	}
	
	public boolean isKeyboardOpen() {
		return true;
	}
	
	public static boolean sendSMS(Country country, String number, String text) {
		System.out.println(country + number + text);
		return true;
		}
	
	public int sendMessage(String number, String text) throws Exception {
		Country country;
		int smsCount = 0;
		if (number.charAt(0) == '+') {
			if (Integer.parseInt(number.substring(1, 2)) == this.country.getCountryCode(this.country)) {
				country = this.country;
			} else {
				country = Country.getCountryForCode(Integer.parseInt(number.substring(1,2)));
			}
		} else {
			country = this.country;
		}
		for (int i = 0; i < text.length(); i+=128) {
			if((text.length() - i) < 128) {
				if(!sendSMS(country, number.substring(number.length()-8), text.substring(i))) {
					throw new Exception("Feil! SMS ikke sendt");
				};
			} else {
				if(!sendSMS(country, number.substring(number.length()-8), text.substring(i, i+128))) {
					throw new Exception("Feil! SMS ikke sendt");
				};				
			}
			smsCount++;
		}
		return smsCount;
	}
	
	public abstract String getAvailableKeys();
	
	public boolean isKeyAvailable(char c) {
		return getAvailableKeys().indexOf(c) >= 0;
	}
	
	public static void main(String[] args) throws Exception{
		MobileThing mb = new MobilePhone("Sony", "Xperia");
		mb.setCountry(Country.DK);
		System.out.println(mb.getCountry());
		System.out.println(mb.sendMessage("+4798401811", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum rutrum, risus consequat mattis fermentum, magna lectus lobortis justo, ut condimentum augue odio id lectus. Phasellus sodales eros quis placerat venenatis. Nam placerat dictum urna, quis placerat felis dictum eu. Quisque eu arcu ante. Sed luctus lectus erat, quis placerat erat scelerisque quis. Quisque purus nunc, sagittis eget orci sit amet, porta commodo justo. Etiam varius varius elit nec auctor. Nulla facilisi. Aliquam vel pellentesque nisl. Etiam tincidunt volutpat euismod. Maecenas malesuada, lectus at vehicula lobortis, sem nisl euismod dolor, non semper elit ligula sit amet sapien. Quisque quis ultricies neque."));
	}

	public int getMemory() {
		// TODO Auto-generated method stub
		return 0;
	}
}
