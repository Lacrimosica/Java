package transactions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class Region {
	private Set<String> places;
	private Set<String> carriers;	
	private String name;
	
	
	public Region(String name) {
		places = new TreeSet<>();
		this.name = name;
	}
	
	
	public Set<String> getPlaces(){
		return this.places;
	}
	
	public List<String> getCarriers(){
		return new ArrayList<>(carriers);
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<String> addPlaces(String[] s){
		
		for(String  p : s) {
			if(checkPlace(p)) places.add(p);
		}
		
		return new ArrayList<>(places);
	}
	
	public void addCarrier(String c){
		this.carriers.add(c);
	}
	
	public boolean checkPlace(String p) {
		
		Collection<Region> ts = TransactionManager.getInstance().regions.values();
		Optional<Region> res = ts.stream().filter(r-> r.getPlaces().contains(p)).findAny();
		return res.isEmpty();
	}
}
