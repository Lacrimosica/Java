package university;

public class Course {
	private int code;
	private String name;
	private String teacherName;
	private Student students[];
	private int students_index=0;
	
	public Course(String title, int code, String tname) {
		this.name = title;
		this.code = code;
		this.teacherName = tname;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getName() {
		return this.name;
	}
	public String getTeacherName() {
		return this.teacherName;
	}
	public void addStudent(Student student) {
		student.addCourse(this);
		//this.students[students_index++] = student;
	}
	public String toString() {
		return this.code + "," + this.name + "," + this.teacherName;
	}
	public Student[] getStudents() {
		return students;
	}
	
}
