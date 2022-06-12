import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		Map<String, List<String>> idk = Stream.of("string 1" , "spam", "eggs" , "idkidk" , "this is to repeat" , "this is to repeat")
				.distinct()
				.collect(groupingBy( (x) -> x));
		
		
		System.out.println(idk);
	}

}
