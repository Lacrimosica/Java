package discounts;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class Directory {
	
	
	
	public static Directory getInstance() {
		if(instance == null) {
			instance = new Directory();
		}
		return instance;
	}
	
	private static Directory instance;
	private List<Card> cards;				//<card>
	private Map<String, Integer> discounts;   //<Category,Discount>
	private Map<String, Product> products;		//<Code, Product>
	private Set<String> categories;
	private List<Purchase> purchases;
	
	private Directory() {
		cards = new LinkedList<>();
		discounts = new HashMap<>();
		products = new HashMap<>();
		categories = new TreeSet<>();
		purchases = new LinkedList<>();
	}
	
	//card related
	public void addCard(Card c) {
		this.cards.add(c);
	}
	
	public String getCardHolder(int cardN) {
		return cards.get(cardN-1).getName();
	}
	
	public int getNumberOfCards() {
		return cards.size();
	}
	
	//product related
	public void addProduct(Product p) throws DiscountsException {
		if(products.containsKey(p.getCode())) {
			throw new DiscountsException();
		}
		products.put(p.getCode(), p);
		categories.add(p.getCategory());
	}
	
	public Product getProduct(String code) throws DiscountsException {
		if(!products.containsKey(code)) {
			throw new DiscountsException();
		}
		return products.get(code);
	}
	
	public double computeAverageForCategory(String category) throws DiscountsException {
		double avg=0;
		int cnt=0;
		for(Product p: this.products.values()) {
			if(p.getCategory().equals(category)) {
				avg += p.getPrice();
				cnt++;
			}
		}
		
		if(cnt == 0) {
			throw new DiscountsException();
		}
		avg /= cnt;
		return avg;
	}
	
	
	//Discount related
	
	public void addDiscount(String Category , int percentage) throws DiscountsException {
		if(!categories.contains(Category)) {
			throw new DiscountsException();
		}
		discounts.replace(Category, percentage);
		for(Product p : products.values()) {
			p.applyDiscount(Category, percentage);
		}
	}
	
	public int getDiscount(String category) 
//			throws DiscountsException 
	{
//		if(!categories.contains(category)) {
//			throw new DiscountsException();
//		}
		return discounts.get(category);
		
	}

	//purchase related
	public Purchase getPurchase(int code) {
		return purchases.get(code-1);
	}
	
	public int addPurchase(Purchase purch, String[] items) throws DiscountsException {
		String[] tmp;
		
		for(String s : items) {
			tmp = s.split(":");
			
			if(getProduct(tmp[0]) == null) {
				throw new DiscountsException();
			}
			
			purch.addItemToPurchase(getProduct(tmp[0]), Integer.parseInt(tmp[1]));
			purchases.add(purch);
		}
		
		return purch.getId();
		
	}
	
	public SortedMap<Integer, List<String>> getproductIdsPerNofUnits() {
//        SortedMap<String, Integer> pid_qty = 
  	Stream.of(purchases.stream().flatMap(p -> p.getItems());
        				
//    		entrySet().stream()
//    			.collect(toMap(Product::getCode, 
//    				Function.identity(), (b1,b2) -> b1, TreeMap::new)));
        		
//        		pid_qty.entrySet().stream().sorted(comparing(Map.Entry::getValue))
//        	.collect(groupingBy(e -> e.getValue()));
//        
        return null;
	}
	
	public SortedMap<Integer, Integer> getTotalPurchasePerCard() {
        return purchases.stream()
        		.collect(groupingBy(Purchase::getCardId, 
        				TreeMap::new,
        				summingInt(Purchase::getRoundedTotal)));
	}
	
	public Double getTotalPurchaseWithoutCard() {
        return Directory.getInstance().purchases.stream()
        		.filter(p -> !p.isWithCard())
        		.map(Purchase::getTotal)
        		.collect(reducing(0.0,Double::sum));
	}
	
	
	public SortedMap<Integer, Integer> getTotalDiscountPerCard() {
		
		return purchases.stream().filter( p -> p.isWithCard())
			.sorted(comparing(Purchase::getCardId))
				.collect(groupingBy(p -> p.getCardId(),
						TreeMap::new
						, summingInt(Purchase::computeTotalDiscount)));
	}
	
}
