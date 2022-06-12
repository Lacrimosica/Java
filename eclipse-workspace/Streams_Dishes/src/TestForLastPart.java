import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestForLastPart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Stream.iterate(0, n -> n+2)
		.limit(10)
		.forEach(System.out::println);
	
		System.out.println("-----series of fibonacci tuples--------");
		
		Stream.iterate(new int[]{0, 1}, t-> new int[] {t[1], t[0] + t[1]})
		.limit(20)
		.forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
	
	
	
		System.out.println("normal fibonacci series");
		
		Stream.iterate(new int[]{0, 1}, t-> new int[] {t[1], t[0] + t[1]})
		.limit(20)
		.forEach(t -> System.out.println("(" + t[0] +")"));
	
		//iteration with predicate
		
		System.out.println("squares of numbers that are lowe than 100");
		Stream.iterate(0, n -> n < 100, n -> n+4).forEach(System.out::println);
	
		
		
		
		//GENERATE
		
		//stateless supplier that is random
		//generate uses a Supplier<T>
		Stream.generate(Math::random)
		.limit(5)
		.forEach(System.out::println);
		
		
		//creating an infinte stream of ones
		
		IntStream ones = IntStream.generate( () -> 1);
	
		
		//inline supplier method
		
		
		IntStream tows = IntStream.generate(new IntSupplier() {
			public int getAsInt() {
				return 2;
			}
		});
	
	
		IntSupplier fib = 
				
		(new IntSupplier() {
			private int previous =0;
			private int current =1;
			
			public int getAsInt() {
				int oldPrevious = this.previous;
				int nextValue = this.previous + this.current;
				this.previous = this.current;
				this.current = nextValue;
				
				return oldPrevious;
			}
			
		});
	
		IntStream.generate(fib).limit(10).forEach(System.out::println);
	
	
	
	}}
