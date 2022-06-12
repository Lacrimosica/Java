package it.polito.oop;
import java.util.List;

import java.util.ArrayList;

public class Apple{
	int weight;
	Color color;
	
	public Apple(int w, Color c) {
		this.weight = w;
		this.color = c;
	}
	
	
	public int getWeight() {
		return weight;
	}

	
	public Color getColor() {
		return color;
	}


	public static List<Apple> filterApples(List<Apple> inventory,
			ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple:inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
		for(Apple apple : inventory) {
			String output = formatter.accept(apple);
			System.out.println(output);
		}
	}

}
