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

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import it.polito.oop.jcf2.*;

public final class TestApp {

	public static void main(String[] args) {
		Set<Student> computerScience = new TreeSet<>();
		
		Student alan = new Student("002", "Alan Ford");
		Student n1 = new Student("099", "Number One");
		Student bob = new Student("001", "Bob Rock");
		computerScience.add(alan);
		computerScience.add(n1);
		computerScience.add(bob);
		printCourse(computerScience);

		System.out.println("--- Let's go intergalactic");
		Student udhgy = new AlienStudent("003", "756 4 6547e 6", "Tralfamadore");
		computerScience.add(udhgy);
		printCourse(computerScience);
		
		System.out.println("--- Adding Bob's clone");
		Student bob_clone = new Student("001", "Rock Bob");
		computerScience.add(bob_clone);
		printCourse(computerScience);
		
		System.out.println("--- cs2");
		/*-* anon inner class
		Set<Student> cs2 = new TreeSet<>(new Comparator<Student>() {
			public int compare(Student arg0, Student arg1) {
				return arg0.getName().compareTo(arg1.getName());
			} });
		*-*/
		// lambda
		Set<Student> cs2 = new TreeSet<>((s1, s2) -> s1.getName().compareTo(s2.getName()));
		cs2.addAll(computerScience);
		printCourse(cs2);

	}
	
	static void printCourse(Set<Student> course) {
		for(Student s: course)
			System.out.println(s);
	}
}
