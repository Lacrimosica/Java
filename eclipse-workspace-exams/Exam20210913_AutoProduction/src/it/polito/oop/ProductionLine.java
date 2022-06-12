package it.polito.oop;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class ProductionLine {
	private String name;
	private int capacity;
	private int motorization;

	public String getName() {
		return name;
	}
	public int getCapacity() {
		return capacity;
	}

	public int getMotorization() {
		return motorization;
	}


	public ProductionLine(String name, int capacity, int motorization) {
	
		this.name = name;
		this.capacity = capacity;
		this.motorization = motorization;
	}
	
	
	
	
	
	
}
