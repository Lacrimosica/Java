
/*-************************************************************************-*\
*             *  CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)      *
*   #####     *  (!) Mar-2019, Giovanni Squillero <squillero@polito.it>      *
*  ######     *                                                              *
*  ###   \    *  Copying and distributing this file, either with or without  *
*   ##G  c\   *  modification, are permitted in any medium without royalty,  *
*   #     _\  *  provided that this 10-line comment is preserved.            *
*   |  _/     *                                                              *
*             *  ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <===  *
\*-************************************************************************-*/

import it.polito.oop.animals2.*;

public class TestApplication {

	public static void main(String[] args) {
		Penguin tux = new Penguin("Tux");
		Blackbird sparrow = new Blackbird("Sparrow");
		Bird ouh = new Bird("Ouh");
		
		tux.foo();
		System.out.println(tux);

		Cat bar = new Cat("Garfield");
		System.out.println(bar);
	}

	private void test3() {
		Animal[] ark = new Animal[4];

		// safe upcast
		ark[0] = new Cat("cat1");
		ark[1] = new Bird("bird1");
		ark[2] = new Bird("bird2");
		ark[3] = new Cat("cat2");

		for (Animal a : ark) {
			// nice n' polymorphic
			a.move();

			// ugly downcast, DON'T DO IT
			if (a instanceof Bird) {
				Bird b = (Bird) a;
				b.chirp();
			}
		}

	}

	private void test2() {
		Bird titty = new Bird("");
		titty.name = "Titty";
		titty.chirp();
		Animal foo = titty; // UPCAST!
		foo.move();

		Bird blue = new Bird("");
		blue.name = "Blue";
		Animal bar = blue;
		Bird gargle;
		if (bar instanceof Bird) {
			gargle = (Bird) bar; // DOWNCAST
			gargle.chirp();
		}
	}

	private void test1() {
		Animal kitty = new Animal("Kitty");
		kitty.move();

		Animal tom = new Cat("Tom");
		tom.move();

		Animal temp = tom;
		tom = kitty;
		kitty = temp;
		kitty.move();
		tom.move();

		Cat garfield = new Cat("Garfield");
		garfield.move();

		System.out.println(tom);
	}

}
