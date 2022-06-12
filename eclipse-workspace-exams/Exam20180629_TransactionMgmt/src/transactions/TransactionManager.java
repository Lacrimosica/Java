package transactions;
import java.util.*;

import static java.util.stream.Collectors.*;

//import static java.util.stream.Collectors.*;
//import static java.util.Comparator.*;

public class TransactionManager {
	
	Map<String,Region> regions;
	Map<String, Carrier> carriers;
	
	
	private static TransactionManager instance;
	
	public static TransactionManager getInstance() {
		if(instance == null) {
			instance = new TransactionManager();
		}
		return instance;
	}
	
	public TransactionManager() {
		regions = new TreeMap<>();
		carriers = new TreeMap<>();
	}
	
	public Region getRegion(String name) {
		return getInstance().regions.get(name);
	}
	public Carrier getCarrier(String name) {
		return getInstance().carriers.get(name);
	}
	
//R1
	public List<String> addRegion(String regionName, String... placeNames) { 
		Region r = new Region(regionName);
		getInstance().regions.put(regionName, r);
		return r.addPlaces(placeNames);
	}
	
	public List<String> addCarrier(String carrierName, String... regionNames) { 
		Carrier c = new Carrier(carrierName);
		getInstance().carriers.put(carrierName, c);
		return c.addRegions(regionNames);
	}
	
	public List<String> getCarriersForRegion(String regionName) { 
		return getRegion(regionName).getCarriers();
	}
	
//R2
	public void addRequest(String requestId, String placeName, String productId) 
			throws TMException {
	}
	
	public void addOffer(String offerId, String placeName, String productId) 
			throws TMException {
	}
	

//R3
	public void addTransaction(String transactionId, String carrierName, String requestId, String offerId) 
			throws TMException {
	}
	
	public boolean evaluateTransaction(String transactionId, int score) {
		return false;
	}
	
//R4
	public SortedMap<Long, List<String>> deliveryRegionsPerNT() {
		return new TreeMap<Long, List<String>>();
	}
	
	public SortedMap<String, Integer> scorePerCarrier(int minimumScore) {
		return new TreeMap<String, Integer>();
	}
	
	public SortedMap<String, Long> nTPerProduct() {
		return new TreeMap<String, Long>();
	}
	
	
}

