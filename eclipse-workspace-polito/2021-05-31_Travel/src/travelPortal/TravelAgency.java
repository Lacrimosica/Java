package travelPortal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

class TravelAgency {
	private String name;
	private Set<String> activities = new HashSet<>();
	private SortedMap<String, Activity> activityMap = new TreeMap<>();
	
	TravelAgency(String name) {
		this.name = name;
	}
	
	void addActivity(String activity) {
		activityMap.put(activity, new Acitivity(activity,))
		activities.add(activity);
	}
	
	List<String> getActivities() {
		return activities.stream().sorted().collect(Collectors.toList());
	}
	
	String getName() {
		return name;
	}
	
	boolean offerActivity(String activity) {
		return activities.contains(activity);
	}
}
