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

public class Main {

	private enum BEATLE { JOHN, PAUL, GEORGE, RINGO };
	
	public static void main(String[] args) {
		System.out.println(mean(2.0, 4.0));
		System.out.println(mean(2.0, 4.0, 5.0, 78.1, 8754.23));
		
		double[] array = {2.0, 4.0, 5.0, 78.1, 8754.23};
		System.out.println(mean(array));

		BEATLE x = BEATLE.JOHN;
		for(BEATLE s: BEATLE.values())
			System.out.println(s);
		
	}
	
	static private double mean(double... data) {
		double sum = 0.0;
		
		for(double d: data)
			sum += d;

		return sum / data.length;
	}
}
