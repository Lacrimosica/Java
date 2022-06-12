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

import it.polito.oop.zoo.*;

public class Driver {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		SpeciesList darwin = SpeciesList.getInstance();
		Species dog = darwin.createSpecies("dog", 4, 0, 1, Species.MOVEMENT.WALK);
		Species fish = darwin.createSpecies("fish", 0, 0, 1, Species.MOVEMENT.SWIM);
		Species bird = darwin.createSpecies("bird", 2, 0, 1, Species.MOVEMENT.FLY);
		Species lion = darwin.createSpecies("lion", 2, 0, 1, Species.MOVEMENT.WALK);
		
		System.out.println(bird);
		System.out.println(darwin.findSpecies("bird"));
		driver.test();
	}
	
	private void test() {
		SpeciesList darwin2 = SpeciesList.getInstance();
		System.out.println(darwin2.findSpecies("bird"));
		
		Animal bob = new Animal("Bob the Lion King", "lion");
		Zoo myZoo = new Zoo();
		myZoo.addAnimal(bob, 42);
		myZoo.printCage(42);
		
		Animal puppy = new Animal("Puppy", "dog");
		myZoo.addAnimal(puppy, 23);
		myZoo.addAnimal(puppy, 42);
		myZoo.printCage(42);
		
	}

}
