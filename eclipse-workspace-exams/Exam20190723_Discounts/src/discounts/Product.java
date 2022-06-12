package discounts;

public class Product {
	private String category;
	private String code;
	private double price;
	private int discount ;
	private boolean isDiscounted;
	
	
	public Product(String category , String code, double price) {
		this.category = category;
		this.code = code;
		this.price = price;
		this.discount = 0;
		this.isDiscounted = false;
		
	}
	
	
	public boolean isDiscounted() {
		return isDiscounted;
	}


	public void setDiscounted(boolean isDiscounted) {
		this.isDiscounted = isDiscounted;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
	}


	public String getCategory() {
		return category;
	}
	public String getCode() {
		return code;
	}
	public double getPrice() {
		return price;
	}
	public int getDiscount() {
		return discount;
	}
	
	public void applyDiscount(String cat, int percentage) {
		if(this.category.equals(cat) ) {
			this.isDiscounted = true;
			this.discount = percentage;			
		}
	}
	
	public boolean discounted() {
		return isDiscounted;
	}
	
	
	
}
