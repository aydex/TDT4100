package eksamen2013;

public class TaxPerson extends TaxEntity {
	
	private static final int PNUM_LENGTH = 11;

	protected TaxPerson(String idnr, String name, double percent) {
		super(idnr, name, percent);
	}

	@Override
	protected boolean checkId(String id) {
		if (id.trim().length() != PNUM_LENGTH) {
			return false;
		} else {
			for (int i = 0; i < PNUM_LENGTH; i++) {
				if (! Character.isDigit(id.charAt(i))) {
					return false;
				}
			}
			return true;
		}
	}

}
