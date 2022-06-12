package clinic;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Doctor extends Patient{

	private int docID;
	private String specialization;
	private List<Patient> assignedPatients;
	
	public Doctor(String first, String last, String ssn, int docID, String specialization) {
		super(first, last, ssn);
		this.docID = docID;
		this.specialization = specialization;
		this.assignedPatients = new LinkedList<Patient>();
	}
	
	public boolean assignPatient(Patient p) {
		if (!assignedPatients.contains(p)) {
			assignedPatients.add(p);
			return true;
		} else {
			return false;
		}
	}
	
	public int getID() {
		return this.docID;
	}
	public String getSpecialization() {
		return this.specialization;
	}
	
	public Collection<String> getPatients() {
		Collection<String> cp = this.assignedPatients.stream().map(x -> x.getSSN()).collect(Collectors.toList());
		return cp; 
	}
	
	public Integer getPatientNum() {
		return this.assignedPatients.size();
	}
	
	@Override
	public String toString(){
		return String.format("%s %s (%s) [%s]: %s", getLName(), getFName(), getSSN(), docID, specialization);
	}
	
	
}
