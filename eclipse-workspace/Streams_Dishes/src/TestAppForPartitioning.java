import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;


import it.polito.oop.*;

public class TestAppForPartitioning {
	public static void main(String[] args) {
		
		
		List<Dish> menu = Arrays.asList(new Dish("meat loaf", false, 100 , Type.MEAT),
				new Dish("chiken", false, 200, Type.MEAT),
				new Dish("rice", true, 20, Type.OTHER),
				new Dish("salmon", true, 300, Type.FISH),
				new Dish("French Fries", false, 500, Type.OTHER),
				new Dish("brownie", false, 401, Type.OTHER));
		
		
		
		
		Map< Boolean, List<Dish>> partitionedMenu = 
				menu.stream()
				.collect(partitioningBy(Dish::isVegetarian));
		
		System.out.println(partitionedMenu);
		
		
		//to get veggy ones only
		
		List<Dish> vegies = partitionedMenu.get(true);
		

	}
}
