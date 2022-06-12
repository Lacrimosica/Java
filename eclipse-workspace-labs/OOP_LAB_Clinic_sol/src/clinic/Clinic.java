package clinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;




/**
 * Represents a clinic with patients and doctors.
 * 
 */
public class Clinic {

	
	private Map<String, Patient> patients = new HashMap<String, Patient>();
	private Map<Integer, Doctor> doctors = new HashMap<Integer, Doctor>();
	/**
	 * Add a new clinic patient.
	 * 
	 * @param first first name of the patient
	 * @param last last name of the patient
	 * @param ssn SSN number of the patient
	 */
	public void addPatient(String first, String last, String ssn) {
		// TODO Complete method
		patients.put(ssn, new Patient(first, last, ssn));
	}
	


	/**
	 * Retrieves a patient information
	 * 
	 * @param ssn SSN of the patient
	 * @return the object representing the patient
	 * @throws NoSuchPatient in case of no patient with matching SSN
	 */
	public String getPatient(String ssn) throws NoSuchPatient {
		// TODO Complete method
		if (!patients.containsKey(ssn)) {
			throw new NoSuchPatient();
		}
		return patients.get(ssn).toString();
	}

	/**
	 * Add a new doctor working at the clinic
	 * 
	 * @param first first name of the doctor
	 * @param last last name of the doctor
	 * @param ssn SSN number of the doctor
	 * @param docID unique ID of the doctor
	 * @param specialization doctor's specialization
	 */
	public void addDoctor(String first, String last, String ssn, int docID, String specialization) {
		// TODO Complete method
		Doctor d = new Doctor(first, last, ssn, docID, specialization);
		doctors.put(docID, d);
		Patient p = d;
		patients.put(ssn, p);
	}

	/**
	 * Retrieves information about a doctor
	 * 
	 * @param docID ID of the doctor
	 * @return object with information about the doctor
	 * @throws NoSuchDoctor in case no doctor exists with a matching ID
	 */
	public String getDoctor(int docID) throws NoSuchDoctor {
		// TODO Complete method
		if (!doctors.containsKey(docID)) {
			throw new NoSuchDoctor();
		}
		return doctors.get(docID).toString();
	}
	
	/**
	 * Assign a given doctor to a patient
	 * 
	 * @param ssn SSN of the patient
	 * @param docID ID of the doctor
	 * @throws NoSuchPatient in case of not patient with matching SSN
	 * @throws NoSuchDoctor in case no doctor exists with a matching ID
	 */
	public void assignPatientToDoctor(String ssn, int docID) throws NoSuchPatient, NoSuchDoctor {
		Patient p = patients.get(ssn);
		Doctor d = doctors.get(docID);
		
		if (d == null) {
			throw new NoSuchDoctor();
		}
		if (p == null) {
			throw new NoSuchPatient();
		}
		
		d.assignPatient(p);
		p.assignDoctor(d);

	}
	
	/**
	 * Retrieves the id of the doctor assigned to a given patient.
	 * 
	 * @param ssn SSN of the patient
	 * @return id of the doctor
	 * @throws NoSuchPatient in case of not patient with matching SSN
	 * @throws NoSuchDoctor in case no doctor has been assigned to the patient
	 */
	public int getAssignedDoctor(String ssn) throws NoSuchPatient, NoSuchDoctor {
		// TODO Complete method
		Patient p = patients.get(ssn);
		if (p == null) {
			throw new NoSuchPatient();
		}
		Doctor d = p.getDoctor();
		
		if (d == null) {
			throw new NoSuchDoctor();
		}
		return d.getID();
	}
	
	/**
	 * Retrieves the patients assigned to a doctor
	 * 
	 * @param id ID of the doctor
	 * @return collection of patient SSNs
	 * @throws NoSuchDoctor in case the {@code id} does not match any doctor 
	 */
	public Collection<String> getAssignedPatients(int id) throws NoSuchDoctor {
		// TODO Complete method
		Doctor d = doctors.get(id);
		if (d == null) {
			throw new NoSuchDoctor();
		}
		return d.getPatients();
	}


	/**
	 * Loads data about doctors and patients from the given stream.
	 * <p>
	 * The text file is organized by rows, each row contains info about
	 * either a patient or a doctor.</p>
	 * <p>
	 * Rows containing a patient's info begin with letter {@code "P"} followed by first name,
	 * last name, and SSN. Rows containing doctor's info start with letter {@code "M"},
	 * followed by badge ID, first name, last name, SSN, and specialization.<br>
	 * The elements on a line are separated by the {@code ';'} character possibly
	 * surrounded by spaces that should be ignored.</p>
	 * <p>
	 * In case of error in the data present on a given row, the method should be able
	 * to ignore the row and skip to the next one.<br>

	 * 
	 * @param readed linked to the file to be read
	 * @throws IOException in case of IO error
	 */
	public void loadData(Reader reader) throws IOException {
		// TODO Complete method
		try (BufferedReader bf = new BufferedReader(reader)) {
			List<String> lines = bf.lines().collect(Collectors.toList());

			lines.stream().forEach(x -> {
				try {
					x = x.replaceAll("\\s+", "");
					String[] elem = x.split(";");
					if (elem[0].equals("P")){
						addPatient(elem[1], elem[2], elem[3]);
					}
					else if (elem[0].equals("M")) {
						addDoctor(elem[2], elem[3], elem[4], Integer.parseInt(elem[1]), elem[5]);
					} 
				} catch (ArrayIndexOutOfBoundsException e) {
					System.err.println("Missing elements on the line");
				} catch (NumberFormatException e) {
					System.err.println("Cannot parse integer value");
				}
			});
		}
	}

