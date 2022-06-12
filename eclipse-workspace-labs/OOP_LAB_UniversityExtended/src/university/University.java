package university;

import java.util.ArrayList;

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

	public String getName(){

		return name;
	}

	public void setRector(String first, String last){
	
		this.rector = first + " " + last;
	}

	public String getRector(){
		
		return rector;
	}

	public int enroll(String first, String last){
	
		Student st = new Student(first, last , SREG+SCOUNT);
		this.students.add(st);
		
		return SREG+ SCOUNT++;
		
	}
	
	public String student(int id){
		Student s = students.get(id-SREG);
		return  s.toString();
	}
	

	public int activate(String title, String teacher){
	
		Course cs = new Course(title, teacher , CREG + CCOUNT);
		this.courses.add(cs);
		return CREG+ CCOUNT++;
	}
	

	public String course(int code){
	
		return courses.get(code - CREG).toString();
	}
	

	public void register(int studentID, int courseCode){
	
		Student s = students.get(studentID - SREG);
		Course c = courses.get(courseCode - CREG);
		
		
		s.enroll(c);
		c.enroll(s);
	}
	

	public String listAttendees(int courseCode){

		
		return courses.get(courseCode-CREG).Attendees();
	}


	public String studyPlan(int studentID){
	
		return students.get(studentID - SREG).Attends();
	}
}
