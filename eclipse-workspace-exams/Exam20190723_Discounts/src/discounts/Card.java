package discounts;

public class Card {
	private String name;
	private int id;
	
	public Card(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
}
