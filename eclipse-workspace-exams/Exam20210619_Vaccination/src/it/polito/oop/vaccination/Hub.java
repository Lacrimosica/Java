package it.polito.oop.vaccination;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class Hub {

	private String name;
	private int[] config;
	private int capacity;
	private boolean staffDefined =false;
	static int[] weeklyHours;
	public static List<List<String>> weekSlots =null;
	public List<Integer> weeklyCapability =null;
	
//	private List<List<String>>;
	public Hub(String n) {
		this.name = n;
		
	}
	
	public String getName() {
		return this.name;
	}
	public void SetConfig( int d, int n, int o) {
		config[0] = d;
		config[1] = n;
		config[2] = o;
		staffDefined =true;
		compute();
	}
	
	public void compute() {
		capacity = List.of(10 * config[0] , 12 * config[1] , 20 * config[2]).stream().min(Integer::compare).get();
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public boolean StaffIsDefined() {
		return staffDefined;
	}
	
	public int[] getConfig() {
		return config;
	}
	
	public List<Integer> getWeeklyCapability(){
		return this.weeklyCapability;
	}
	
	public static void setWeeklyHours(int[] wh) {
		for(int i=0 ; i< 7; i++) {
			weeklyHours[i] = wh[i];
		}
		
		computeWeeklySlots();
	}
	
	public static List<String> computeSlots(int day) {
		List<String> tmp = null;
	
		for(int j=0 ; j<weeklyHours[day] ; j++) {
			int h = j+9;
			tmp =Stream.iterate(new TimeSlot(h,0), t -> new TimeSlot(h, t.getMin() + 15))
			.limit(4).map(t -> t.toString()).collect(toList());
		}
		
		return tmp;
	}
	
	public static void computeWeeklySlots() {
		for(int i=0; i<7; i++) {
			weekSlots.add(computeSlots(i));
		}
	}
	
	public void computeDailyCapability() {
		for(int i=0 ; i< 7 ; i++) {
			weeklyCapability.add(weekSlots.get(i).size() * this.capacity);
		}
	}
	
}
 