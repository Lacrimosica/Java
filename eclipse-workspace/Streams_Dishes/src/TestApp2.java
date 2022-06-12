import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

public class TestApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = Arrays.asList(1,2,5,6,8,7,9,2,4,5,65,2,4,42);
		List<Integer> squares = 
				nums.stream().
				map( i -> i*i).
				filter(i -> (i<4000) && (i%2 ==0)).
				collect(toList());
	
		
		List<Integer> numbers1 = Arrays.asList(1,2,3);
		List<Integer> numbers2 = Arrays.asList(3,4);
		
		List<int []> pairs = 
				numbers1.stream()
				.flatMap(i -> numbers2.stream().map(j -> new int[]{i,j} )
						)
				.collect(toList());
//		System.out.println(pairs);
		
		
		String[] arrayOfWords = {"hello", "world"};
		Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
		
		Stream<String> s = Stream.of("another" , "salute", "to this", "worlds");
		
		s.map(word -> word.split("")).map(Arrays::stream).distinct().collect(toList());
		
		System.out.println();
		
		
	}
	
	
	
	
}
