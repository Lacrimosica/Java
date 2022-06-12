
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

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public final class TestApp {

	public static void main(String[] args) {
		List<Integer> testData = new LinkedList<>();

		testData.add(23);
		testData.add(10);
		testData.add(13);
		testData.add(18);
		testData.add(5);

		// for(int t: testTree) {
		ListIterator<Integer> itr = testData.listIterator();
		while (itr.hasNext()) {
			int t = itr.next();
			if (t == 13) {
				System.out.print("Removing:");
				itr.remove();
				itr.add(42);
			}
			System.out.print(t + " ");
		}
		System.out.println();

		ListIterator<Integer> itr2 = testData.listIterator();
		// Refz: 
		itr2.forEachRemaining(System.out::println);
		//
		// lambda itr2.forEachRemaining(d -> System.out.println(d));
		//
		// generic (safe) consumer:
		//itr2.forEachRemaining(new Consumer<Integer>() {
		//	public void accept(Integer arg0) {
		//		System.out.println(arg0);
		//	}
		//});
		//
		// unbounded (UNSAFE) consumer:	// LAST & LEAST // DON'T DO IT!!!!!!!
		//itr2.forEachRemaining(new Consumer() {
		//	public void accept(Object arg0) {
		//		System.out.println(arg0);
		//	}
		//});
	}

}
