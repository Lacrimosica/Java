package delivery;

public class Food {
	private String category;
	private double price;
	private String description;
	private int prepTime;
	
	
	
	public Food(String category, 
			double price, 
			String description, 
			int prepTime) {
		
		
		this.category = category;
		this.price = price;
		this.description = description;
		this.prepTime = prepTime;
	}
	
	
	public void setCategory(String name) {
		this.category = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}
	public String getCategory() {
		return category;
	}
	public double getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}
	public int getPrepTime() {
		return prepTime;
	}
}
