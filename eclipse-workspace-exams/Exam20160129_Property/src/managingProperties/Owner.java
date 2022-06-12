package managingProperties;

import java.util.HashMap;
import java.util.Map;

public class Owner {
	private String OId; 
	private Map<String, Apartment> apartments;
	private int paidCharges;
	
	
	
	public Owner(String id) {
		this.OId = id;
		apartments = new HashMap<>();
		this.paidCharges = 0;
	}
	
	public void addToCharges(int amount) {
		this.paidCharges+=amount;
	}
	
	public int getPaidChares() {
		return this.paidCharges;
	}
	
	public String getOId() {
		return this.OId;
	}
	public boolean addApartments(String apartment) throws PropertyException{
		
			Apartment a = new Apartment (apartment);
			
			if(PropertyManager.getInstance().getBuilding(a.getBuilding()) == null) {
				throw new PropertyException("building doesn't exist");
			}
			
			if(PropertyManager.getInstance().getBuilding(a.getBuilding()).getNumberOfApartments() < a.getNumber()) {
				throw new PropertyException("apartment number invalid");
			}
			
			if(PropertyManager.getInstance().getOwnerOf(apartment) != null) {
				throw new PropertyException("apartment already has an owner");
			}
			
			apartments.put(apartment, a);
			
			return true;
	}

	@Override
	public String toString() {
		return "Owner [OId=" + OId + ", apartments=" + apartments + ", paidCharges=" + paidCharges + "]";
	}
	
	
	
}