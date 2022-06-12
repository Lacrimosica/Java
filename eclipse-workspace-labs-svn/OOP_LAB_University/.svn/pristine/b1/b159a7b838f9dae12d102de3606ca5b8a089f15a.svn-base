package university;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Course {
	String name;
	String teacher;
	int code;
	ArrayList<Student> Senrolled;
	Map<Student, Integer> courseScores;
	
	
	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Course(String name , String prof, int code){
		this.name = name;
		this.teacher = prof;
		this.code = code;
		Senrolled = new ArrayList<Student>();
		courseScores = new HashMap<Student, Integer>();
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
	
	
	
	public void registerGrade(Student s, int grade) {
		courseScores.put(s, grade);
	}
	
	
	
	public String getAverage() {
		double avg=0; 
		
		if (courseScores.isEmpty() ){
			
			return  "No student has taken the exam in " + getName();
		}else {
			for(int i : courseScores.values()) {
				avg += i;
			}
		
			
			avg /= courseScores.size();
	
			return "The average for the course " + getName() + " is : " + avg;
		}
	}
	
	
	@Override
	public String toString() {
		return code + ", " + name + ", " + teacher + '\n';
	}
}
