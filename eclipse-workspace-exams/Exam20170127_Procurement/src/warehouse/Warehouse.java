package warehouse;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Warehouse {
	Map<String, Product> products;
	Map<String, Supplier> suppliers;
	Map<String, Order> orders;
	
	public static Warehouse instance;
	
	public static int orderCounter = 1;
	
	public static Warehouse getInstance() {
		if(instance == null) {
			instance = new Warehouse();
		}
		return instance;
	}
	
	public Warehouse() {
		products = new HashMap<>();
		suppliers = new HashMap<>();
		orders = new LinkedHashMap<>();
		
	}
	
	public Product newProduct(String code, String description){
		Product p = new Product(code, description);
		getInstance().products.put(description, p);
		return p;
	}
	
	public Collection<Product> products(){
		return getInstance().products.values();
	}

	public Product findProduct(String code){
		return products.get(code);
	}

	public Supplier newSupplier(String code, String name){
		Supplier s = new Supplier(code, name);
		getInstance().suppliers.put(code, s);
		return s;
	}
	
	public Supplier findSupplier(String code){
		return getInstance().suppliers.get(code);
	}

	public Order issueOrder(Product prod, int quantity, Supplier supp)
		throws InvalidSupplier {
		if(!supp.supplies().contains(prod)) {
			throw new InvalidSupplier();
		}
		Order o = new Order(orderCounter, prod, supp, quantity);
		getInstance().orders.put(o.getCode(), o);
		return o;
	}

	public Order findOrder(String code){
		return getInstance().orders.get(code);
	}
	
	public List<Order> pendingOrders(){
		return getInstance().orders.values().stream()
					.filter(o -> !o.delivered())
						.sorted(comparing(Order::getCode))
							.collect(toList());
	
	}

	public Map<String,List<Order>> ordersByProduct(){
	    return getInstance().orders.values().stream()
	    		.collect(groupingBy( o -> o.getProduct().getCode()));
	}
	
	public Map<String,Long> orderNBySupplier(){
	    return getInstance().orders.values().stream()
	    		.filter(o -> o.delivered())
	    		.sorted(comparing(o -> o.getSupplier().getName()))
	    		.collect(groupingBy(o -> o.getSupplier().getName() ,counting()));
	}
	
	public List<String> countDeliveredByProduct(){
	    return getInstance().orders.values().stream()
	    			.filter(o -> o.delivered())
	    				.collect(groupingBy( o -> o.getProduct().getCode(), counting()))
	    					.entrySet().stream()
	    						.sorted(comparing(Map.Entry<String, Long>::getValue).reversed())
	    						.map(e -> e.getKey() + " - " + e.getValue())
	    						.collect(toList());
	}
}
