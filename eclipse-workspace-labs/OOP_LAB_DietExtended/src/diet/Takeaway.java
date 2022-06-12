package diet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


public class Takeaway {
	Food food;

	List<Order> orders = new LinkedList<Order>();
	private SortedMap<String , Restaurant> restaurants = new TreeMap<String, Restaurant>();
	private SortedMap<String, User> users = new TreeMap<String, User>();
	
	public void addRestaurant(Restaurant r) {
		restaurants.put(r.getName(), r);
	}

	public Collection<String> restaurants() {
		return new LinkedList<>(restaurants.keySet());
	}
	
	public User registerUser(String firstName, String lastName, String email, String phoneNumber) {
		User u = new User(firstName, lastName);
		u.SetEmail(email);
		u.setPhone(phoneNumber);

		String LFname = lastName + " " + firstName;
		users.put(LFname, u);
		
		return u;
	}
	
	public Collection<User> users(){
		ArrayList<User> u = new ArrayList<User>(users.values());
		u.sort(Comparator.comparing( (User us) -> us.getLastName()).thenComparing(User::getLastName));
		return u;
	}
	
	public Order createOrder(User user, String restaurantName, int h, int m) {
		Restaurant r = restaurants.get(restaurantName);		
		Order o = new Order(user, restaurants.get(restaurantName), h, m);
		System.out.println("new order created");
		r.addOrder(o);
		return o;
	}
	
	public Collection<Restaurant> openedRestaurants(String time){
		Time t = new Time(time);
		List<Restaurant> openRestaurants = new ArrayList<Restaurant>();
		
		for(Restaurant r : restaurants.values()) {
			if(r.checkTime(t).equals(t)) {		
				openRestaurants.add(r);
			}
		}
		Collections.sort(openRestaurants);
		return openRestaurants;
	}

	
}
