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

import java.util.Iterator;

public class Countdown implements Iterable {
	private int value;
	
	Countdown(int value) {
		this.value = value;
	}
	
	class CountdownIterator implements Iterator {
		int foo = value;	// must be *local*
		@Override
		public boolean hasNext() {
			return foo >= 0;
		}
		@Override
		public Object next() {
			return new Integer(foo--);
		}		
	}
	
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new CountdownIterator();
	}

}
