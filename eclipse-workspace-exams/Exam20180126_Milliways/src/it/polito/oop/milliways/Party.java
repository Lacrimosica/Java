package it.polito.oop.milliways;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Party {
	private Map<Race, Integer> companions;
	
	public Party() {
		companions = new HashMap<>();
	}
    public void addCompanions(Race race, int num) {
    	companions.put(race, num);
	}

	public int getNum() {
        return companions.values().stream()
        		.reduce(0, Integer::sum);
	}

	public int getNum(Race race) {
		return companions.entrySet()
						.stream().filter(e -> race.equals(e.getKey().getName()))
							.map(e -> e.getValue())
								.reduce(0, Integer::sum);
		
	}
	
	public Map<Race, Integer> getMembers(){
		return companions;
	}

	public List<String> getRequirements() {
         return companions.keySet().stream()
				        		 .flatMap(k -> k.getRequirements()
				        				 .stream())
				        		 .sorted().distinct()
				        		 			.collect(Collectors.toList());
         
         
         
     //with JCF
//       TreeSet<String> requirments = new TreeSet<>();
//       for(Race r : companions.keySet()) {
//    	   requirments.addAll(r.getRequirements());    	   
//       }
//       return new ArrayList<String>(requirments);
	}

    public Map<String,Integer> getDescription(){
        return companions.entrySet().stream()
        		.collect(Collectors.toMap(e -> e.getKey().getName(), e ->  e.getValue()));
    }

}
