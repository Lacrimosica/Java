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

import it.polito.oop.dumb.*;
import it.polito.oop.singleton.*;

public class Driver {
	public static void main(String[] args) {
		it.polito.oop.singleton.SingleString foo = it.polito.oop.singleton.SingleString.getInstance();
		it.polito.oop.singleton.SingleString bar = it.polito.oop.singleton.SingleString.getInstance();
		
		foo.setData("Jake");
		foo.shout();
		bar.shout();
		it.polito.oop.singleton.SingleString.getInstance().shout();
		
		
		it.polito.oop.dumb.SingleString.setData("Elwood");
		it.polito.oop.dumb.SingleString.shout();
		it.polito.oop.dumb.SingleString.shout();
		it.polito.oop.dumb.SingleString.shout();
	}
}
