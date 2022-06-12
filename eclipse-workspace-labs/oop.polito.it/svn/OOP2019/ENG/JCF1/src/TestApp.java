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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class TestApp {

	public static void main(String[] args) {
		Set<String> test1 = new HashSet<>();
		
		test1.add("Paul");
		test1.add("John");
		test1.add("John");
		test1.add("Ringo");
		test1.add("George");
		for(String b: test1)
			System.out.println(b);
		
		System.out.println("8-dec-1980");
		test1.remove("John");
		for(String b: test1)
			System.out.println(b);

	}

}
