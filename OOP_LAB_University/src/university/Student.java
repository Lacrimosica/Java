package university;

public class Student {
	String name;
	int id;
	public Course[] courses;
	public int course_index=0;
	
	public Student(String name, int id){
		this.name = name;
		this.id = id;
		courses = new Course[25];
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
	
	public Course[] getCourses() {
		return courses;
	}
	public void addCourse(Course course) {
		this.courses[course_index++] = course;
		//System.out.println(this.courses[course_index-1]);
	//	System.out.println(course);
		System.out.println("Course " + course.toString() + "was added to " + this.toString());
	}
	
	public String toString() {
		return this.id + " " + this.name;
	}
}

