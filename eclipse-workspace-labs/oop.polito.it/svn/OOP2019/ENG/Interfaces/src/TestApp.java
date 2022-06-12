
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

import java.util.Arrays;
import java.util.Comparator;

public class TestApp {

	public static void main(String[] args) {
		Cat kitty = new Cat();
		kitty.run();
		
		Movable.foobar();
		
		Movable worm = new Movable() {
			public void move() {
				System.out.println("The worm is crawling");
			}			
			public void run() {
				System.out.println("No way");
			}			
		};
		worm.run();
	}

	public static void test3() {
		Integer[] array = new Integer[] { 12, 23, 42, 10 };
		Arrays.sort(array, new Comparator() {
			public int compare(Object o1, Object o2) {
				Integer i1 = (Integer) o1;
				Integer i2 = (Integer) o2;
				return i2 - i1;
			}
		});

		for (Integer i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	public static void test2() {
		Countdown cnt = new Countdown(10);
		for (Object o1 : cnt) {
			for (Object o2 : cnt) {
				System.out.println(o1 + " - " + o2);
			}
		}
	}

	void test1() {
		Cat kitty = new Cat();
		kitty.move();

		// anonymous class
		Movable gargle = new Movable() {
			public void move() {
				System.out.println("The 'thing' is gargling");
			}
		};
		gargle.move();

		// anonymous class 2
		Movable blaster = new Movable() {
			public void move() {
				System.out.println("The blaster is gargling");
			}
		};
		blaster.move();

	}
}
