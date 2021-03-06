package example;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import libraryMgmt.*;

public class Test01 {
	private LibraryMgmt lm = new LibraryMgmt();

	@Before
	public void setUp() {
		lm = new LibraryMgmt();
	}

	@Test
	public void testAddTestSetCurrentDate() {
		lm.setCurrentDate(LocalDate.parse("2022-02-01"));
		LocalDate localDate = lm.getCurrentDate();
		assertEquals("Wong current date", "2022-02-01", localDate.toString());
	}

	@Test
	public void testAddTestAddDays() {
		lm.setCurrentDate(LocalDate.parse("2022-02-01"));
		lm.addDays(7);
		LocalDate currentDate = lm.getCurrentDate();
		assertEquals("Wrong result of add days","2022-02-08", currentDate.toString());
	}

	@Test
	public void addBook1() throws LMException {
		String string = lm.addBook("titleT1", 4, "authA", "authB");
		assertNotNull("Missing title info", string);
		assertEquals("Wrong volume range",string, "1:4");
	}

	@Test
	public void addBook2() throws LMException {
		lm.addBook("titleT1", 4, "authA", "authB");
		String string = lm.addBook("titleT3", 2, "authA");
		assertNotNull("Missing title info", string);
		assertEquals("Wrong volume range", string, "5:6");
	}

	@Test(expected = LMException.class) // duplicate title
	public void addBookDuplicateTitle() throws LMException {
		lm.addBook("titleT3", 4, "authA", "authB");
		lm.addBook("titleT3", 2, "authA");
	}
	
	@Test
	public void addUser1() throws LMException {
		String string = lm.addUser("userX", 3, 12);
		assertNotNull("Missing user info", string);
		assertEquals("Wrong user info", string, "userX:3:12");
	}

	@Test(expected = LMException.class) // duplicate user
	public void addUserDuplicateUser() throws LMException {
		lm.addUser("userX", 4, 12);
		lm.addUser("userX", 5, 12);
	}
}
