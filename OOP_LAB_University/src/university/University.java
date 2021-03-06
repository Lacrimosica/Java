package university;

/**
 * This class represents a university education system.
 * 
 * It manages students and courses.
 *
 */
public class University {
	private String universityName;
	private String rector;
	
	public Student[] students;
	public Course[] courses;

	public static int SCOUNT=0;
	public static int CCOUNT=0;
	
	public static final int MAX_STUDENTS_IN_UNIVERSITY = 1000;
	public static final int MAX_COURSES_IN_UNIVERSITY = 50;
	public static final int STUDENT_ID_OFFSET = 10000;
	public static final int COURSE_CODE_OFFSET = 10;
	/**
	 * Constructor
	 * @param name name of the university
	 */
	public University(String name){
		//TODO: to be implemented
		this.universityName = name;
		
		this.students = new Student[MAX_STUDENTS_IN_UNIVERSITY];
		this.courses = new Course[MAX_COURSES_IN_UNIVERSITY];
			}
	
	/**
	 * Getter for the name of the university
	 * 
	 * @return name of university
	 */
	public String getName(){
		//TODO: to be implemented
		return universityName;
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
		return this.rector;
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
		Student stud = new Student( (first + " " + last) , SCOUNT+STUDENT_ID_OFFSET); 
		this.students[SCOUNT] = stud;
		return students[SCOUNT++].getId();
	}
	
	/**
	 * Retrieves the information for a given student
	 * 
	 * @param id the ID of the student
	 * 
	 * @return information about the student
	 */
	public String student(int id){
		//TODO: to be implemented
		int index = id-STUDENT_ID_OFFSET;
		return this.students[index].toString();
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
		Course c = new Course(title , CCOUNT+COURSE_CODE_OFFSET, teacher);
		this.courses[CCOUNT] = c;
		return courses[CCOUNT++].getCode(); 
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
	//course works fine
	public String course(int code){ 
		//TODO: to be implemented
		return courses[code-COURSE_CODE_OFFSET].toString();

	}
	/**
	 * Register a student to attend a course
	 * @param studentID id of the student
	 * @param courseCode id of the course
	 */
	public void register(int studentID, int courseCode){
		//TODO: to be implemented
		courses[courseCode - COURSE_CODE_OFFSET].addStudent(students[studentID-STUDENT_ID_OFFSET]);
		students[studentID-STUDENT_ID_OFFSET].addCourse(courses[courseCode-COURSE_CODE_OFFSET]);
	}
	
	/**
	 * Retrieve a list of attendees
	 * 
	 * @param courseCode unique id of the course
	 * @return list of attendees separated by "\n"
	 */
	public String listAttendees(int courseCode){
		int index = courseCode-COURSE_CODE_OFFSET;
	
		return this.courses[index].listAttendees() ;
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
		int index = studentID-STUDENT_ID_OFFSET;
		
		return this.students[index].studyPlan();
	}
}
