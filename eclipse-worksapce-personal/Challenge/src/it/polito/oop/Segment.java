package it.polito.oop;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


import static java.util.stream.Collectors.*;
public class Segment {
	
	public int value;
	public int nseg;
	
	
	public Segment(int value, int nseg) {
		this.value = value;
		this.nseg = nseg;
	}
	
	
	public static int Mincalc( LinkedList<Segment> panel, List<Segment> segments, int n) {
		
		int m = n;
	
		Map<Integer, List<Segment>> mapping = segments.stream().collect(groupingBy(Segment::getNseg));
		System.out.println(mapping);
		
		panel.addFirst((Segment) mapping.get(2));
		
//		System.out.println(mapping.get());
		
		return n;
		
	}
	
	
	public int getValue() {
		return value;
	}


	public int getNseg() {
		return nseg;
	}


	@Override
	public String toString() {
		return "[cost " + nseg + " segments " + "val " + value + "]";
	}

}
