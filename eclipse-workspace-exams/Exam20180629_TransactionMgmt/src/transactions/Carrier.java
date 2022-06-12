package transactions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class Carrier {
	private Set<String> regions;
	private String name;
	
	
	public Carrier(String name) {
		regions = new TreeSet<>();
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public Set<String> getRegions() {
		return regions;
	}

	public List<String> addRegions(String[] s){
		for(String r: s) {
			
			if(checkRegion(r)) {
//				TransactionManager.getInstance().getRegion(r).addCarrier(this.getName());
				regions.add(r);
//				System.out.println("now adding region: " + r + " to carrier : " + this.getName());
			}
		}
		
		return new ArrayList<>(regions);
	}
	
	
	public boolean checkRegion(String r) {
		return TransactionManager.getInstance().regions.keySet().contains(r);
	}
	
	

}
