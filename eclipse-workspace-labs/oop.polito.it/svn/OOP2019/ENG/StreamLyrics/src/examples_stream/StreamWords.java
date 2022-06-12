/*-************************************************************************-*\
*			*  CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)      		*
*        	*  (!) May-2019, Aleksa Damljanovic <aleksa.damljanovic@polito.it>  *
*      		*                                                              		*
*      		*  Copying and distributing this file, either with or without  		*
*     		*  modification, are permitted in any medium without royalty, 		*
*           *  provided that this 10-line comment is preserved.            		*
*   	    *                                                              		*
*           *  ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <===  		*
\*-************************************************************************-*/
package examples_stream;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;
public class StreamWords {

	public static void main(String[] args) {


		
		//Creating the stream explicitly
		String[] colors = {"Green", "Blue", "Yellow", "Green", "White"};
		
				
		//Sort + retain only 3 elements + print
		Arrays.stream(colors)
		.sorted()
		.limit(3)
		.forEach(System.out::println);
		System.out.println();
		
		//Corresponds to ^
		Arrays.sort(colors);
		for (int i=0; i<3; i++) {
			System.out.println(colors[i]);
		}
		System.out.println();
		
		//discard duplicates + sort + retain only 3 elements + print
		Arrays.stream(colors)
		.distinct()
		.sorted()
		.limit(3)
		.forEach(System.out::println);
		System.out.println();
		
		//Corresponds to ^
		TreeSet<String> diverse = new TreeSet<String>();
		for (int i=0; i<colors.length; i++) {
			diverse.add(colors[i]);
		}
		Iterator<String> it = diverse.iterator();
		for (int i=0; i<3; i++) {
			System.out.println(it.next());
		}
		System.out.println();
		
		//Stream source by generate 
		Stream.generate( () -> Math.random() * 10)
		.limit(10)
		.forEach(System.out::println);
		System.out.println();
		
		//Stream source by iterate
		Stream.iterate(0, (prev) -> (prev) +2)
		.limit(20)
		.forEach(System.out::println);
		System.out.println();
		

		// Fibonacci number generator A
		FibonacciGen f = new FibonacciGen();
		Stream.generate( () -> f.get())
		.limit(10)
		.forEach(System.out::println);
		System.out.println();
		
		// Fibonacci number generator B
		int [] fibA = {1,0};
		Stream.generate( () -> {
			int n = fibA[0] + fibA[1];
			fibA[0] = fibA[1];
			fibA[1] = n;
			return n;
		})
		.limit(10)
		.forEach(System.out::println);
		System.out.println();
		
		// Fibonacci number generator C
		Copy c = new Copy();
		c.cur = 0;
		c.prev = 1;
		Stream.generate( () -> {
			int n = c.prev + c.cur;
			c.prev = c.cur;
			c.cur = n;
			return n;
		})
		.limit(10)
		.forEach(System.out::println);	
		System.out.println();
		
		//Song lyrics
		String[] lyrics = SongLyrics.PASSENGER.split("[- ',\n]+");
		List<String> words = Arrays.asList(lyrics);
		
		//Collection stream: sort Descending + discard duplicates + retain first 10 + keep with length>5 + print
		words.stream()
		.sorted((s1,s2) -> s2.compareTo(s1))
		.distinct()
		.limit(10)
		.filter(p -> p.length()>5)
		.forEach(System.out::println);
		
		// Capitalize letters and keep first 10 elements
		words.stream()
		.map(w -> w.toUpperCase())
		//.map(String::toUpperCase)
		.limit(10)
		.forEach(System.out::println);
		System.out.println();

		//Array stream: discard duplicates + keep those not starting with a 'G' + sort + retain first 3 + print
		Stream.of(lyrics)
		.distinct()
		.filter(p -> !p.startsWith("G"))
		.sorted()
		.limit(3)
		.forEach(System.out::println);
			
	
		
		// With stream generated from an array: filter
		FilterLongWords filtLW = new FilterLongWords();
		Arrays.stream(lyrics)
		.filter(filtLW)
		.forEach(System.out::println);
		
		//Lambda filter
		Arrays.stream(lyrics)
		.filter(t -> {return t.length()>5;} )
		.forEach(System.out::println);

		// Comparator 
		Arrays.stream(lyrics)
		.filter(t -> t.length()>2 )
		.sorted((s1,s2) -> s1.length()-s2.length())
		.map(p -> p.length())
		.distinct()
		//.forEach(p -> {System.out.println(p);});
		.forEach(System.out::println);

		
		
		
		
		//Terminals: anyMatch, allMatch, noneMatch
		boolean anyWordMatch = 
				Stream.of(lyrics)
				.anyMatch(w -> w.equals("passenger"));
		System.out.println("There is a word \"passenger\": " + anyWordMatch);

		boolean allLessThenThirty = 
				Stream.of(lyrics)
				.allMatch(w -> w.length() < 9);
		System.out.println("All the words contain less than 11 chars: " + allLessThenThirty);

		boolean noWordHasLZero = 
				Stream.of(lyrics)
				.noneMatch(w -> w.length() == 0);
		System.out.println("All the words have more than 0 chars: " + noWordHasLZero);


		
		
		// Optional
		Optional<String> first = 
				Stream.of(lyrics)
				.distinct()
				.filter(w -> w.length()>5)
				.findFirst();
		String value = first.orElse("no word");
		System.out.println(value);
		

		//Comparison in execution
		long start1 = System.currentTimeMillis();
		DoubleStream.generate(() -> Math.random()*10)
		.limit(1000000)
		.reduce(0, Math::max);
		long stop1 = System.currentTimeMillis();
		System.out.println("Serial exec: " + (stop1-start1));

		// Parallel execution 
		long start2 = System.currentTimeMillis();
		DoubleStream.generate(() -> Math.random()*10)
		.limit(1000000)
		.parallel()
		.reduce(0, Math::max);
		long stop2 = System.currentTimeMillis();
		System.out.println("Parallel exec: " + (stop2-start2));
		
		
		
		
		
		// Discard copies
		Set<String> uniqueWords =
				Stream.of(lyrics)
				.collect(Collectors.toSet());
		System.out.println(uniqueWords);
		
		//Discard copies (distinct?)
		uniqueWords =
				Stream.of(lyrics)
				.distinct()
				.collect(Collectors.toSet());
		System.out.println(uniqueWords);
		
		//Ordereed list of words + discard copies
		uniqueWords =
				Stream.of(lyrics)
				.collect(toCollection(TreeSet::new));
		System.out.println(uniqueWords);
		
		//Map: key - length of the word; values - list of words having the certain length
		Map<Integer,List<String>> wordMap = 
				Stream.of(lyrics)
				.distinct()
				.collect(groupingBy(String::length));
		System.out.println(wordMap);
		
		//Map: key - length of the word; values - list of words having the certain length; reversed order
		 wordMap =
				Stream.of(lyrics)
				.distinct()
				.collect(groupingBy(String::length,
						() -> new TreeMap<Integer, List<String>>(Collections.reverseOrder()), toList()));
		System.out.println(wordMap);
		
		//Map: key - length of the word; values - list of words having the certain length
		wordMap =
				Stream.of(lyrics)
				.distinct()
				.collect(groupingBy(String::length,
						TreeMap::new, toList()));
						
		System.out.println(wordMap);
	
		
	}





	private static class Copy{
		int prev;
		int cur;
	}
	//fibonacchi 
	
	
	
	private static class FibonacciGen {
		int cur, prev;
		public FibonacciGen () {
			cur = 0;
			prev = 1;
		}
		public void reset() {
			cur = 0;
			prev = 1;
		}
		public int get() {
			int n = prev + cur;
			prev = cur;
			cur = n;
			return n;
		}
	}




	public static Supplier<Integer> fibonacci() {

		return new Supplier<Integer> (){
			int previous = 1;
			int current = 0;
			@Override
			public Integer get() {
				int n = previous + this.current;
				previous = current;
				current = n;
				return n;
			};

		};
	}



}
