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
import java.util.function.Predicate;
public class FilterLongWords implements Predicate<String>{

	@Override
	public boolean test(String t) {
		return t.length()>5;
	}

}
