package diet;

/**
 * Represents a recipe of the diet.
 * 
 * A recipe consists of a a set of ingredients that are given amounts of raw materials.
 * The overall nutritional values of a recipe can be computed
 * on the basis of the ingredients' values and are expressed per 100g
 * 
 *
 */
public class Recipe implements NutritionalElement {
	private String name;
	private Food food;
//	private LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
//	private class Ingredient {
//		NutritionalElement en;
//		double qty;
//	}

	
	private double calories = 0.0;
	private double proteins = 0.0;
	private double carbs = 0.0;
	private double fat = 0.0;
	private double weight = 0.0;


	Recipe(String name, Food food) {
		this.name = name;
		this.food = food;
	}

	/**
	 * Adds a given quantity of an ingredient to the recipe.
	 * The ingredient is a raw material.
	 * 
	 * @param material the name of the raw material to be used as ingredient
	 * @param quantity the amount in grams of the raw material to be used
	 * @return the same Recipe object, it allows method chaining.
	 */
	public Recipe addIngredient(String material, double quantity) {
//		Ingredient ing = new Ingredient();
//		ing.qty = quantity;
//		ing.en = food.getRawMaterial(material);
//		ingredients.add(ing)

		NutritionalElement en = food.getRawMaterial(material);
		//RawMaterial rm = (RawMaterial) food.getRawMaterial(material);
		
		//calories += rm.getCalories() / 100 * quantity;
		calories += en.getCalories(quantity);
		proteins += en.getProteins(quantity);
		carbs += en.getCarbs(quantity);
		fat += en.getFat(quantity);
		weight += quantity;

		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getCalories() {
		return calories * 100 / weight;
	}

	@Override
	public double getProteins() {
		return proteins * 100 / weight;
	}

	@Override
	public double getCarbs() {
		return carbs * 100 / weight;
	}

	@Override
	public double getFat() {
		return fat * 100 / weight;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Recipe} class it must always return {@code true}:
	 * a recipe expressed nutritional values per 100g
	 * 
	 * @return boolean indicator
	 */
	@Override
	public boolean per100g() {
		return true;
	}

}