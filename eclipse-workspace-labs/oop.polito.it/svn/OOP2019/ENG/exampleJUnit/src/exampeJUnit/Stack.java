/*-************************************************************************-*\
*			*  CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)      		*
*        	*  (!) May-2019, Aleksa Damljanovic <aleksa.damljanovic@polito.it>  *
*      		*                                                              		*
*      		*  Copying and distributing this file, either with or without  		*
*     		*  modification, are permitted in any medium without royalty, 		*
*           *  provided that this 10-line comment is preserved.            		*
*   	    *                                                              		*
*           *  ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <===  		*
\*-************************************************************************-*/
package exampeJUnit;

public class Stack {
	private int [] st;
	private int next;
	
	public Stack(int size) {
		st = new int[size];
	}
	
	public Stack() {
		this(10);
	}
	
	public boolean isEmpty() {
		return next == 0;
	}
	
	public boolean push(int i) {
		if (st.length == next) {
			return false;
		}
		//if (i==2) {   //bug++
		//	st[next++] = 3;
		//} else {
		//	st[next++] = i;
		//}
		st[next++] = i;
		return true;
	}
	
	public int pop() throws Exception {

		if (next == 0) { 
			throw new IndexOutOfBoundsException();
		}
		//if (next == 0 || next == 3) {  // bug++
		//	throw new IndexOutOfBoundsException();
		//}
		return st[--next];

	}
	
}
