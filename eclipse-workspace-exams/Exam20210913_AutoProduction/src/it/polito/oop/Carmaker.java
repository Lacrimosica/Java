package it.polito.oop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import static java.util.stream.Collectors.*;


import java.util.Comparator.*;

public class Carmaker {
	
	public static Carmaker getInstance() {
		if(instance== null) {
			instance = new Carmaker();
		}
		return instance;
	}
	
	
	public static final int YEAR = java.time.LocalDate.now().getYear();
	public static final int DIESEL = 0;
	public static final int GASOLINE = 1;
	public static final int LPG = 2;
	public static final int ELECTRIC = 3;
	
	private static Carmaker instance;
	
	private Map<String, Car> cars;
	private Map<String, Factory> factories;
	private Map<String, Warehouse> warehouses;
	
	public Carmaker() {
		cars = new HashMap<>();
	}
	
	public Warehouse getWarehouse(String name) {
		if(getInstance().warehouses.containsKey(name)) {
			return null;
		}
		return getInstance().warehouses.get(name); 
	}
	
	
	public Factory getFactory(String city) {
		if(getInstance().factories.containsKey(city)) {
			return null;
		}
		return getInstance().factories.get(city); 
	}
	
	public Car getCar(String Model) {
		if(getInstance().cars.containsKey(Model)) {
			return null;
		}
		return getInstance().cars.get(Model); 
	}
	
	
	public boolean addModel(String model, String name, int year, float size, int type) {
		
		if(getCar(model) == null) {
			return false;
		}
		Car c = new Car(model, name, year, size, type);
		getInstance().cars.put(model, c);
		return true;
	}
	
	
	public int countModels() {
		return getInstance().cars.size();
	}
	
	
	public String getModel(String model) {
		if(getCar(model) == null) {
			return null;
		}
		Car c = getCar(model);
		return c.toString();
	}

	public List<String> getActiveModels(){
		return getInstance().cars.values().stream()
				.filter(c -> (YEAR - c.getYear() ) <= 10)
				.map(Car::getModel).collect(toList());
	}
	
	
	public void buildFactory(String city) throws BrandException {
		if(getFactory(city) == null) {
			throw new BrandException();
		}
		Factory f = new Factory(city);
		getInstance().factories.put(city, f);
	}
	
	public List<String> getFactories(){
		
		return getInstance().factories.keySet().stream().collect(toList());
	}
	
	
	public void setProductionLines(String city, String...prodlines) throws BrandException {
		if(getFactory(city) == null) {
			throw new BrandException();
		}
		for(String s : prodlines) {
			getFactory(city).addProductionLine(s);
		}			
	}
	
	public Map<Integer, Integer> estimateYearlyProduction(String city){
		
		Factory f = getFactory(city);
			f.getProductionLines().values().stream()
				.collect(toMap(
						ProductionLine::getMotorization,
						ProductionLine::getCapacity, 
						(a,b) -> a+b,
						TreeMap::new));
				
				
	return null;			
	}
				
	
	
	public void buildStorage(String city, int capacity) throws BrandException {
		
		if(getWarehouse(city) != null) {
			throw new BrandException();
		}
		
		if(capacity <= 0) {
			throw new BrandException();
		}
		
		Warehouse w = new Warehouse(city, capacity);
		
	}
	
	
	public void storeCar(String warehouseName, String carModel) throws BrandException {
		if(getWarehouse(warehouseName) == null) {
			throw new BrandException();
		}
		
		Warehouse w = getWarehouse(warehouseName);
		Car c = getCar(carModel);
		w.storeCar(c);
	}
	
	
	public void removeCar(String warehouseName, String carModel) throws BrandException {
		if(getWarehouse(warehouseName) == null) {
			throw new BrandException();
		}
		
		Warehouse w = getWarehouse(warehouseName);
		if(w.storesCar(carModel) == null) {
			throw new BrandException();
		}
		
		w.removeCar(carModel);
		
	}
		
	public List<String> getStorageList() {
		return getInstance().warehouses.keySet().stream().collect(toList());
		
	}
	
	
	public Map<String, Integer> getStorageSummary(String name){
		
		if(getWarehouse(name) == null) {
			throw new BrandException();
		}
		
		Warehouse w = getWarehouse(name);
		
		Map<String, Long> tmp =  w.getCarsStored().stream().collect(groupingBy(Car::getModel,
				counting()));
		
		
		Map<String,Integer> res;
		for(Entry<String, Long> e : tmp.entrySet()) {
			Long l  = e.getValue();
			res.put(e.getKey(), l.intValue());
		}
		
		return res;
	}

//
//		// R4
//		fiat.setISThresholds(10, 100);
//		List<String> l = fiat.getModelsSustainability(1);
//		assertEquals("[FCA003]",l.toString());
//		
//		float sust = fiat.getCarMakerSustainability();
//		assertEquals(2.8,sust,0.1);
//		
//		// R5
//		boolean success = fiat.plan("FCA002:14,FCA001:5");
//		assertTrue(success);
//		
//		assertEquals(10,fiat.getLineCapacity("Torino", "l1"));
//		
//		// R6
//		assertEquals (0.20,fiat.linesfullyAllocated(),0.01);
//		assertEquals (0.40,fiat.unusuedLines(),0.01);
//	}

}
{
	
}