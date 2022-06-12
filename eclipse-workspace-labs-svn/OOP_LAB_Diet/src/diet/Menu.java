package diet;

/**
 * Represents a complete menu.
 * 
 * It can be made up of both packaged products and servings of given recipes.
 *
 */
public class Menu implements NutritionalElement {
	
	private String name;
	private Food food;
	
	private double calories = 0.0;
	private double proteins = 0.0;
	private double carbs = 0.0;
	private double fat = 0.0;
	
	public Menu(String name, Food food) {
		this.name = name;
		this.food = food;
	}
	
	
	public Menu addRecipe(String recipe, double quantity) {
		NutritionalElement ric = food.getRecipe(recipe);
		
		calories += ric.getCalories(quantity);
		proteins += ric.getProteins(quantity);
		carbs += ric.getCarbs(quantity);
		fat += ric.getFat(quantity);
		
		return this;
	}

	public Menu addProduct(String product) {
		NutritionalElement p = food.getProduct(product);

		calories += p.getCalories();
		proteins += p.getProteins();
		carbs += p.getCarbs();
		fat += p.getFat();
		
		return this;
	}

	@Override
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
		return false;
	}
}
