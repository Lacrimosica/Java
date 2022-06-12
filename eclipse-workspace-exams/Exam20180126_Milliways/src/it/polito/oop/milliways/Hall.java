package it.polito.oop.milliways;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Hall {
	private int Id;
	private List<String> facilities;
	private List<Party> partiesAssigned;
	
	public Hall(int id) {
		this.Id = id;
		facilities = new ArrayList<>();
		partiesAssigned = new ArrayList<>();
	}

	public int getId() {
		return Id;
	}
	

	public void addFacility(String facility) throws MilliwaysException {
		if(facilities.contains(facility)) {
			throw new MilliwaysException();
		}else {
			facilities.add(facility);
		}
	}

	public List<String> getFacilities() {
        return facilities.stream().sorted().collect(Collectors.toList());
	}
	
	int getNumFacilities(){
        return facilities.size();
	}
	

	public boolean isSuitable(Party party) {
		return party.getRequirements().stream().map(new Function<String, Boolean>() {

			@Override
			public Boolean apply(String t) {
				return facilities.contains(t);
			}
		}).reduce(true, Boolean::logicalAnd);
	
	}
	
	public void assignparty(Party p) {
		partiesAssigned.add(p);
	}
	
}