	/**
	 * Retrieves the collection of doctors that have no patient at all.
	 * The doctors are returned sorted in alphabetical order
	 * 
	 * @return the collection of doctors' ids
	 */
	public Collection<Integer> idleDoctors(){
		// TODO Complete method
		Collection<Integer> cd = doctors.values().stream()
				.filter(x -> x.getPatients().size()==0)
				//.sorted((d1,d2) -> d1.getFName().compareTo(d2.getFName()))
				//.sorted((d1,d2) -> d1.getLName().compareTo(d2.getLName()))
				.sorted(Comparator.comparing(Doctor::getLName).thenComparing(Doctor::getFName))
				.map(x -> x.getID()).collect(Collectors.toList());
		return cd;
	}

	/**
	 * Retrieves the collection of doctors having a number of patients larger than the average.
	 * 
	 * @return  the collection of doctors' ids
	 */
	public Collection<Integer> busyDoctors(){
		// TODO Complete method
		double average = doctors.entrySet().stream()
				.mapToInt(x -> x.getValue().getPatients().size())
				.average()
				.orElse(0.0);
		Collection<Integer> cd = doctors.values().stream()
				.filter(x -> x.getPatients().size()>average)
				.map(x -> x.getID())
				.collect(Collectors.toList());
		return cd;
	}

	/**
	 * Retrieves the information about doctors and relative number of assigned patients.
	 * <p>
	 * The method returns list of strings formatted as "{@code ### : ID SURNAME NAME}" where {@code ###}
	 * represent the number of patients (printed on three characters).
	 * <p>
	 * The list is sorted by decreasing number of patients.
	 * 
	 * @return the collection of strings with information about doctors and patients count
	 */
	public Collection<String> doctorsByNumPatients(){
		// TODO Complete method
		
		Collection<String> cd = doctors.values().stream()
		//.sorted(Comparator.comparing(Doctor::getPatientNum).reversed())
		.sorted((d1, d2) -> (d2.getPatientNum().compareTo(d1.getPatientNum())))
		.map(x -> {
			return String.format("%3d : %d %s %s", x.getPatientNum(), x.getID(), x.getLName(), x.getFName());
		})
		.collect(Collectors.toList());
		return cd;
		
	
//		return doctors.values().stream()
//				.collect(Collectors.groupingBy(d->d.getPatients().size(),
//						()->new TreeMap<Integer,List<Doctor>>(Comparator.reverseOrder()), // type pars required to guide compiler
//						Collectors.toList()
//						))
//		.entrySet().stream()
//		.flatMap(e->e.getValue().stream())
//		.map( d -> String.format("%3d", d.getPatients().size()) + " : "
//					+ d.getID() +  " " + d.getLName() + " " + d.getFName()
//			)
//		.collect(Collectors.toList())
//		;
//// OR
//		return 
//		patients.values().stream()
//				.filter(p->p.getDoctor()!=null)
//				.collect(Collectors.groupingBy(Patient::getDoctor,Collectors.counting()))
//				.entrySet().stream()
//				.sorted(Comparator.comparing(Map.Entry::getValue).reversed()) // the compiler cannot infer the type
//				.sorted(Comparator.comparing(Map.Entry::getValue,Comparator.reverseOrder())) // while here it can
//				.map( e -> String.format("%3d", e.getValue()) + " : "
//						+ e.getKey().getID() +  " " + e.getKey().getLName() + " " + e.getKey().getFName()
//				)
//				.collect(Collectors.toList())
//				;
		
		
		
		
		
	}
	
	
	/**
	 * Retrieves the number of patients per (their doctor's)  speciality
	 * <p>
	 * The information is a collections of strings structured as {@code ### - SPECIALITY}
	 * where {@code SPECIALITY} is the name of the speciality and 
	 * {@code ###} is the number of patients cured by doctors with such speciality (printed on three characters).
	 * <p>
	 * The elements are sorted first by decreasing count and then by alphabetic speciality.
	 * 
	 * @return the collection of strings with speciality and patient count information.
	 */
	public Collection<String> countPatientsPerSpecialization(){
		Collection<String> cps = doctors.values().stream()
				.collect(Collectors.groupingBy(x->x.getSpecialization(), TreeMap::new, Collectors.summingInt(Doctor::getPatientNum)))
				.entrySet().stream()	
				.sorted(Comparator.comparing(Map.Entry<String,Integer>::getValue).reversed())
				//.sorted((f1,f2) -> Long.compare(f2.getValue(), f1.getValue()))
				.map(x -> {
					return String.format("%3d - %s", x.getValue(), x.getKey());
				})
				.collect(Collectors.toList());
		return cps;
	}
	
	
	
}