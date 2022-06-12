package delivery;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.LinkedList;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;

import static java.util.Comparator.*;



public class Delivery {
    
	private static Delivery instance;
	private static int customerCounter = 1;
	private static int orderCounter = 1;
	private SortedMap<String, Customer> customers;
	private SortedMap<String, Food> menu;
	private List<Order> orders;
	
	public static enum OrderStatus { NEW, 
		CONFIRMED, PREPARATION, ON_DELIVERY, DELIVERED } 
	
	public Delivery() {
		customers = new TreeMap<>();
		menu = new TreeMap<>();
		orders = new LinkedList<>();
	}
	
	public static Delivery getInstance() {
		if(instance == null)  {
			instance = new Delivery();
		}
		return instance;
	}
	
    
    public SortedMap<String, Customer> getCustomers() {
		return Delivery.getInstance().customers;
	}
    
    public Order getOrder(int oid) {
    	for(Order o: Delivery.getInstance().orders) {
    		if (o.getOID() == oid) return o;
    	}
    	return null;
    }
    public Customer getCustomer(int cid) {
    	for(Customer c: Delivery.getInstance().customers.values()) {
    		if(c.getId() == cid) return c;
    	}
    	return null;
    }
	/**
     * Creates a new customer entry and returns the corresponding unique ID.
     * 
     * The ID for the first customer must be 1.
     * 
     * 
     * @param name name of the customer
     * @param address customer address
     * @param phone customer phone number
     * @param email customer email
     * @return unique customer ID (positive integer)
     */
    public int newCustomer(String name, String address, String phone, String email) throws DeliveryException {
    	if(customers.containsKey(email)) {
    		throw new DeliveryException("duplicate email");
    	}
    	Customer c = new Customer(customerCounter, name, address, phone, email);
    	Delivery.getInstance().customers.put(email, c);
    	
    	return customerCounter++;
    }
    
    /**
     * Returns a string description of the customer in the form:
     * <pre>
     * "NAME, ADDRESS, PHONE, EMAIL"
     * </pre>
     * 
     * @param customerId
     * @return customer description string
     */
    public String customerInfo(int customerId){
    	for(Customer c : Delivery.getInstance().customers.values()) {
    		if(c.getId() == customerId) return c.toString();
    	}
    	return null;
    }
    
    /**
     * Returns the list of customers, sorted by name
     * 
     */
    public List<String> listCustomers(){
        return Delivery.getInstance().customers.values().stream()
        		.sorted(comparing(Customer::getName))
        		.map(Customer::getName)
        		.collect(toList());
    }
    
    /**
     * Add a new item to the delivery service menu
     * 
     * @param description description of the item (e.g. "Pizza Margherita", "Bunet")
     * @param price price of the item (e.g. 5 EUR)
     * @param category category of the item (e.g. "Main dish", "Dessert")
     * @param prepTime estimate preparation time in minutes
     */
    public void newMenuItem(String description,
    		double price,
    		String category, 
    		int prepTime){
        
    	Food f = new Food(category, price, description, prepTime);
    	Delivery.getInstance().menu.put(description, f);
    	
    	System.out.println("new food added to menu " + f.getDescription());
    	System.out.println("second check " + menu.get(f.getDescription()).getDescription());
    }
    
    /**
     * Search for items matching the search string.
     * The items are sorted by category first and then by description.
     * 
     * The format of the items is:
     * <pre>
     * "[CATEGORY] DESCRIPTION : PRICE"
     * </pre>
     * 
     * @param search search string
     * @return list of matching items
     */
    public List<String> findItem(String search){
    	List<String> searchResults = new ArrayList<>();

    	System.out.println("comparing "+ search 
//    			+ " against "+ f.getDescription()
    			);
		for(Food f: menu.values()) {
			if(f.getDescription().equals(search)) {
				searchResults.add(f.toString());
				
			}
		}
    		
		Collections.sort(searchResults);
	    	
    	return searchResults;
    }

    /**
     * Creates a new order for the given customer.
     * Returns the unique id of the order, a progressive
     * integer number starting at 1.
     * 
     * @param customerId
     * @return order id
     */
    public int newOrder(int customerId){
    	
    	Order o = new Order(orderCounter, customerId);
    	Delivery.getInstance().orders.add(o);
    	
        return orderCounter++;
    }
    
    /**
     * Add a new item to the order with the given quantity.
     * 
     * If the same item is already present in the order is adds the
     * given quantity to the current quantity.
     * 
     * The method returns the final total quantity of the item in the order. 
     * 
     * The item is found through the search string as in {@link #findItem}.
     * If none or more than one item is matched, then an exception is thrown.
     * 
     * @param orderId the id of the order
     * @param search the item search string
     * @param qty the quantity of the item to be added
     * @return the final quantity of the item in the order
     * @throws DeliveryException in case of non unique match or invalid order ID
     */
    public int addItem(int orderId, String search, int qty) throws DeliveryException {
    	if(orderId > orderCounter){
    		throw new DeliveryException("orderId is invalid");
    	}
    	
    	List<String> results = findItem(search);
    	System.out.println("result size is : " + results.size());
    	 
//    	if(items.size() != 1) {
//    		throw new DeliveryException("search pattern not precise enough or item non existent");
//    	}
    	
//    	Order o = getInstance().getOrder(orderId);
//    	if(o == null) {
//    		throw new DeliveryException();
//    	}
//    	if(food.isPresent())
//    	{		return o.addToOrder(food.get(), qty);	
//    	
//    	}else {
//    		throw new DeliveryException();
//    	}
    	
    	return 0;
    
    	
    }
    
