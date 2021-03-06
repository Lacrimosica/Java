package university;

public class Course {
	private int code;
	private String name;
	private String teacherName;
	private String students[];
	private int studentsIndex=0;
	
	public Course(String title, int code, String tname) {
		this.name = title;
		this.code = code;
		this.teacherName = tname;
		students = new String[100];
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
		this.students[studentsIndex++] = student.toString();
	}

	public String listAttendees() {
		String str = "";
		for(String s: this.students) {
			if(s != null) {
			str += s;
			str += "\n";
			}
		}
		return str;
	}
	public String toString() {
		return this.code + "," + this.name + "," + this.teacherName;
	}
}
