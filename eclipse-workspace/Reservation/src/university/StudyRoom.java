package university;
import java.util.Hashtable;

public class StudyRoom {
	

	String name;
	String SCode;
	
	int capacity;
	String seat;
	
	Hashtable <String, String >Seats = new Hashtable<String, String>();
	
	public StudyRoom(String n, int cap){
		this.name = n;
		this.capacity = cap;
		
		
	}
	
	
	
	
	public void reservation(StudyRoom sr, String seat) {
		if (sr.capacity > 0) {
			
		}
	}
}
