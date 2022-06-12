package it.polito.oop;

public class Dish {
	private final String name;
	private final int calories;
	private final boolean veg;
	private final Type type;
	
	
	public Dish(String name,  boolean veg, int calories,Type type) {
		this.calories = calories;
		this.name = name;
		this.veg = veg;
		this.type = type;
	}

	public int getCalories() {
		return this.calories;
	}
	
	public String getName() {
		return this.name;	
		}
	
	public boolean isVegetarian() {
		 return veg;
	}
	
	public Type getType() {
		return type;
	}
	
	@Override
	public String toString() {
//		return "Dish [name=" + name + ", calories=" + calories + ", vegetartion=" + veg + ", type=" + type + "]";
		return name;
		}
	
	
	public String toString(int i) {
		return name;
	}

	
	
	
}
