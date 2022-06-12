package diet;

public class Product implements NutritionalElement{
	double calories,proteins, carbs, fat;
	double total;
	double quantity;
	String name;
	
	public Product(String name, double calories, double proteins, 
					double carbs, double fat){
		this.name = name;
		this.calories = calories;
		this.proteins = proteins;
		this.carbs = carbs;
		this.fat = fat;
		this.total = calories + proteins + carbs + fat;
		System.out.println("new product defined " + this.getName());
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public double getCalories() {
		// TODO Auto-generated method stub
		return calories;
	}

	@Override
	public double getProteins() {
		// TODO Auto-generated method stub
		return proteins;
	}

	@Override
	public double getCarbs() {
		// TODO Auto-generated method stub
		return carbs;
	}

	@Override
	public double getFat() {
		// TODO Auto-generated method stub
		return fat;
	}

	@Override
	public boolean per100g() {
		// TODO Auto-generated method stub
		return false;
	}
}
