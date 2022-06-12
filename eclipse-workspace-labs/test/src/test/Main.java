package test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=4;
		Map<Integer, String> testing = new LinkedHashMap<>();
		
		testing.put(0, "a");
		testing.put(1, "a");
		testing.put(2, "b");
		testing.put(3, "c");
		testing.put(4, "d");
		testing.put(5, "e");
		
		
		for(int i=0 ; i< n ;i++) {
			System.out.println(testing.get(i));
		}
	}

}
