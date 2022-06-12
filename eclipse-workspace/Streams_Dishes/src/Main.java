import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import it.polito.oop.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Dish> menu = Arrays.asList(new Dish("meat loaf", false, 100 , Type.MEAT),
				new Dish("rice", true, 20, Type.OTHER),
				new Dish("salmon", true, 300, Type.FISH),
				new Dish("French Fries", false, 500, Type.OTHER),
				new Dish("brownie", false, 401, Type.OTHER));
		
		
		//using accumulator, gets low caloric dishes as object dish
		List<Dish> lowCaloricDishes = new ArrayList<>();
		for(Dish dish : menu) {
			if(dish.getCalories() < 400) {
				lowCaloricDishes.add(dish);
			}
		}
		
		//using anonymous class , sort the list by the int caloeris
		Collections.sort(lowCaloricDishes, new Comparator<Dish> () {
			public int compare(Dish dish1, Dish dish2) {
				return Integer.compare(dish1.getCalories(), dish2.getCalories());
			}
		});
		
		//go through the sorted list and copy the names into the new list of names
		List<String> lowCaloricDishesNames = new ArrayList<String>();
		for(Dish dish : lowCaloricDishes) {
			lowCaloricDishesNames.add(dish.getName());
		}
	
	
		//how it's done after java 8
		
		List<String> highCaloricDishesNames = new ArrayList<>();
		highCaloricDishesNames = 
				menu.stream().filter(d -> d.getCalories() > 400).   //using lambda functions with inference
				sorted(comparing(Dish::getCalories)).	//using method referencing
				map(Dish::getName).
				limit(2).	
				collect(toList());
		
		for(String s: highCaloricDishesNames) {
			System.out.println(s);
		}
					//to exploit multicore architecture you use:
		//menu.parallelStream();
		
		
		
		
		if(menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("menu is somewhat vegetarian friendly");
		}
		
		if(menu.stream().allMatch(Dish::isVegetarian)) {
			System.out.println("menu is completely vegetarian");
		}
	
		
		//findany
		
		
		Optional<Dish> vegdishes = 
				menu.stream()
				.filter(dish -> dish.getCalories() >100)
				.findFirst();
		System.out.println("---------------");		
		System.out.println(vegdishes);
		
		
		
		//here we first turn the Dish list into a primitive int stream
		//and in the second line we turn it into an Integer Stream using boxed();
		IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
		Stream<Integer> stream = intStream.boxed();

				
				
				
		OptionalInt maxCalories  = menu.stream()
				.mapToInt(Dish::getCalories)
				.max();
		
		
		//if the optional values is empy instead of it we are going to put 1
		//this is done with orElse
		int max = maxCalories.orElse(1);
		
		
		
	}}
