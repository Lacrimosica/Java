package it.polito.oop.milliways;


import java.util.ArrayList;
import java.util.List;

public class Race implements Comparable<Race>{
    
	private String name;
	private List<String> requirments;
	
	public Race(String name) {
		this.name = name;
		requirments = new ArrayList<>();
	}
	
	public void addRequirement(String requirement) throws MilliwaysException {
		requirments.add(requirement);
	}
	
	public List<String> getRequirements() {
        return requirments;
	}
	
	public String getName() {
        return name;
	}

	@Override
	public int compareTo(Race r) {
		return this.name.compareTo(r.getName());
	}
}
