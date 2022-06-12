package fit;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Gym {
	private String name;
	private SortedMap<Integer, Map<Integer,Lesson>> slots;
	
	
	
	public Gym(String name) {
		this.name = name;
		slots = new TreeMap<>();
		
	}
	
	
	public void addLesson(String activity, int max, String times, String[] inst ) {
		
		String[] days = times.split(",");
		String[] slot;
		
		Map<Integer, Lesson> res = new LinkedHashMap<>();
		
		Lesson l = new Lesson(this, activity);
		l.
		if(days.length != 7) {
			throw new FitException();
		}
		
		for(String s: days) {
			slot = s.split(".");
			
	
			
		}
				
		
	}
	
}
