package university;

import java.util.ArrayList;

public class Course {
	String name;
	String teacher;
	int code;
	ArrayList<Student> Senrolled;

	public int getCode() {
		return code;
	}

	public Course(String name , String prof, int code){
		this.name = name;
		this.teacher = prof;
		this.code = code;
		Senrolled = new ArrayList<Student>();
	}
	
	public void enroll(Student s) {
		Senrolled.add(s);
	}

	public String Attendees() {
		StringBuffer result = new StringBuffer();
		
		for(Student s : Senrolled){
			if(s!=null){
				result.append(s.toString()).append("\n");
			}
		}
		return result.toString();
	}

	@Override
	public String toString() {
		return code + ", " + name + ", " + teacher + '\n';
	}
}
