package eksamen2008k;

import javax.crypto.IllegalBlockSizeException;

public class Odd implements PriceListener {

	@Override
	public void notifyPrice(MobileThing newMobile, int newPrice) {
		try {
			throw new IllegalBlockSizeException();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
