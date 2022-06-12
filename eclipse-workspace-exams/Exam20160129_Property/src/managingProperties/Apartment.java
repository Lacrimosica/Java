package managingProperties;

public class Apartment {
	
	private String building;
	private int number;
	String AId;
	
	public Apartment(String Id) {
		this.AId = Id;
		String[] info = Id.split(":");
		this.building = info[0];
		this.number = Integer.parseInt(info[1]);
	}
	
	public String getBuilding() {
		return this.building;
	
	}
	public int getNumber() {
		return this.number;
	}
	public String toString() {
		return building+":"+ number;
	}
}
