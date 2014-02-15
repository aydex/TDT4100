package oving5;

public class Partner {
	
	private String name;
	private Partner partner;
	
	public Partner(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Partner getPartner() {
		return partner;
	}
	
	public void setPartner(Partner partner) {
		if (partner != null) {
			if (partner.partner != null) {
				partner.partner.partner = null;				
				partner.partner = null;
				this.partner.partner = null;
				this.partner = partner;
				partner.partner = this;				
			} else {
				partner.partner = null;
				this.partner = partner;
				partner.partner = this;				
			}
		} else {
			this.partner.partner = null;
			this.partner = null;
		}
	}
	
	public String toString() {
		if (partner == null) {
			return getName() + " does not have a partner";
		} else {
			return getName() + " is a partner with " + partner.getName();			
		}
	}
	
	public static void main(String[] args) {
		Partner p1 = new Partner("1");
		Partner p2 = new Partner("2");
		Partner p3 = new Partner("3");
		Partner p4 = new Partner("4");
		p1.setPartner(p2);
		p3.setPartner(p4);
		p1.setPartner(p4);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
	}
}
