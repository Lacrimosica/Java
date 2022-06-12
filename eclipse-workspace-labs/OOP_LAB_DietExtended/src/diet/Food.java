package diet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Food {
	
	private SortedMap<String, NutritionalElement> products = new TreeMap<String, NutritionalElement>();
	private SortedMap<String, NutritionalElement> rawMats = new TreeMap<String, NutritionalElement>();
	private SortedMap<String , NutritionalElement> recipes = new TreeMap<String, NutritionalElement>();
	
	
	
	public void defineRawMaterial(String name, double calories, double proteins, double carbs, double fat){
		RawMaterial rm = new RawMaterial(name, calories,proteins,carbs, fat);
		rawMats.put(name, rm);
	}

	public Collection<NutritionalElement> rawMaterials(){
		return rawMats.values();
	}

	public NutritionalElement getRawMaterial(String name){
		return rawMats.get(name);
	}

	public void defineProduct(String name,double calories,double proteins,double carbs,double fat){
		
		Product p = new Product(name, calories,proteins,carbs, fat);
		products.put(name , p);
		
	}
	
	public Collection<NutritionalElement> products(){	
		return products.values();
	}

	public NutritionalElement getProduct(String name){
		return products.get(name);
	}

	public Recipe createRecipe(String name) {
		Recipe recipe = new Recipe(name, this);
		recipes.put(name, recipe);
		return recipe;
	}

	public Collection<NutritionalElement> recipes(){
		return recipes.values();
	}

	public NutritionalElement getRecipe(String name){		
		return recipes.get(name);
	
	}
	
	public Menu createMenu(String name) {	
		return new Menu(name, this);
	}


}
