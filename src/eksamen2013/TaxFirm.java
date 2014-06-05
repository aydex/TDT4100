package eksamen2013;

public class TaxFirm extends TaxEntity {
	
	private static final int ORGNUM_LENGTH = 9;

	protected TaxFirm(String idnr, String name, double percent) {
		super(idnr, name, percent);
	}

	@Override
	protected boolean checkId(String id) {
		if (id.trim().length() == ORGNUM_LENGTH && (id.charAt(0) == '8' || id.charAt(0) == '9')) {
			for (int i = 0; i < ORGNUM_LENGTH; i++) {
				if (!Character.isDigit(id.charAt(i))) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

}
