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

import java.nio.charset.Charset;

public class Main {
	public static void main(String[] args) {
		Charset cs1 = Charset.forName("UTF-8");
		Charset cs2 = Charset.forName("ISO-8859-1");
		System.out.println(cs2.decode(cs1.encode("Perché")));
		
		System.out.println(String.format("%.3f", 1.0/3.0));
	}

}
