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

package examples_stream;

import java.util.function.Supplier;

public class Generator implements Supplier<Integer>{
	int n=1;
	@Override
	public Integer get() {
		int n1 = n;
		n = n * 10;
		return n1;
	}

	public void reset() {
		n=1;
	}
}
