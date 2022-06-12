package clinic;

public class Patient {
	private String first;
	private String last;
	private String ssn;
	private Doctor doctor = null;
	
	public Patient(String first, String last, String ssn) {
		this.first = first;
		this.last = last;
		this.ssn = ssn;
	}
	
	public boolean assignDoctor(Doctor d) {
		if (doctor == null) {
			doctor = d;
			d.assignPatient(this);
			return true;
		} else {
			return false;
		}
	}
	public Doctor getDoctor() {
		return this.doctor;
	}
	
	@Override 
	public String toString() {
		return String.format("%s %s (%s)", last, first, ssn);
	}
	
	public String getFName() {
		return first;
	}
	public String getLName() {
		return last;
	}
	public String getSSN() {
		return ssn;
	}
	
}
