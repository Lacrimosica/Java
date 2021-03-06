package primeNumber;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import static java.util.Optional.*;

public class Prime {

	public static void main(String[] args) {
		System.out.println(isPrime(6));
		
	}
	
	
	public static boolean isPrime(int num) {
		if(num <= 1) return false;
		int lim = (int) Math.sqrt(num);
		System.out.println(lim);
		OptionalInt f = IntStream.iterate(2, i -> i+1).limit(lim).filter(i -> num % i !=0).findFirst();
		System.out.println(f.getAsInt());
		return f.isEmpty();
	}

	public static boolean isPrimev3(int num) {
	    return num > 1 && java.math.BigInteger.valueOf(num).isProbablePrime(20);
	  }
}
