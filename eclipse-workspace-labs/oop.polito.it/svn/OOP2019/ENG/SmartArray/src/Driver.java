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

import it.polito.oop.smart.SmartArray;
import static it.polito.oop.smart.Utility.*;

public class Driver {
	static public void main(String[] args) {
		long start = System.currentTimeMillis();
		
		SmartArray foo = new SmartArray();
		
		foo.setItem(42, -1);
		System.out.println(foo.getItem(42));
		System.out.println(foo.getItem(43));

		System.out.println(foo.getItem(4314));
		foo.setItem(4314, 17);
		System.out.println(foo.getItem(4314));
		System.out.println(foo.getItem(42));
		
		System.out.println("Defaul size: " + SmartArray.DEFAULT_SIZE);
		
		System.out.println("Elapsed: " + (start-System.currentTimeMillis()) + "ms");
		
		System.out.println("13? -> " + odd(13));
	}
}
