package it.polito.oop.milliways;


import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class Restaurant {
	
	Map<String, Race> races;
	Map<Integer, Hall> halls;
	List<Party> seatedParties;
	
    public Restaurant() {
    	races = new HashMap<>();
    	halls = new LinkedHashMap<>();
    	seatedParties = new ArrayList<>();
	}
	
	public Race defineRace(String name) throws MilliwaysException{
		if(races.containsKey(name)) {
			throw new MilliwaysException();
		}else {
			Race r = new Race(name);
			races.put(name, r);
			return r;
		}
	}
	
	public Party createParty() {
	    return new Party();
	}
	
	public Hall defineHall(int id) throws MilliwaysException{
		Hall h = new Hall(id);
		halls.put(id, h);
		return h;
	}

	public List<Hall> getHallList() {
		return halls.values().stream().collect(Collectors.toList());
	}

	public Hall seat(Party party, Hall hall) throws MilliwaysException {
		
		if(!hall.isSuitable(party)) {
			throw new MilliwaysException();
		}else {
			seatedParties.add( party);
			hall.assignparty(party);
			return hall;
		}
	}

	public Hall seat(Party party) throws MilliwaysException {
		Optional<Hall> hall = halls.values().stream().filter( h -> h.isSuitable(party)).findFirst();
		if(!hall.isPresent()) {
			throw new MilliwaysException();
		}else {
			seatedParties.add(party);
			hall.get().assignparty(party);
			return hall.get();
		}
	}
	

	public Map<Race, Integer> statComposition() {
		return seatedParties.stream()
				.flatMap(e -> e.getMembers().entrySet().stream())
				.collect(Collectors.groupingBy(
						Map.Entry<Race, Integer>::getKey,
						Collectors.summingInt(Map.Entry::getValue)));
	}
							

	public List<String> statFacility() {
		Comparator<Map.Entry<String, Long>> c = 
				Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder());
		c = c.thenComparing(Map.Entry::getKey);
		
	
		
		return halls.values().stream().flatMap(f -> f.getFacilities().stream())
				.collect(Collectors.groupingBy(
						x -> x, 
						Collectors.counting()))
				.entrySet().stream()
				.sorted(c)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}
	
	public Map<Integer,List<Integer>> statHalls() {
		
		return halls.values().stream().
	            collect(groupingBy(
                                Hall::getNumFacilities,
                                TreeMap::new,
                                mapping(Hall::getId, 
										collectingAndThen(toList(),
                										l->{
                											Collections.sort(l);
                											return l;
                										}))
                                ));

	}

}
