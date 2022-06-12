
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

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalcTest {
	@Test
	public void testMultiply() {
		Foo f = new Foo();
		assertEquals(2, f.multiply(1, 2));
		assertEquals(4, f.multiply(1, 2, 2));
		assertEquals(9, f.multiply(3, 3));
		assertEquals(0, f.multiply(1, 2, 3, 4, 5, 0, 2));
	}
}