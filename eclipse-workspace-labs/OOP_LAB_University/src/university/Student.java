package university;

import java.util.ArrayList;

public class Student {
	String name;
	int matricola;
	ArrayList<Course> Cenrolled;
	
	public int getMatricola() {
		return matricola;
	}

	public Student(String first, String last, int mat) {
		this.name = first + " " + last;
		this.matricola = mat;
		Cenrolled = new ArrayList<Course>();
	}
	
	public void enroll(Course c) {
			Cenrolled.add(c);
	}
	
	public String Attends() {
		StringBuffer result = new StringBuffer();
		for(Course c : Cenrolled) {
			if(c!=null){
				result.append(c.toString()).append("\n");
			}
			
		}
		return result.toString();
	}
	
	@Override
	public String toString() {
		return matricola +" "+ name + '\n';
	}
	
}
