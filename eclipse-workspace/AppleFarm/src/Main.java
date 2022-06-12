import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.lang.Runnable;



import it.polito.oop.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//methods to make the inventory
		//method 1
		
//		Apple a = new Apple(110, Color.GREEN);
//		Apple b = new Apple(130, Color.RED);
//		Apple c = new Apple(200 , Color.GREEN);
		
//		inventory.add(a);
//		inventory.add(b);
//		inventory.add(c);
		
//		List<Apple> inventory = new ArrayList<Apple>();
		
		//method 2
		List<Apple> inventory = Arrays.asList(new Apple(110, Color.GREEN),
											new Apple(130, Color.RED),
											new Apple(200 , Color.GREEN),
											new Apple(100, Color.RED),
											new Apple(300, Color.GREEN),
											new Apple(200, Color.RED));
		
		List<Apple> greenApples = new ArrayList<Apple>();
		List<Apple> heavyApples = new ArrayList<Apple>();
		
		
		//end of method 2
	
		System.out.println("---------------Fancy Format for inventory------------");
		
		Apple.prettyPrintApple(inventory, new AppleFancyFormatter());
		
		System.out.println("---------------Simple format for inventory-----------");
		
		Apple.prettyPrintApple(inventory, new AppleSimpleFormatter());
		
		greenApples = Apple.filterApples(inventory, new AppleGreenColorPredicate());
		heavyApples = Apple.filterApples(inventory, new AppleHeavyWeightPredicate());
		
		System.out.println("---------------green apples fancy fomrat------------");
		
		Apple.prettyPrintApple(greenApples,  new AppleFancyFormatter());
		
		System.out.println("------------------Anonymous Classes------------------");
		
		
		//Anonymous classes
		List<Apple> redApples = Apple.filterApples(inventory, new ApplePredicate(){
			public boolean test(Apple apple) {
				return Color.RED.equals(apple.getColor());
			}
		});
	
		Apple.prettyPrintApple(redApples,  new AppleFancyFormatter());
		
		
		
		//lambda expressions
		List<Apple> result = Apple.filterApples(inventory, (Apple apple) -> Color.RED.equals(apple.getColor() ) );
		
		System.out.println("------------------lambda expressions---red apples------");
		Apple.prettyPrintApple(result, new AppleFancyFormatter() );
		
		List<Apple> heavyGreenApples = Apple.filterApples(inventory, (Apple apple) -> (Color.GREEN.equals(apple.getColor() ) && 
																					apple.getWeight() > 150 ) );
		
		System.out.println("------------------lambda expressions---green heavy apples------");
		Apple.prettyPrintApple(heavyGreenApples, new AppleFancyFormatter() );
		
		
		//abstraction over list type
		
		
		List<Apple> yellowApples =
				Filter.filter(inventory, (Apple apple) -> Color.YELLOW.equals(apple.getColor()));
		//the fact that Apple class needs to be present would make this not the best way to do it
		//so a separate filtering class should be made about it
		
		@SuppressWarnings("deprecation")
		List<Integer> numbers= Arrays.asList(new Integer(3),
									new Integer(4),
									new Integer(6),
									new Integer(42));
		
		List<Integer> evenNumbers = 
				Filter.filter(numbers, (Integer i) -> i%2 == 0) ;
		
		System.out.println("----------abstraction of Integer printing test");
		
//		System.out.println(Printer.print(evenNumbers));
		System.out.println(evenNumbers.toString());
		
		
		//using comparator
		//imported above java.util.Compaartor
	
		
		inventory.sort(new Comparator<Apple>() {
			public int compare(Apple a1, Apple a2) {
				return Integer.compare(a1.getWeight(), a2.getWeight());
			}
		});
	
		//using lambda functions
		
		inventory.sort( (Apple a1, Apple a2) -> Integer.compare(a1.getWeight(), a2.getWeight()));
		
	
	
	
		//Runnable
		//imported above java.lang.Runnable
		//it's only method is:
		//void run();
		
		
		Thread t =  new Thread(new Runnable() {	//implementing the interface in anonymous mode i guess?
				public void run() {	//Ovverriding the method
					System.out.println("Hello world");
				}
		});
		
		
		//using lambda expression for threads:
		
		Thread t2 = new Thread( () -> System.out.println("Hello world") );
	
		
		
		
		
	}
}
