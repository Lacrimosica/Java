package it.polito.oop;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


import static java.util.stream.Collectors.*;

public class Factory {
	private String city;
	private SortedMap<String, ProductionLine> productionLines;
	private SortedMap<Integer, Integer> production;
	
	
	
	public Factory(String city) {
//		productionLines = new TreeMap<>();
		production = new TreeMap<>();
		this.city = city;
	}

	
	public SortedMap<String, ProductionLine> getProductionLines() {
		return productionLines;
	}


	public void setProductionLines(SortedMap<String, ProductionLine> productionLines) {
		this.productionLines = productionLines;
	}


	public void addProductionLine(String line) throws BrandException{
		
		String[] comps = line.split(":");
		
		String name = comps[0];
		int cap = Integer.parseInt(comps[1]);
		int mot = Integer.parseInt(comps[2]);
		
		if(cap <= 0 ) {
			throw new BrandException();
		}
		
		if(mot < 0 || mot >4) {
			throw new BrandException();
		}
		
		if(productionLines.containsKey(name)) {
			productionLines.replace(name, new ProductionLine(name, cap, mot));
		}
		productionLines.put(name, new ProductionLine(name, cap, mot));
	}
	
	
}
