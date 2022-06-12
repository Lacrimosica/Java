package it.polito.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Warehouse {
	private String name;
	private int capacity;
	private int numberOfStroedCars;
	private Map<String, Car> carsStored;
	
	public Warehouse(String name, int capacity) {
		carsStored = new TreeMap<>();
		this.name = name; 
		this.capacity = capacity;
		this.numberOfStroedCars = 0;
	}
	
	
	public List<Car> getCarsStored(){
		return new ArrayList<>(this.carsStored.values());
	}
	
	public void storeCar(Car car) {
		if(capacity - numberOfStroedCars > 0) {
			carsStored.put(car.getModel(), car);
			numberOfStroedCars++;			
		}
	}
	
	public Car storesCar(String model) {
		if(carsStored.containsKey(model)) {
			return carsStored.get(model);
		}
		return null;
	}
	
	public void removeCar(String model) {
		carsStored.remove(model);
		numberOfStroedCars--;
	}
	
}
