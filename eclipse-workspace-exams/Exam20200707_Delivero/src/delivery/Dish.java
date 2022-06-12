package delivery;

public class Dish implements Comparable<Dish>{
	private String name;
	private float price;
	
	
	
	
	
	public Dish(String name, float price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return this.name;
		
	}
	
	public float getPrice() {
		return price;
	}
	@Override
	public int compareTo(Dish d) {
		// TODO Auto-generated method stub
		return name.compareTo(d.getName());
	}
}
