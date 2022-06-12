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

import it.polito.oop.gg.*;

public final class TestApp {

	public static void main(String[] args) {
		UselessClass uc = new UselessClass(7);
		// System.out.println(uc.compareTo("Yeuch!")); static error
		System.out.println(uc.compareTo(new UselessClass(23)));
	
		for(int i: uc) {
			System.out.print(i + " ");
		}
		System.out.println("BOOM!");
		
		Point<String> p1 = new Point<>(1.0, 2.0, "p1");
		Point<String> p2 = new Point<>(1.0, 2.0, "p2");
		Point<Integer> p3 = new Point<>(1.0, 0.0, 23);
		Point<String> x = closestToOrigin(p1, p2);
		System.out.println(x);
		System.out.println(closestToOrigin2(p1, p3));
		
		Point<String> gp1;
		Point<Integer> gp2;
		// NumericPoint<String> np1;	yeuch! String is not Numeric
		NumericPoint<Integer> np2 = new NumericPoint<>(0, 0, 0);
		System.out.println(closestToOrigin2(np2, np2));	
	}
	
	static <T> Point<T> closestToOrigin(Point<T> p1, Point<T> p2) {
		if((p1.getX()*p1.getX() + p1.getY()*p1.getY()) > (p2.getX()*p2.getX() + p2.getY()*p2.getY()))
			return p2;
		else
			return p1;
	}

	static Point<?> closestToOrigin2(Point<?> p1, Point<?> p2) {
		if((p1.getX()*p1.getX() + p1.getY()*p1.getY()) > (p2.getX()*p2.getX() + p2.getY()*p2.getY()))
			return p2;
		else
			return p1;
	}

}
