package it.polito.oop.vaccination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

import static java.util.stream.Collectors.toList;

public final class Vaccines {
	
	SortedMap<String, Person> people;
	List<AgeInterval> ageIntervals;
	SortedMap<String, Hub> hubs;
	private List<Integer> weeklyHours;
	private List<List<TimeSlot>> times;
	
	public final int YEAR = java.time.LocalDate.now().getYear();
	
	public static Vaccines root;
	public String value;
	private static Vaccines instance;
	
	public static Vaccines getInstance(String value) {
		if(instance == null) {
			instance = new Vaccines();
		}
		return instance;
	}
	
	public Vaccines() {
		people = new TreeMap<String,Person>();
		ageIntervals = new LinkedList<AgeInterval>();
		hubs = new TreeMap<String, Hub>();
		weeklyHours = new ArrayList<Integer>();
	}
	
	
	public boolean addPerson(String first, String last, String ssn, int byear) {
		if(people.containsKey(ssn)) {
			return false;
		}else {
			Person p = new Person(first, last, ssn, byear);
			this.people.put(ssn, p);
			return true;
		}
	}
	
	public int countPeople() {
		return people.size();
	}
	
	public String getPerson(String ssn) {
		if(!people.containsKey(ssn)) {
			return null; 
		}else {
			return people.get(ssn).toString();
		}
	}
	
	public int getAge(String ssn) {
		int byear = people.get(ssn).getByear();
		return YEAR-byear;
	}
	
	public int loadPeople(Reader reader) throws IOException{
		try(BufferedReader bf = new BufferedReader(reader)){
			List<String> lines = bf.lines().collect(Collectors.toList());
			
			
			String [] headers = lines.remove(0).split(",");
			Map<String, Integer> h2i = new HashMap<>();
			for(int i = 0; i <headers.length ; i++) {
				h2i.put(headers[i], i);
			}
			
			lines.stream().forEach(x -> {
				try {
					String [] cells = x.split(",");
					String ssn = cells[h2i.get("SSN")];
					String last = cells[h2i.get("LAST")];
					String first = cells[h2i.get("FIRST")];
					int year = Integer.parseInt(cells[h2i.get("YEAR")]);
					
					addPerson(first,last, ssn, year);
					
				}catch (ArrayIndexOutOfBoundsException e) {
					System.err.println("Missing elements on the line");
				} catch (NumberFormatException e) {
					System.err.println("Cannot parse integer value");
				}
			});
			return lines.size();
		}
	}
	
	public void setAgeIntervals(int... args) {
		int i=0;
		do{
			if(i ==0) {
				AgeInterval ai = new AgeInterval(i, args[i]);
				ageIntervals.add(ai);
				i++;
			}else if(i == args.length) {
				AgeInterval ai = new AgeInterval(args[i-1]);				
				ageIntervals.add(ai);
				i++;
			}else {
			AgeInterval ai = new AgeInterval(args[i-1], args[i]);				
			ageIntervals.add(ai);
			i++;
			}
		}while(i> args.length);
			
	}
	
	public Collection<String> getAgeIntervals(){

		TreeSet<String> res = ageIntervals.stream()
				.sorted(Comparator.comparing(AgeInterval::getMin))
				.map( x-> x.toString())
				.collect(Collectors.toCollection(TreeSet::new));
		return res;
	
	}
	
	public Collection<String> getInInterval(String label) {
		AgeInterval ai = new AgeInterval(label);
		
		return people.values().stream().filter(p -> p.getAge() > ai.min && p.getAge() < ai.max).map(p -> p.getSSN()).collect(Collectors.toCollection(TreeSet::new));
		}

	public void defineHub(String Name) throws VaccineException{
		if(hubs.containsKey(Name)) {
			throw new VaccineException() ;
		}
		hubs.put(Name, new Hub(Name));
	}
	
	public Collection<String> getHubs(){
		
		return hubs.keySet().stream().collect(toList());
	}

	public void setStaff(String hub, int doctor, int nurse, int other) throws VaccineException{
		
		
		if(!hubs.containsKey(hub)) {
			throw new VaccineException();
			}else if(doctor <= 0 || nurse <=0 || other <= 0) {
			throw new VaccineException();
		}
		else {
			hubs.get(hub).SetConfig(doctor, nurse, other);
		}
	}
	
	public int estimateHourlyCapacity(String hub) throws VaccineException{
		
		if(!hubs.containsKey(hub)) {
			throw new VaccineException();	
			}else if(!hubs.get(hub).StaffIsDefined()) {
				throw new VaccineException();
				}
		return hubs.get(hub).getCapacity();
	}
	
	public void setHours(int... hours) throws VaccineException {
		if(hours.length != 7) {
			throw new HubException("Wrong number of hours");
		}if(Arrays.stream(hours).filter(i -> i>12).findAny().isPresent()) {
			throw new VaccineException();
			}else {
			for(int i: hours) {
				weeklyHours.add(i);
				Hub.setWeeklyHours(hours);
			}
		}
	}
	
	public List<List<String>> getHours(){

		return Hub.weekSlots;
	}
	
	
	public int getDailyAvailable(String hub, int d) {
		
		return hubs.get(hub).getCapacity() * Hub.weekSlots.get(d).size();
	}
	
	
	public Map<String,List<Integer>> getAvailable(){
		
		return null;
	}
	
	
	
	public List<String> allocate(String hub, int d){
		
		
		return null;
	}
	
	
	public void clearAllocation() {
		
	}
	
	
	public List<Map<String,List<String>>> weekAllocate(){
		
		return null;
	}
	
	
	public double propAllocated() {
		
		return 0.0;
	}
	
	public Map<String,Double> propAllocatedAge(){
		
		
		return null;
	}
	
	public Map<String,Double> distributionAllocated(){
		return null;
	}
	
	public void setLoadListener( BiConsumer<Integer,String> bc) {
		
	}
}
