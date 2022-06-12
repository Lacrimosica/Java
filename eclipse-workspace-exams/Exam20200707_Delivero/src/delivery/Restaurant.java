package delivery;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Restaurant	implements Comparable<Restaurant> {
//	public static final Restaurant dishDirectory;
	
	public static Restaurant instance;
	
	private String name; 
	private String category;
	private SortedMap<String, Dish> dishes;
	private LinkedList<Order> orders;
	private int orderCount =1;
	
	public Restaurant(String n , String c) {
		this.name = n;
		this.category = c;
		dishes = new TreeMap<>();
		orders = new LinkedList<>();
	}
	
	
	private Restaurant() {}
	
	public static Restaurant getIntance() {
		if(instance == null) {
			instance = new Restaurant();
		}
		return instance;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public Dish getDish(String name) {
		return dishes.get(name);
	}
	
	public List<String> getDishNames(){
		return dishes.keySet().stream().collect(Collectors.toList());
	}

	public List<Dish> getDishes(){
		return dishes.values().stream().collect(Collectors.toList());
	}
	public void addDish(String name, float price) throws DeliveryException {
		
		if(dishes.containsKey(name)) {
			throw new DeliveryException("duplicated Dish");
		}
		dishes.put(name	, new Dish(name, price));
	}
	
	public int addOrder(String dishNames[],
			int quantities[], 
			String customerName, 
			String restaurantName,
			int deliveryTime, 
			int deliveryDistance) {
	
		orders.add(new Order(orderCount, dishNames, quantities, customerName, restaurantName, deliveryTime, deliveryDistance));
		return orderCount++; 
	}
	
	public List<Order> getOrders(){
		return orders;
	}
	@Override
	public int compareTo(Restaurant r) {
		// TODO Auto-generated method stub
		return name.compareTo(r.getName());
	}
	
	
}
