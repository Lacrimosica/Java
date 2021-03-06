package phoneNumberGenerator;

import java.util.Arrays;

public class Main {
	
	private static String PHONE_FORMAT = "(%d%d%d) %d%d%d-%d%d%d%d";
	
	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,5,6,7,8,9,0};
		System.out.println(createPhoneNumber(numbers));
		System.out.println(createPhoneNumberv2(numbers));

	}
	
	 public static String createPhoneNumber(int[] numbers) {
		    return String.format("(%d%d%d) %d%d%d-%d%d%d%d", numbers[0],numbers[1],numbers[2],numbers[3]
		    		,numbers[4],numbers[5],numbers[6],numbers[7], numbers[8], numbers[9]);
		  }
	 
	 public static String createPhoneNumberv2(int[] numbers) {
		 return String.format("(%d%d%d) %d%d%d-%d%d%d%d", java.util.stream.IntStream.of(numbers)
				 .boxed()
				 .toArray());
	 }
	 
	 
	 public static String createPhoneNumberv3(int[] numbers) {
		    String phoneNumber = new String("(xxx) xxx-xxxx");
		    
		    for (int i : numbers) {
		      phoneNumber = phoneNumber.replaceFirst("x", Integer.toString(i));
		    }
		    
		    return phoneNumber;
		  }
	 
	 
	 public static String createPhoneNumberv4(int[] numbers) {
	        Integer[] numbersInt = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
	        return String.format(PHONE_FORMAT, numbersInt);
	    }
	 
}
