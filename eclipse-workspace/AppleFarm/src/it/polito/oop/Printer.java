package it.polito.oop;

import java.util.ArrayList;
import java.util.List;

public class Printer {
	public static <T> String print(List<T> list) {
		String output = list.toString();
		List<T> result = new ArrayList<>();
//		for (T e: list) {
//			if(p.test(e)) {
//				result.add(e);S
//			}
//		}
		return output;
	}
}

