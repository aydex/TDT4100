package oving5;

import java.util.ArrayList;

public class Person {
	
	private String name;
	private char gender;
	private Person mother;
	private Person father;
	private ArrayList<Person> children = new ArrayList<Person>();
	
	public Person(String name, char gender) {
		this.name = name;
		if (gender == 'F' || gender == 'M') {
			this.gender = gender;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	public Person getMother() {
		return this.mother;
	}
	
	public Person getFather() {
		return this.father;
	}
	
	public int getChildCount() {
		return this.children.size();
	}
	
	public Person getChild(int n) {
		if (n < children.size() && n >= 0) {
			return children.get(n);
		} else {
			throw new IllegalArgumentException("Index out of range");
		}
	}
	
	public void addChild(Person child) {
		if (this.gender == 'F') {
			child.mother = this;
		} else {
			child.father = this;
		}
		this.children.add(child);
	}
	
	public void removeChild(Person child) {
		if (child.mother == this) {
			child.mother = null;
		} else if (child.father == this) {
			child.father = null;
		}
		children.remove(child);
	}
	
	public void setMother(Person mother) {
		if (mother == null) {
			this.mother = null;
		} else {			
			if (mother.gender == 'M' || mother.name == this.name) {
				throw new IllegalArgumentException(mother.name + " can't bet the mother");
			} else {
				if (this.mother != null) {
					this.mother.removeChild(this);
				}
				this.mother = mother;
				mother.addChild(this);			
			}
		}
	}
	
	public void setFather(Person father) {
		if (father == null) {
			this.father = null;
		} else {
			if (father.gender == 'F' || father.name == this.name) {
				throw new IllegalArgumentException(father.name + " can't be the father");
			}
			if (this.father != null) {
				this.father.removeChild(this);
			}
			this.father = father;
			father.addChild(this);			
		}
	}
	
	public String toString() {
		if (this.mother == null && this.father == null) {
			return this.name + " har " + this.getChildCount() + " barn. " + "Faren og moren er ikke registrert";						
		} else if (this.mother == null) {
			return this.name + " har " + this.getChildCount() + " barn. " + "Faren er " + this.father.name + " og moren er ikke registrert";						
		} else if (this.father == null) {
			return this.name + " har " + this.getChildCount() + " barn. " + "Faren er ikke registrert og moren er: " + this.mother.getName();			
		} else {			
			return this.name + " har " + this.getChildCount() + " barn. " + "Faren er " + this.father.name + " og moren er " + this.mother.name;									
		}
	}
	
	public static void main(String[] args) {
		Person geir = new Person("Geir", 'M');
		Person inger = new Person("Inger Johanne", 'F');
		Person adrian= new Person("Adrian", 'M');
		Person iben = new Person("Iben", 'F');
		inger.addChild(adrian);
		geir.addChild(adrian);
		System.out.println(inger);
		System.out.println(geir);
		System.out.println(adrian);
		System.out.println("_");
		adrian.setMother(inger);
		adrian.setFather(geir);
		System.out.println(inger);
		System.out.println(geir);
		System.out.println(adrian);
		System.out.println("_");
		inger.removeChild(adrian);
		geir.removeChild(adrian);
		System.out.println(inger);
		System.out.println(geir);
		System.out.println(adrian);
		System.out.println("_");
		adrian.setMother(null);
		adrian.setFather(null);
		System.out.println(inger);
		System.out.println(geir);
		System.out.println(adrian);
		System.out.println("_");
		
		inger.addChild(adrian);
		geir.addChild(adrian);
		inger.addChild(iben);
		geir.addChild(iben);
		System.out.println(inger);
		System.out.println(geir);
		System.out.println(adrian);
		System.out.println(iben);
	}
}
