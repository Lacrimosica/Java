
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

import java.util.function.IntConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.Arrays;
import java.util.Comparator;

import it.polito.oop.*;

public class TestApp {
	public static void main(String[] args) {
		t2();
	}
	
	public static void t2() {
		TestApp tap = new TestApp();
		tap.test2(o -> System.out.println(Math.sqrt(o)));
	}

	public static void t1() {
		TestApp tap = new TestApp();

		// long way
		Power powerObject = new Power();
		tap.test1(powerObject);

		// anonymous inner class
		tap.test1(new IntConsumer() {
			public void accept(int value) {
				System.out.println(value + " +1 = " + (value + 1));
			}
		});

		// lambda
		tap.test1(v -> System.out.println(v + " +2 = " + (v + 2)));

		// 2-line lambda!
		tap.test1(v -> {
			System.out.println("I *LOVE* complex lambda's");
			System.out.println(v + " +2 = " + (v + 2));
		});

		// VERY simple lambda (ie. a reference)
		tap.test1(v -> System.out.println(v));

		// Explicit reference
		tap.test1(System.out::println);
		
		// lambda are objects!
		BiFunction obj = new BiFunction() {
			public Object apply(Object t, Object u) {
				return null;
			}
		};
		BiFunction obj2 = (a, b) -> {
			return null;
		};

		System.out.println(obj);
		System.out.println(obj2);

		// compare
		Object[] testArray = new Integer[] { 23, -10, 18, -5 };
		for (Object v : testArray) {
			System.out.print(v + " ");
		}
		System.out.println("");

		Arrays.sort(testArray);
		for (Object v : testArray) {
			System.out.print(v + " ");
		}
		System.out.println("");

		// anonymous inner class
		Arrays.sort(testArray, new Comparator() {
			public int compare(Object o1, Object o2) {
				Integer i1 = (Integer) o1;
				Integer i2 = (Integer) o2;
				return i2 - i1;
			}
		});
		for (Object v : testArray) {
			System.out.print(v + " ");
		}
		System.out.println("");

		// lambda
		Arrays.sort(testArray, (o1, o2) -> Math.abs((Integer) o1) - Math.abs((Integer) o2));
		for (Object v : testArray) {
			System.out.print(v + " ");
		}
		System.out.println("");

	}

	void test1(IntConsumer consumer) {
		for (int t = 0; t < 5; ++t) {
			consumer.accept(t);
		}
	}

	void test2(Consumer<Integer> consumer) {
		for (int t = 0; t < 5; ++t) {
			consumer.accept(t);
		}
	}

}
