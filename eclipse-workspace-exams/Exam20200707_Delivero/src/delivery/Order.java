package delivery;

import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
	
	public enum scheduleState{
		ASSIGNED
	}
	
	private int id;
	private Map<Dish , Integer> orderedDishes;
	private int time;
	private int distance;
	private String restaurant;
	private String customer;
	scheduleState status;
	
	public Order(int id, String dishNames[],
			int quantities[], 
			String customerName, 
			String restaurantName,
			int deliveryTime, 
			int deliveryDistance)  {

		orderedDishes = new LinkedHashMap<>();
		
		for(int i=0; i< dishNames.length ; i++ ) {
			orderedDishes.put(Directory.getInstance().getRestaurant(restaurantName).getDish(dishNames[i]), quantities[i]);
		}
		this.id = id;
		this.time = deliveryTime;
		this.distance = deliveryDistance;
	}
	
	public void setStatus(scheduleState s) {
		this.status = s;
	}
	public void schedule() {
		setStatus(scheduleState.ASSIGNED);
	}
}
