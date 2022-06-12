package diet;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;

public class Recipe implements NutritionalElement {
   String name;
   private Food food;
   
   private double weight = 0.0;
   private double calories = 0.0;
   private double proteins = 0.0;
   private double carbs = 0.0;
   private double fat = 0.0;
	
	
   private static boolean PERCENT =true;
   
   private List<Ingredient> ingredients = new LinkedList<Ingredient>();
   
   //inner class?
   private static class Ingredient {
	   final NutritionalElement nutriElem;
	   final double quantt;
	   
	   Ingredient(NutritionalElement e, double q){
		   this.nutriElem = e;
		   this.quantt = q;
	   }
   }
   
   public Recipe(String name, Food food) {
	   this.name = name;
	   this.food = food;
   }
   
	public Recipe addIngredient(String material, double quantity) {
		
			NutritionalElement e = (NutritionalElement) food.getRawMaterial(material);
			Ingredient ing = new Ingredient(e , quantity);
			
			ingredients.add(ing);
			weight += quantity;
			
			if(PERCENT) {
				calories+=e.getCalories()/100*quantity;
				proteins+=e.getProteins()/100*quantity;
				carbs+=e.getCarbs()/100*quantity;
				fat+=e.getFat()/100*quantity;
			}
			return this;
	}

	private double compute(BiFunction<NutritionalElement, Double, Double> extractor) {
		double result = 0.0;
		for(Ingredient i : ingredients) {
			result+= extractor.apply(i.nutriElem, i.quantt);
		}
		return result *100/ weight;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getCalories() {
		if(!PERCENT) {
			return compute(NutritionalElement::getCalories);
		}else {
			return calories/ weight * 100;
			
		}
	}

	@Override
	public double getProteins() {
		if(!PERCENT) {
			return compute(NutritionalElement::getProteins);
		}else {
			return proteins/ weight * 100;
		}
	}

	@Override
	public double getCarbs() {
		if(!PERCENT) {
			return compute(NutritionalElement::getCarbs);
		}else {
			return carbs/ weight * 100;
		}
	}

	@Override
	public double getFat() {
		if(!PERCENT) {
			return compute(NutritionalElement::getFat);
		}else {
			return fat/ weight * 100;
		}
	}
	
	@Override
	public boolean per100g() {
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
			for(Ingredient i : ingredients) {
			sb.append(i.nutriElem.getName()).append(" : ").append(i.quantt).append('\n');
		}
			
		return sb.toString();
	}
}
