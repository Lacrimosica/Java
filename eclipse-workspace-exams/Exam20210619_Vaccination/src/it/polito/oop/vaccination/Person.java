package it.polito.oop.vaccination;


public class Person {
	private String fName;
	private String lName;
	private String SSN;
	private int byear;
	public final int YEAR = java.time.LocalDate.now().getYear();
	
	public Person(String fName, String lName, String ssn, int byear) {
	
		this.fName = fName;
		this.lName = lName;
		this.SSN = ssn;
		this.byear = byear;
	}
	
	public String toString() {
		return lName + " , " + fName;
	}
	
	public int getByear() {
		return this.byear;
	}
	
	public int getAge() {
		return YEAR- byear;
	}
	
	public String getSSN() {
		return this.SSN;
	}
}
