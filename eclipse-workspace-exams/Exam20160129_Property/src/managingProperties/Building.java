package managingProperties;

public class Building {

	private String bId;
	private int numberOfApartments;
	private int paidCharges;
	
	
	public Building(String id, int n) {
		this.bId = id;
		this.numberOfApartments = n;
	}
	
	
	public void addToCharges(int amount) {
		this.paidCharges += amount;
	}
	
	public int getPaidCharges() {
		return this.paidCharges;
	}
	
	public String getBId() {
		return this.bId;
	}
	
	public int getNumberOfApartments() {
		return this.numberOfApartments;
	}
}
