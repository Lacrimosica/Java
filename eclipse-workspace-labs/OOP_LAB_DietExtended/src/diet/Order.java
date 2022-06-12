package diet;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


public class Order {
	static int counter = 0;
	private Time delivertyTime;
	private double price;
	
	public enum OrderStatus {
		ORDERED, READY, DELIVERED;
	}
	
	public enum PaymentMethod {
		PAID, CASH, CARD;
	}
	
	private User user;
	private Restaurant restaurant;
	private OrderStatus os; 
	private PaymentMethod pm;
	
	private Map<Menu,Integer> menus;
	
	public Order(User user, Restaurant restaurant, int hour, int minute) {
		this.user = user;
		this.restaurant = restaurant;
		this.delivertyTime = restaurant.checkTime(new Time(hour, minute));
		this.setStatus(OrderStatus.ORDERED);
		this.setPaymentMethod(PaymentMethod.CASH);
		this.menus = new TreeMap<Menu, Integer>(Comparator.comparing(Menu::getName));
		
	}
	
	public Time getDeliveryTime() {
		return this.delivertyTime;
	}
	public User getUser() {
		return this.user;
	}
	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public double Price() {
		return this.price;
	}
	
	public void setPaymentMethod(PaymentMethod method) {
		this.pm = method;
	}

	public PaymentMethod getPaymentMethod() {
		return this.pm;
	}
	
	public void setStatus(OrderStatus newStatus) {
		this.os = newStatus;
	}
	
	public OrderStatus getStatus(){
		return this.os;
	}
	
	public Order addMenus(String menu, int quantity) {
		System.out.println(counter++);
		Menu m = restaurant.getMenu(menu);
		menus.put(m, quantity);
		
		this.toString();
		System.out.println("Menu " + m.getName() + " added to " +this.getRestaurant().getName() + "'s orders");
		System.out.println(this.toString());
		
		return this;

		
	}
		
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.restaurant.getName()+ ", ")
		.append(user.toString()).append(" : ")
		.append("(").append(delivertyTime.toString()+"):").append("\n");
		
		for(Menu m: menus.keySet()) {
			sb.append("\t" + m.getName() + "->" + menus.get(m) + "\n");  
		}
		return sb.toString();
	}
	
}
