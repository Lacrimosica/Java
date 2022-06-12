package university;

import java.util.ArrayList;

/**
 * This class represents a university education system.
 * 
 * It manages students and courses.
 *
 */
public class University {
	
	private static University INSTANCE;
	
	final int SREG = 10000;
	final int CREG = 10;
	static int CCOUNT=0;
	static int SCOUNT=0;
	
	
	String name;
	String rector;
	ArrayList <Student> students;
	ArrayList<Course> courses;
	
	private University() {}

	public University(String name){
		//TODO: to be implemented
		this.name  =name;
		this.rector=" ";
		students = new ArrayList<Student>(1000);
		courses = new ArrayList<Course>(1000);
	}
	
	public static University getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new University();
		}
		return INSTANCE;
		
	}
	
	/**
	 * Getter for the name of the university
	 * 
	 * @return name of university
	 */
	public String getName(){
		//TODO: to be implemented
		return name;
	}
	
	/**
	 * Defines the rector for the university
	 * 
	 * @param first
	 * @param last
	 */
	public void setRector(String first, String last){
		//TODO: to be implemented
		this.rector = first + " " + last;
	}
	
	/**
	 * Retrieves the rector of the university
	 * 
	 * @return name of the rector
	 */
	public String getRector(){
		//TODO: to be implemented
		return rector;
	}
	
	/**
	 * Enroll a student in the university
	 * 
	 * @param first first name of the student
	 * @param last last name of the student
	 * 
	 * @return unique ID of the newly enrolled student
	 */
	public int enroll(String first, String last){
		//TODO: to be implemented
		Student st = new Student(first, last , SREG+SCOUNT);
		this.students.add(st);
		return SREG +SCOUNT++;
	}
	
	/**
	 * Retrieves the information for a given student
	 * 
	 * @param id the ID of the student
	 * 
	 * @return information about the student
	 */
	public String student(int id){
		Student s = students.get(id-SREG);
		return  s.toString();
	}
	
	/**
	 * Activates a new course with the given teacher
	 * 
	 * @param title title of the course
	 * @param teacher name of the teacher
	 * 
	 * @return the unique code assigned to the course
	 */
	public int activate(String title, String teacher){
		//TODO: to be implemented
		Course cs = new Course(title, teacher , CREG + CCOUNT);
		this.courses.add(cs);
		return CREG+ CCOUNT++;
	}
	
	/**
	 * Retrieve the information for a given course.
	 * 
	 * The course information is formatted as a string containing 
	 * code, title, and teacher separated by commas, 
	 * e.g., {@code "10,Object Oriented Programming,James Gosling"}.
	 * 
	 * @param code unique code of the course
	 * 
	 * @return information about the course
	 */
	public String course(int code){
		//TODO: to be implemented
		return courses.get(code - CREG).toString();
	}
	
	/**
	 * Register a student to attend a course
	 * @param studentID id of the student
	 * @param courseCode id of the course
	 */
	public void register(int studentID, int courseCode){
		//TODO: to be implemented
		Student s = students.get(studentID - SREG);
		Course c = courses.get(courseCode - CREG);
		
		
		s.enroll(c);
		c.enroll(s);
	}
	
	/**
	 * Retrieve a list of attendees
	 * 
	 * @param courseCode unique id of the course
	 * @return list of attendees separated by "\n"
	 */
	public String listAttendees(int courseCode){
		//TODO: to be implemented
		
		return courses.get(courseCode-CREG).Attendees();
	}

	/**
	 * Retrieves the study plan for a student.
	 * 
	 * The study plan is reported as a string having
	 * one course per line (i.e. separated by '\n').
	 * The courses are formatted as describe in method {@link #course}
	 * 
	 * @param studentID id of the student
	 * 
	 * @return the list of courses the student is registered for
	 */
	public String studyPlan(int studentID){
		//TODO: to be implemented
		return students.get(studentID - SREG).Attends();
	}
}
