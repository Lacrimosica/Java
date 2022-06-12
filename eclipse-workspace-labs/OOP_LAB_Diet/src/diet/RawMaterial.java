package diet;

public class RawMaterial implements NutritionalElement{
	double calories,proteins, carbs, fat;
	double quantity;
	
	String name;
	
	public RawMaterial(String name, double calories,
					double proteins, double carbs, double fat){
		
		this.name = name;
		this.calories = calories;
		this.proteins = proteins;
		this.carbs = carbs;
		this.fat = fat;
		
		System.out.println("Raw Material defined " + this.getName());
	}
	
	public String getName() {
		return name;
	}

	@Override
	public double getCalories() {
		return calories;
	}

	@Override
	public double getProteins() {
		return proteins;
	}

	@Override
	public double getCarbs() {
		return carbs;
	}

	@Override
	public double getFat() {
		return fat;
	}

	@Override
	public boolean per100g() {
		return true;
	}
}