    /**
     * Show the items of the order using the following format
     * <pre>
     * "DESCRIPTION, QUANTITY"
     * </pre>
     * 
     * @param orderId the order ID
     * @return the list of items in the order
     * @throws DeliveryException when the order ID in invalid
     */
    public List<String> showOrder(int orderId) throws DeliveryException {
        if(Delivery.getInstance().getOrder(orderId) == null ){
        	throw new DeliveryException("order doesn't exist");
        }
   		return Delivery.getInstance().getOrder(orderId).getOrderItems();
    }
    
    /**
     * Retrieves the total amount of the order.
     * 
     * @param orderId the order ID
     * @return the total amount of the order
     * @throws DeliveryException when the order ID in invalid
     */
    public double totalOrder(int orderId) throws DeliveryException {
    	return Delivery.getInstance().getOrder(orderId).getTotal();
    }
    
    /**
     * Retrieves the status of an order
     * 
     * @param orderId the order ID
     * @return the current status of the order
     * @throws DeliveryException when the id is invalid
     */
    public OrderStatus getStatus(int orderId) throws DeliveryException {
        return getInstance().orders.get(orderId-1).getSt();
    }
    
    /**
     * Confirm the order. The status goes from {@code NEW} to {@code CONFIRMED}
     * 
     * Returns the delivery time estimate computed as the sum of:
     * <ul>
     * <li>start-up delay (conventionally 5 min)
     * <li>preparation time (max of all item preparation time)
     * <li>transportation time (conventionally 15 min)
     * </ul>
     * 
     * @param orderId the order id
     * @return delivery time estimate in minutes
     * @throws DeliveryException when order ID invalid to status not {@code NEW}
     */
    public int confirm(int orderId) throws DeliveryException {
    	Order o = getInstance().orders.get(orderId-1);
    	if(!getStatus(orderId).equals(OrderStatus.NEW)) {
    		throw new DeliveryException("Order not in the NEW state");
    	}
        return o.confirmOrder();
    }

    /**
     * Start the order preparation. The status goes from {@code CONFIRMED} to {@code PREPARATION}
     * 
     * Returns the delivery time estimate computed as the sum of:
     * <ul>
     * <li>preparation time (max of all item preparation time)
     * <li>transportation time (conventionally 15 min)
     * </ul>
     * 
     * @param orderId the order id
     * @return delivery time estimate in minutes
     * @throws DeliveryException when order ID invalid to status not {@code CONFIRMED}
     */
    public int start(int orderId) throws DeliveryException {
    	Order o  = Delivery.getInstance().orders.get(orderId-1);
    	if(o == null) {
    		throw new DeliveryException("invalid order id");
    	}
    	if(o.getSt().equals(OrderStatus.CONFIRMED)) {
    		throw new DeliveryException("order not confirmed");
    	}
    	
        return o.startOrder();
    }

    /**
     * Begins the order delivery. The status goes from {@code PREPARATION} to {@code ON_DELIVERY}
     * 
     * Returns the delivery time estimate computed as the sum of:
     * <ul>
     * <li>transportation time (conventionally 15 min)
     * </ul>
     * 
     * @param orderId the order id
     * @return delivery time estimate in minutes
     * @throws DeliveryException when order ID invalid to status not {@code PREPARATION}
     */
    public int deliver(int orderId) throws DeliveryException {
    	Order o  = Delivery.getInstance().orders.get(orderId-1);
    	if(o == null) {
    		throw new DeliveryException("invalid order id");
    	}
    	if(o.getSt().equals(OrderStatus.PREPARATION)) {
    		throw new DeliveryException("order not prepared");
    	}
    	
    	return o.deliverOrder();
    }
    
    /**
     * Complete the delivery. The status goes from {@code ON_DELIVERY} to {@code DELIVERED}
     * 
     * 
     * @param orderId the order id
     * @return delivery time estimate in minutes
     * @throws DeliveryException when order ID invalid to status not {@code ON_DELIVERY}
     */
    public void complete(int orderId) throws DeliveryException {
    	Order o  = Delivery.getInstance().orders.get(orderId-1);
    	if(o == null) {
    		throw new DeliveryException("invalid order id");
    	}
    	if(o.getSt().equals(OrderStatus.ON_DELIVERY)) {
    		throw new DeliveryException("order not on delivery");
    	}
    	
    	o.completeOrder();
    }
    
    /**
     * Retrieves the total amount for all orders of a customer.
     * 
     * @param customerId the customer ID
     * @return total amount
     */
    public double totalCustomer(int customerId){
        DoubleSummaryStatistics dss = Delivery.getInstance().orders.stream()
        		.filter( o-> o.getCID() == customerId)
        		.collect(summarizingDouble(Order::getTotal));
        return dss.getSum();
    }
    
    /**
     * Computes the best customers by total amount of orders.
     *  
     * @return the classification
     */
    public SortedMap<Double,List<String>> bestCustomers(){
    	return Delivery.getInstance().customers.values().stream()
    			.collect(groupingBy(Customer::getTotal,
    					TreeMap::new,    	
    					mapping(c -> c.toString(), toList()))); 
    }
    
// NOT REQUIRED
//
//    /**
//     * Computes the best items by total amount of orders.
//     *  
//     * @return the classification
//     */
//    public List<String> bestItems(){
//        return null;
//    }
//    
//    /**
//     * Computes the most popular items by total quantity ordered.
//     *  
//     * @return the classification
//     */
//    public List<String> popularItems(){
//        return null;
//    }

}
