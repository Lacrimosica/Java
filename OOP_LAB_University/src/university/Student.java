package university;

public class Student {
	String name;
	int id;
	public String[] courses;
	public int courseIndex=0;	
	
	public Student(String name, int id){
		this.name = name;
		this.id = id;
		courses = new String[25];
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return this.id;
	}
	public void addCourse(Course course) {
		this.courses[courseIndex++] = course.toString();
	}
	
	public String studyPlan() {	
		String str= "";
		for(String c: this.courses) {
			if(c !=null) {
			str = c.toString();
			str += "\n";
			}
		}
		return str;
	}
	public String toString() {
		return this.id + " " + this.name;
	}
}


