package clinic;

public class Person {
	private String firstName;
	private String lastName;
	private String SSN;
	private Doctor doctor;
	
	public Person(String firstName, String lastName, String ssn){
		this.firstName = firstName;
		this.lastName = lastName;
		this.SSN = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSSN() {
		return SSN;
	}
	
	public void assignDoctor(Doctor d) {
		this.doctor = d;
	}
	
	public Doctor getDoctor() {
		return this.doctor;
	}
	@Override 
	public String toString() {
		return String.format("%s %s (%s)", lastName, firstName, SSN);
	}
	
	
}
