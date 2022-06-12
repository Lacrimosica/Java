
/*-************************************************************************-*\
*             *  CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)      *
*   #####     *  (!) Apr-2019, Giovanni Squillero <squillero@polito.it>      *
*  ######     *                                                              *
*  ###   \    *  Copying and distributing this file, either with or without  *
*   ##G  c\   *  modification, are permitted in any medium without royalty,  *
*   #     _\  *  provided that this 10-line comment is preserved.            *
*   |  _/     *                                                              *
*             *  ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <===  *
\*-************************************************************************-*/

import it.polito.oop.Pair;

public class TestApp {

	public static void main(String[] args) {
		Pair<String, Integer> p1 = new Pair<>("one", 1);
		System.out.println("p1 = " + p1);

		// static error!
		// Pair<Integer, String> p2 = new Pair<>("one", 1);
		// System.out.println("p2 = " + p1);
		Integer[] a = new Integer[] {1, 2, 3, 4, 5};
		System.out.println(contains(a, 4));
	}
	
	static <T> boolean contains(T[] array, T element) {
		for(T e: array)
			if(e.equals(element))
				return true;
		return false;
	}

}
