package clinic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Doctor extends Person{
	private int badgeID;
	private String Specialization;
	private List<Person> assignedPatients;
	
	public Doctor(String lastName, String firstName, String ssn, int badgeID, String specialization) {
		super(lastName, firstName, ssn);
		this.badgeID = badgeID;
		Specialization = specialization;
		assignedPatients = new ArrayList<Person>();
	}

	public int getBadgeID() {
		return badgeID;
	}

	public String getSpecialization() {
		return Specialization;
	}
	
	public Integer getPatientNum() {
		return this.assignedPatients.size();
	}
	
	@Override
	public String toString(){
		return String.format("%s %s (%s) [%s]: %s", getLastName(), getFirstName(), getSSN(), getBadgeID(), getSpecialization());
	}
	
	public Collection<String> getPatients() {
		Collection<String> cp = this.assignedPatients.stream().map(x -> x.getSSN()).collect(Collectors.toList());
		return cp; 
	}
	
	public void assignPatient(Person p) {
		assignedPatients.add(p);
	}
	
	
}
