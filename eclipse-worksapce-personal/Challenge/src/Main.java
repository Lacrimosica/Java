

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.oop.*;


public class Main {

	public static void main(String[] args) {
		
		Segment zero = new Segment(0, 6);
		Segment one = new Segment(1, 2);
		Segment two = new Segment(2, 5);
		Segment three = new Segment(3, 5);
		Segment four = new Segment(4, 4);
		Segment five = new Segment(5, 5);
		Segment six = new Segment(6, 6);
		Segment seven = new Segment(7, 3);
		Segment eight = new Segment(8, 7);
		Segment nine = new Segment(9,6);
			
	
		List<Segment> segments = new ArrayList<Segment>();
		
		segments.add(zero);
		segments.add(one);
		segments.add(two);
		segments.add(three);
		segments.add(four);
		segments.add(five);
		segments.add(six);
		segments.add(seven);
		segments.add(eight);
		segments.add(nine);
		
		

		
		LinkedList<Segment> panel = new LinkedList<Segment>();
		
		
		int n = 2;
		int t = 3;
		// t between 1 and 10000
		//n between 1 and 200,000
		if(n * t >= 200000) {
			System.out.println("out of bounds");
		}
	
		Segment.Mincalc(panel, segments, n);
		
		
		
	}

}
