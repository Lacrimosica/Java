package delivery;

import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import delivery.Delivery.OrderStatus;



public class Order {
	private int OID;
	private int CID;
	private Customer customer;
	private OrderStatus st;
	private int etm;
	private double total;
	
	private Map<Food, Integer> items;
	
	
	public Order(int oid, int cid) {
		this.OID = oid;
		this.CID = cid;
		this.st = OrderStatus.NEW;
		items = new LinkedHashMap<>();
		this.total = 0;
		this.customer = Delivery.getInstance().getCustomer(cid);
	}
	
	public int getOID() {
		return this.OID;
	}
	public Customer getCustomer() {
		return this.customer;
		
	}
	
	public Map<Food, Integer> getItems() {
		return items;
	}
	
	public List<String> getOrderItems() {
		List<String> res = new ArrayList<>();
		for(Entry<Food, Integer> entry: items.entrySet()) {
			res.add(entry.getKey().getDescription() + ", " + entry.getValue());
		}
		return res;
	}
	
	public int addToOrder(Food f, int qty) {
		if(items.containsKey(f)) {
			items.replace(f, qty + items.get(f));
			return qty + items.get(f);
		}
		items.put(f, qty);
		return qty;
	}
	
	public double getTotal() {
		double tmp=0;
		for(Entry<Food, Integer> e : items.entrySet()) {
			tmp += e.getKey().getPrice() * e.getValue();
		}
		this.customer.addToTotal(tmp);
		this.total = tmp;
		return total;
	}
	
	public int getCID() {
		return this.CID;
	}
	
	public OrderStatus getSt() {
		return this.st;
	}
	
	public void setSt(OrderStatus st) {
		this.st = st;
	}
	
	
	public int confirmOrder() {
		this.setSt(OrderStatus.CONFIRMED);
		Optional<Food> maxo =  items.keySet().
				stream().collect(maxBy(comparing(Food::getPrepTime)));	
		if(maxo.isPresent()){ 
			etm = 5 + 15 + maxo.get().getPrepTime();
		}
		return etm;
	}
	
	public int startOrder() {
		this.setSt(OrderStatus.PREPARATION);
		etm -= 5;
		
		return etm;
	}
	
	public int deliverOrder() {
		this.setSt(OrderStatus.ON_DELIVERY);
		etm = 15;
		return etm;
	}
	
	public void completeOrder() {
		this.setSt(OrderStatus.DELIVERED);
	}

}
