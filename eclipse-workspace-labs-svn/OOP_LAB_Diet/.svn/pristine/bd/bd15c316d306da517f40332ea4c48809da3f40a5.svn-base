package diet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import diet.Order.OrderStatus;

/**
 * Represents a restaurant in the take-away system
 *
 */
public class Restaurant implements Comparable<Restaurant>{
	private String name;
	private Food food;
	
	private List<WorkingHours> working_hours;
	private Map<String, Menu> menus;
	private List<Order> orders = new ArrayList<Order>();
	
	
	public Restaurant(String name, Food food) {
		this.name = name;
		this.food = food;
		working_hours = new ArrayList<WorkingHours>();
		menus = new HashMap<String, Menu>();
	}
	
	public void addOrder(Order o) {
		orders.add(o);
	}
	
	public String getName() {
		return name;
	}
	

	public void setHours(String ... hm) {
		working_hours.clear();
		for(int i=0 ; i< hm.length/2 ; i++) {
			working_hours.add(new WorkingHours(hm[2*i], hm[2*i+1]));
		}
	}
	
	public Menu getMenu(String name) {
		return menus.get(name);
	}

	public Menu createMenu(String name) {
		
		Menu m = food.createMenu(name);
		
		menus.put(name, m);
		System.out.println("Menu created " + m.getName() + " For restaurant: " + this.getName());
		return m ;
	}

	public String ordersWithStatus(OrderStatus status) {
		StringBuffer b = new StringBuffer();
		orders.sort(Comparator.comparing( (Order ord) -> ord.getRestaurant().getName())
				.thenComparing((Order o) -> o.getUser().getLastName())
				.thenComparing((Order o) -> o.getUser().getFirstName())
				.thenComparing((Order o) -> o.getDeliveryTime()));
		
		for(Order o: orders) {
			if(o.getStatus() == status) {
				b.append(o.toString());
			}
		}
		return b.toString();
	}
	
	public Time checkTime(Time t) {
		Collections.sort(working_hours);
		for(WorkingHours w: working_hours) {
			if(w.includes(t)) {
				return t;
			}
		}
		for(WorkingHours w: working_hours) {
			if(w.getOpen().compareTo(t) > 0) {
				return w.getOpen();
			}
		}
		System.out.println("comeback tommorow");
		return working_hours.get(0).getOpen();
	}

	@Override
	public int compareTo(Restaurant o) {
		return this.getName().compareTo(o.getName());
	}
}
