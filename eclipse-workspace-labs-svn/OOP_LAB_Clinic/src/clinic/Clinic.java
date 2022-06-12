package clinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Clinic {
	private Map<String, Person> patients = new HashMap<String, Person>();
	private Map<Integer, Doctor> doctors = new HashMap<Integer, Doctor>();

	public void addPatient(String first, String last, String ssn) {
		patients.put(ssn, new Person(first, last, ssn));
	}

	public String getPatient(String ssn) throws NoSuchPatient {
		if(!patients.containsKey(ssn)) {
			throw new NoSuchPatient();
		}
		return patients.get(ssn).toString();
	}
	
	public Map<String, Person> getPatients() {
		return patients;
	}



	public void addDoctor(String first, String last, String ssn, int docID, String specialization) {
		this.doctors.put(docID, new Doctor(last, first, ssn, docID, specialization));
	}

	public String getDoctor(int docID) throws NoSuchDoctor {
		if(!doctors.containsKey(docID)) {
			throw new NoSuchDoctor();
		}
		return doctors.get(docID).toString();
	}
	
	public void assignPatientToDoctor(String ssn, int docID) throws NoSuchPatient, NoSuchDoctor {
		Person p = patients.get(ssn);
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
		Person p = patients.get(ssn);
		
		if(p == null) {
			throw new NoSuchPatient();
		}
		
		Doctor d = p.getDoctor();
		
		if(d == null) {
			throw new NoSuchDoctor();
		}
		
		return d.getBadgeID();
	}
	
	public Collection<String> getAssignedPatients(int id) throws NoSuchDoctor {
		Doctor d = doctors.get(id);
		if(d == null){
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
	public int loadData(Reader reader) throws IOException {
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
			return lines.size();
		}
	}



	/**
	 * Loads data about doctors and patients from the given stream.
	 * <p>
	 * The text file is organized by rows, each row contains info about
	 * either a patient or a doctor.</p>
	 * <p>
	 * Rows containing a patient's info begin with letter {@code "P"} followed by first name,
	 * last name, and SSN. Rows containing doctor's info start with letter {@code "M"},
	 * followed by badge ID, first name, last name, SSN, and speciality.<br>
	 * The elements on a line are separated by the {@code ';'} character possibly
	 * surrounded by spaces that should be ignored.</p>
	 * <p>
	 * In case of error in the data present on a given row, the method calls the
	 * {@link ErrorListener#offending} method passing the line itself,
	 * ignores the row, and skip to the next one.<br>

	 * 
	 * @param reader reader linked to the file to be read
	 * @param listener listener used for wrong line notifications
	 * @throws IOException in case of IO error
	 */
	public int loadData(Reader reader, ErrorListener listener) throws IOException {
		// TODO Complete method
		return -1;
	}

	public Collection<Integer> idleDoctors(){
		Collection<Integer> cd = doctors.values()
				.stream().filter(x -> x.getPatientNum() ==0)
				.sorted(Comparator.comparing(Doctor::getLastName).thenComparing(Doctor::getFirstName))
				.map(x -> x.getBadgeID()).collect(Collectors.toList());
		return cd;
	}
	public Collection<Integer> busyDoctors(){
		
		double average = doctors.entrySet().stream()
				.mapToInt(x -> x.getValue().getPatients().size())
				.average()
				.orElse(0.0);
				
		Collection<Integer> cd = doctors.values().stream()
				.filter(x ->x.getPatients().size() > average)
				.map(x -> x.getBadgeID())
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
			return String.format("%3d : %d %s %s", x.getPatientNum(), x.getBadgeID(), x.getLastName(), x.getFirstName());
		})
		.collect(Collectors.toList());
		return cd;
				
			
//				return doctors.values().stream()
//						.collect(Collectors.groupingBy(d->d.getPatients().size(),
//								()->new TreeMap<Integer,List<Doctor>>(Comparator.reverseOrder()), // type pars required to guide compiler
//								Collectors.toList()
//								))
//				.entrySet().stream()
//				.flatMap(e->e.getValue().stream())
//				.map( d -> String.format("%3d", d.getPatients().size()) + " : "
//							+ d.getID() +  " " + d.getLName() + " " + d.getFName()
//					)
//				.collect(Collectors.toList())
//				;
		//// OR
//				return 
//				patients.values().stream()
//						.filter(p->p.getDoctor()!=null)
//						.collect(Collectors.groupingBy(Patient::getDoctor,Collectors.counting()))
//						.entrySet().stream()
//						.sorted(Comparator.comparing(Map.Entry::getValue).reversed()) // the compiler cannot infer the type
//						.sorted(Comparator.comparing(Map.Entry::getValue,Comparator.reverseOrder())) // while here it can
//						.map( e -> String.format("%3d", e.getValue()) + " : "
//								+ e.getKey().getID() +  " " + e.getKey().getLName() + " " + e.getKey().getFName()
//						)
//						.collect(Collectors.toList())
//						;
				
				
				
				
				
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
