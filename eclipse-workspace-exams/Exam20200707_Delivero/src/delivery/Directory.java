package delivery;

import java.util.SortedSet;
import java.util.TreeSet;

public class Directory {

	private static Directory instance;
	SortedSet<Restaurant> restaurants;
	
	private Directory() {
		restaurants = new TreeSet<>();
	}
	
	public static Directory getInstance() {
		if(instance == null) {
			instance = new Directory();
		}
		return instance;
	}
	
	public Restaurant getRestaurant(String name) {
		for(Restaurant r : restaurants) {
			if(r.getName().equals(name)) return r;
		}
		return null;
	}
	
	public void addRestaurant(Restaurant r) {
		restaurants.add(r);
	}
	
	public SortedSet<Restaurant> getRestaurants(){
		return restaurants;
	}
	
}
