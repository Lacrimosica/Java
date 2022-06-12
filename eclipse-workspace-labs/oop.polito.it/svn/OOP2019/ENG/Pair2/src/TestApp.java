
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

import it.polito.oop.pair2.*;

public final class TestApp {

	public static void main(String[] args) {
		Pair<String> p1 = new Pair<>("Zabba", "Abba");
		printPair(p1);
		sortPair(p1);
		printPair(p1);

		Pair<Uncomparable> foo = new Pair<>(null, null);
		// sortPair(foo); Can't do it!

		Pair<Animal> ark = new Pair<>(new Animal(), new Animal());
		sortPair(ark);
		printPair(ark);

		Pair<Cat> ark2 = new Pair<>(new Cat(), new Cat());
		sortPair(ark2);
		printPair(ark2);

		System.out.println(ark.getClass() + " : " + p1.getClass());
	}

	static void printPair(Pair<?> p) {
		System.out.println("Pair@" + p.hashCode() + ": " + p.getFirst() + ", " + p.getSecond());
	}

	static <T> void printPairT(Pair<T> p) {
		System.out.println("Pair@" + p.hashCode() + ": " + p.getFirst() + ", " + p.getSecond());
	}

	static <T extends Comparable<? super T>> void sortPair(Pair<T> p) {
		T first = p.getFirst();
		T second = p.getSecond();

		if (first.compareTo(second) > 0) {
			p.setFirst(second);
			p.setSecond(first);
		}
	}
}
