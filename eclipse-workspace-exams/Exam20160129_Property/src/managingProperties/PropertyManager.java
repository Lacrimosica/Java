package managingProperties;
import managingProperties.Request.State;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class PropertyManager {
	
	
	
//	public enum Profession{
//		ELECTRICIAN, PLUMBER, MASON
//	}
	
	static int RequestCounter = 1;
	
	public static PropertyManager instance;
	
	private SortedMap<String, Building> buildings;
	private SortedMap<String, Owner> owners;
	private SortedMap<String, Owner> apartmentsOwnerships;
	private SortedMap<String, Professional> professionals;
	private SortedSet<String> professions;
	
	private List<Request> requests;
	
	public PropertyManager() {
		buildings = new TreeMap<>();
		owners = new TreeMap<>();
		apartmentsOwnerships = new TreeMap<>();
		professionals = new TreeMap<>();
		professions = new TreeSet<>();
		requests = new LinkedList<Request>();
	}
	
	public static PropertyManager getInstance() {
		if(instance == null) {
			instance = new PropertyManager();
		}
		return instance;
	}
	
	public Professional getProfessional(String id) {
		Professional p = PropertyManager.getInstance().professionals.get(id);
		return p;
		
	}
	
	public void professionalEarns(Professional p, int wage) {
		
		int previousEarning = p.getEarning();
		if(previousEarning ==0){
			p.setEarning(wage);
		}else {
			p.setEarning(previousEarning + wage);
		}
	}
	
	
	public Request getRequest(int reqn) {
		return PropertyManager.getInstance().requests.get(reqn-1);
	}
	
	public boolean ApartmentExist(String name) {
		String [] id = name.split(":");
		String bid = id[0];
		int n = Integer.parseInt(id[1]);
		
		if(PropertyManager.getInstance().getBuilding(bid).getNumberOfApartments() >= n) {
			return true;
		}
		
		return false;	
	}
	
	public String getProfessionOf(String id) {
		Professional p = getProfessional(id);
		return p.getProfession();
	}
	
	public Owner getOwnerOf(String aptId) {
		return PropertyManager.getInstance().apartmentsOwnerships.get(aptId);
	}
	public Owner getOwner(String id) {
		return PropertyManager.getInstance().owners.get(id);
	}
	
	public Building getBuilding(String id) {

		return PropertyManager.getInstance().buildings.get(id);
	}
	
	public Set<String> getAllBuildings() {
		return PropertyManager.getInstance().buildings.keySet();
	}
	
	public void addBuilding(String building, int n) throws PropertyException {
	
		if(getAllBuildings().contains(building)) {
			throw new PropertyException("building already exists");
		}
		PropertyManager.getInstance().buildings.put(building, new Building(building, n));
	}


	public void addOwner(String owner, String... apartments) throws PropertyException {
		if(PropertyManager.getInstance().owners.containsKey(owner)) {
			throw new PropertyException("Owner already registered");
		}
		
		Owner o = new Owner(owner);
		for(String ap : apartments) {
			if(o.addApartments(ap)) {
				PropertyManager.getInstance().apartmentsOwnerships.put(ap, o);
			}
		}
		
		PropertyManager.getInstance().owners.put(owner, o);
	}

	public SortedMap<Integer, List<String>> getBuildings() {
		
		SortedMap<Integer, List<String>>  res =  
				PropertyManager.getInstance().buildings.values()
				.stream()
				.sorted(comparing(Building::getBId))
				.collect(groupingBy(Building::getNumberOfApartments
						, TreeMap::new
						, mapping(Building::getBId ,toList())));
		
		return res;
	}
	
	public boolean isAvailable(String name) {
		Professional p = getProfessional(name);
		if( p != null) {
			if(p.getProfession() == null) {
				return true;
			}
			return false;
		}
		return true;
	}
	
	
	public SortedSet<String> getProfessionSet() {
		return PropertyManager.getInstance().professions;
	}
	
	
	public void addProfessionals(String profession, String... professionals) throws PropertyException {
		
		if(!profession.equals("electrician") 
				&& !profession.equals("mason") 
				&& !profession.equals("plumber")) {
			
			throw new PropertyException("profession doesn't exist");
		}
		
		
		if(this.getProfessionSet().contains(profession)) {
			throw new PropertyException("Profession already added");
		}
		
		
		for(String professional : professionals) {
			if(!isAvailable(professional)) {
				throw new PropertyException("Professional already assigned");
			}
			PropertyManager.getInstance().professionals.put(professional, new Professional(professional, profession));
		}
		this.getProfessionSet().add(profession);
	}

	
	
	public SortedMap<String, Integer> getProfessions() {

				return PropertyManager.getInstance()
				.professionals.values().stream()
				.collect(groupingBy(Professional::getProfession, 
						TreeMap::new,
						reducing(0, p -> 2, Integer::sum)));
	}

	public int addRequest(String owner, String apartment, String profession) throws PropertyException {
		
		if(!PropertyManager.getInstance().owners.containsKey(owner)) {
			throw new PropertyException("Owner doesn't exist");
		}
		
		if(!ApartmentExist(apartment)) {
			throw new PropertyException("apartment doesn't exist");
		}
		
		if(!PropertyManager.getInstance().getOwnerOf(apartment).getOId().equals(owner)) {
			throw new PropertyException("this owner doesn't own this building");
		}
		if(!PropertyManager.getInstance().getProfessionSet().contains(profession)) {
			throw new PropertyException("Profession doesn't exist");
		}
		
		Request r = new Request(RequestCounter, owner, apartment, profession);
		PropertyManager.getInstance().requests.add(r);
		RequestCounter++;
		return RequestCounter-1;
	}

	public void assign(int requestN, String professional) throws PropertyException {
		String profession = getProfessionOf(professional);
		Professional p = getProfessional(professional);
		
		Request r = getRequest(requestN);
		if(r == null) {
			throw new PropertyException("Request doens't exist");
		}
		
		if(!profession.equals(r.getProfession())){
			throw new PropertyException("profession doesn not practice this profession");
		}
		
		p.addRequest(r);
		r.Assing(professional);
	
		
	}

	public List<Integer> getAssignedRequests() {
		
		return PropertyManager.getInstance().requests
				.stream()
				.filter(r -> r.getSt().equals(State.ASSIGNED))
				.sorted(comparing(Request::getRequestNumber))
				.map(r -> r.getRequestNumber())
				.collect(toList());
	}

	
	public void charge(int requestN, int amount) throws PropertyException {
		
		Request r = getRequest(requestN);
		
		if(r == null) {
			throw new PropertyException("request doens't exist");
		}
		
		if(!r.getSt().equals(State.ASSIGNED)) {
			throw new PropertyException("request is not assigned");
		}
		
		if(amount <0 || amount > 1000) {
			throw new PropertyException("invalid amount");
		}
		
		professionalEarns(r.getProfessional(), amount);
		r.complete(amount);
	}

	/**
	 * Returns the list of request ids
	 * 
	 */
	public List<Integer> getCompletedRequests() {
		
		return PropertyManager.getInstance().requests
				.stream()
				.filter(r -> r.getSt().equals(State.COMPLETED))
				.sorted(comparing(Request::getRequestNumber))
				.map(r -> r.getRequestNumber())
				.collect(toList());
	}
	
	/**
	 * Returns a map ( owner => total expenses )
	 * 
	 */
	public SortedMap<String, Integer> getCharges() {	
		return
				 PropertyManager.getInstance().owners.values().stream()
				 .filter(o -> o.getPaidChares() > 0 )
				.collect(groupingBy(Owner::getOId
						,TreeMap::new
						,summingInt(Owner::getPaidChares)));

	}

	/**
	 * Returns the map ( building => ( profession => total expenses) ).
	 * Both buildings and professions are sorted alphabetically
	 * 
	 */
	public SortedMap<String, Map<String, Integer>> getChargesOfBuildings() {
		SortedMap<String, Map<String, Integer>> res = 
				
				PropertyManager.getInstance().requests.stream()
				.filter(r -> r.getSt().equals(State.COMPLETED))
				.filter(r -> r.getChargedPrice() > 0)
				.collect(groupingBy(Request::getBId 
						, TreeMap::new
						, groupingBy( (Request r) -> r.getProfessional().getId(), 
								TreeMap::new , summingInt( (Request r) -> r.getProfessional().getEarning()))));
		return res;

	}

}
