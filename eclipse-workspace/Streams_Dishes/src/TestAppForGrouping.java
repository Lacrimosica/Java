import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.Comparator.*;

import static java.util.stream.Collectors.*;


import it.polito.oop.*;

public class TestAppForGrouping {

	public static void main(String[] args) {
		
		List<Dish> menu = Arrays.asList(new Dish("meat loaf", false, 100 , Type.MEAT),
				new Dish("chiken", false, 200, Type.MEAT),
				new Dish("rice", true, 20, Type.OTHER),
				new Dish("salmon", true, 300, Type.FISH),
				new Dish("French Fries", false, 500, Type.OTHER),
				new Dish("brownie", false, 401, Type.OTHER));
		
		//collecting data in subgroups
		
		Map <Type, Long> typesCount = menu.stream()
				.collect(groupingBy(Dish::getType, counting()));
		
		
		System.out.println(typesCount);
		
		
		
		Map<Type, Optional<Dish>> mostCaloricByType = 
				menu.stream()
				.collect(groupingBy(Dish::getType , maxBy(comparingInt(Dish::getCalories))));
		
		System.out.println(mostCaloricByType);
		
		
		
		//using optional properly
		
		
		Map<Type, Dish> mostCaloricByType2 = 
				menu.stream()
				.collect(groupingBy(Dish::getType, collectingAndThen(
						maxBy(comparingInt(Dish::getCalories)),
						Optional::get)));
		System.out.println(mostCaloricByType);
		
		
		
		Map<Type, Integer> totalCaloriesByType = 
				menu.stream()
				.collect(groupingBy(Dish::getType,
						summingInt(Dish::getCalories)));
		
		
		System.out.println(totalCaloriesByType);
		
		
		
		
		
		Map<Type, Set<CaloricLevel>> caloricLevelsByType =
				menu.stream()
				.collect(groupingBy(Dish::getType,
						mapping(dish -> {
							if(dish.getCalories() <= 400) return CaloricLevel.DIET;
							else if(dish.getCalories() <=700) return CaloricLevel.NORMAL;
							else return CaloricLevel.FAT;
						}, toSet()
						)));
				
				
				System.out.println(caloricLevelsByType);
				
				
				
				
				//constructing a HashSet
				
				Map<Type, Set<CaloricLevel>> CaloricLevelByTypeH = 
						menu.stream()
						.collect(groupingBy(Dish::getType, 
							mapping(dish -> {
							if(dish.getCalories() <= 400) return CaloricLevel.DIET;
							else if(dish.getCalories() <=700) return CaloricLevel.NORMAL;
							else return CaloricLevel.FAT; }
							,toCollection(HashSet::new) )));
				
				
				System.out.println("cal l b t h");
				System.out.println(CaloricLevelByTypeH);
	}

}
