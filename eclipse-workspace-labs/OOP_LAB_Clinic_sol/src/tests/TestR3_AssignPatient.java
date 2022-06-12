package tests;


import clinic.*;
import java.util.Collection;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestR3_AssignPatient {
	
	private Clinic s;
	private String ssn = "THEPID12I99F181K";
	private int id = 124;
	
	@Before
	public void setUp() {
		s = new Clinic();

		s.addPatient("Giova", "Reds", ssn);
		s.addDoctor("Mario", "White", "THEFIT12I97F181Z", id, "Surgeon");

	}
	

	@Test
	public void testAssignDoctor() throws NoSuchPatient, NoSuchDoctor {
		int id = 124;
		s.addDoctor("Mario", "White", "THEFIT12I97F181Z", id, "Surgeon");
		s.assignPatientToDoctor(ssn, id);

		int res = s.getAssignedDoctor(ssn);

		assertEquals("Wrong sssigned doctor id.", id, res);
	}
	
	@Test(expected=NoSuchPatient.class)
	public void testAssignDoctorNoPatient() throws NoSuchPatient, NoSuchDoctor {
		s.assignPatientToDoctor("NonExisting", id);
	}
	
	@Test(expected=NoSuchDoctor.class)
	public void testAssignDoctorNoDoctor() throws NoSuchPatient, NoSuchDoctor {
		s.assignPatientToDoctor(ssn, id+1);
	}


	@Test(expected=NoSuchDoctor.class)
	public void testNoAssignedDoctor() throws NoSuchPatient, NoSuchDoctor {
			s.getAssignedDoctor(ssn);
	}

	@Test
	public void testList() throws NoSuchPatient, NoSuchDoctor {
		String ssn2 = "BLKSRS11I88F981K";
		s.addPatient("Sirius", "Black", ssn2);

		int id = 124;
		s.addDoctor("Mario", "White", "THEFIT12I97F181Z", id, "Surgeon");
		s.assignPatientToDoctor(ssn, id);
		s.assignPatientToDoctor(ssn2, id);

		Collection<String> patients = s.getAssignedPatients(id);

		assertNotNull("Missing list of patients assigned to doctor White.",patients);
		assertEquals("Patient list should containt two patients.",2,patients.size());
		assertTrue(patients.contains(ssn));
		assertTrue(patients.contains(ssn2));
	}

	@Test
	public void testNoList() throws NoSuchPatient, NoSuchDoctor {
		String ssn2 = "BLKSRS11I88F981K";
		s.addPatient("Sirius", "Black", ssn2);

		int id = 124;
		s.addDoctor("Mario", "White", "THEFIT12I97F181Z", id, "Surgeon");

		Collection<String> patients = s.getAssignedPatients(id);

		assertNotNull("Missing list of patients assigned to doctor White.",patients);
		assertEquals("Patient list should be empty.",0,patients.size());
	}

}