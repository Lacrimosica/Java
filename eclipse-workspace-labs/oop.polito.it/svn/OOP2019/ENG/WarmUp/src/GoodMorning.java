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

public class GoodMorning {

	public static void main(String[] args) {
		String n1 = "Giovanni";
		String n2 = "Adolfo";
		String n3 = "Pietro";
		String n4 = "Pio";
		
		System.out.println("Squillero" == "Squillero");
		System.out.println(n1 == "Giovanni");
		System.out.println(n1+n2 == "GiovanniAdolfo");
		System.out.println(n1 == ("Gio" + "vanni"));

		String x1 = "GiovanniAdolfo";
		String x2 = "Giovanni" + "Adolfo";
		String x3 = n1 + n2;
		System.out.println("GiovanniAdolfo" == x1);
		System.out.println("GiovanniAdolfo" == x2);
		System.out.println("GiovanniAdolfo" == x3);
	}

}
