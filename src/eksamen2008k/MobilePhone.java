package eksamen2008k;

public class MobilePhone extends MobileThing {
	
	protected MobilePhone(String brand, String model) {
		super(brand, model);
	}
	
	@Override
	public String getAvailableKeys() {
		return (isKeyboardOpen() ? NUMBER_KEYS : null);
	}

	@Override
	public int compareTo(MobileThing o) {
		if (this.getMemory() == o.getMemory()) {
			return 0;
		} else if(this.getMemory() < o.getMemory()) {
			return -1;
		} else {
			return 1;
		}
	}
}
