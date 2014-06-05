package eksamen2013;

import java.util.Collection;
import java.util.HashSet;

public class YearRegister {

	private int year;
	private long max = -1, min = -1, average;
	private Collection<TaxEntity> taxList = new HashSet<TaxEntity>();

	public YearRegister(int year) {
		this.year = year;
	}
	
	public boolean conatinsTaxEntity(String idnr) {
		for (TaxEntity taxEntity : taxList) {
			if (taxEntity.getId().equals(idnr)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean addTaxEntity(TaxEntity p) {
		return taxList.add(p);
	}
	
	public boolean removeTaxEntity(TaxEntity p) {
		return taxList.remove(p);
	}
	
	public Collection<TaxEntity> getTaxEntityInCommune(String name) {
		Collection<TaxEntity> returnList = new HashSet<TaxEntity>();
		for (TaxEntity taxEntity : taxList) {
			if (taxEntity.getName().equals(name)) {
				returnList.add(taxEntity);
			}
		}
		return returnList;
	}
	
	public void makeStatistics() {
		long sumTax = 0;
		for (TaxEntity p : taxList) {
			if (min == -1 || p.getTax() < min) {
				min = (long) p.getTax();
			}
			if (p.getTax() > max) {
				max = (long) p.getTax();
			}
			sumTax += p.getTax();
		}
		if (taxList.size() > 0) {
			average = sumTax/taxList.size();			
		}
	}
	
	public String toString() {
		makeStatistics();
		return "Year Register " + year + taxList.size() + " Tax Entities: \n" + " Max tax is " + max + ", Min tax is " + min + " and Average tax is " + average;
	}
}
