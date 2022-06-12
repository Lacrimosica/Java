package university;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {
	String name;
	int matricola;
	double average;
	
	ArrayList<Course> Cenrolled;
	Map<Course, Integer> transcript ;
	
	public int getMatricola() {
		return matricola;
	}

	public String getName() {
		return name;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double d) {
		this.average= d;
	}
	
	public Student(String first, String last, int mat) {
		this.name = first + " " + last;
		this.matricola = mat;
		Cenrolled = new ArrayList<Course>();
		transcript = new HashMap<Course, Integer>();
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
	
	public void giveExam(Course c , int g) {
		transcript.put(c, g);
	
		
	}

	public double average() {
		double avg=0;
		if(transcript.isEmpty()) {
			return -1;
		}
		
		for(int i : transcript.values()) {
			avg += i;
		}
		avg /= transcript.size();
		
		setAverage(avg);
		
		return avg;
		}
	

	@Override
	public String toString() {
		return matricola +" "+ name + '\n';
	}
	
}
