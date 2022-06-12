import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestAppforRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		IntStream evenNumbers = IntStream.rangeClosed(1, 100)
				.filter(i -> i%2 ==0);
		
		
		System.out.println(evenNumbers.count());
		
		
		
		
		//generating pythagorean triples
		
		
		
		Stream<int[]> pythagoreanTriplesinit = 
					IntStream.rangeClosed(1, 200).boxed()
					.flatMap(a -> 
								IntStream.rangeClosed(a, 200)
								.filter(b -> Math.sqrt(a*a + b*b)%1 == 0)
						//you call this to generate a Stream<Integer> from the IntStream
								//if you omit the boxed() above, you can use instead MapToObj
								.boxed()
								.map(b -> new int[] {a,b, (int) Math.sqrt(a*a + b*b)}));
							//or use mapToObj which return object type 
		
	
	
//		Stream<int[]> pythagoreanTriples =
//				IntStream.rangeClosed(1, 100).boxed()
//				.flatMap(a ->
//				IntStream.rangeClosed(a, 100)
//				.filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
//				.mapToObj(b ->
//				new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
//				);
//		
		pythagoreanTriplesinit.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1]  + ", " + t[2]));
	
		
		
		//another solution
		
		
		Stream<double[]> pythagoreantriples2 =
				IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100).
						mapToObj(b -> new double[] {a,b, Math.sqrt(a*a + b*b)})
						.filter(t -> t[2] % 1 == 0));
				
		
		//Streams from arrays
		
		int[] numbers = {2,3,5,8,7,9};
		int sum = Arrays.stream(numbers).sum();
		
		
		
	}}
