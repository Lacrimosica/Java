import java.util.stream.Stream;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.Comparator.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TestApp {
	
	
	public static void main(String[] args) {
		
		
		List<String> words = Arrays.asList("foo", "bar", "alice", "bob" , "jane", "baz", "gargle", "foobar", "whirl");
//	
//		System.out.println(	words.stream().collect(groupingBy(String::length)));
//		System.out.println(	words.stream().collect(
//				groupingBy(String::length , 
//					() -> new TreeMap<>(reverseOrder()) , toList())));
//		
//		System.out.println(	words.stream().collect(
//				groupingBy(String::length , 
//						TreeMap::new , toList() ) ) );			//alternative use of the supplier 
//																//when we don't have parameters to give it
//		

	
		System.out.println(words.stream().collect(
				collectingAndThen(groupingBy(String::length, 
								() -> new TreeMap<>(reverseOrder()) , toList()), //end of the groupingBys
								
						//now that we have created the treemap
								m -> m.entrySet().stream().limit(3).flatMap(e -> e.getValue().stream())
								.collect(toList()))));
	
		
		System.out.println(words.stream().distinct().sorted(Comparator.comparing(String::length).reversed()).limit(3).collect(toList()));
	
	
	
	}

}
