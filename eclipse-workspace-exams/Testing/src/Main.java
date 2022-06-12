import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Map<String, Integer> map =  new HashMap<>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);
		map.put("e", 5);
		map.put("a", 2);
		
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		
		int sum = map.values().stream().reduce(0, Integer::sum);
//		int sum2 = map.entrySet().stream().filter( k -> k.equals("a"))
//				.map()
//				.reduce(0 , )
		
		int sum3 = entries.stream().filter(e -> "a".equals(e.getValue())).map( e -> e.getValue()).reduce(0, Integer::sum);
		
		List<String> keys = entries.stream().map(e -> e.getKey()).collect(Collectors.toList());
		System.out.println(keys);
		System.out.println(sum);
	}

}	
