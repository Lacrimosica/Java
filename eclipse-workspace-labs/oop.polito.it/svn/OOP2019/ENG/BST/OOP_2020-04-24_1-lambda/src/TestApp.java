/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (!) Apr-2020, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file, either with or without *
*|   ##     _\  | modification, are permitted in any medium without royalty, *
*|   |    _/    | provided that this 9-line comment is preserved.            *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

import it.polito.oop.lambda.*;

public final class TestApp {

	void lockdown(String[] books, Reader readerApplication) {
		for(String book: books)
			System.out.println(readerApplication.read(book));
	}
	
	public static void main(String[] args) {
		TestApp ta = new TestApp();
		String[] books = {"Dune", "Lord of the Rings", "HHGG"};
		
		// take 1
		ta.lockdown(books, new Reader() {
			public String read(String book) {
				return "Annamaria is reading " + book;
			} });

		// take 2
		ta.lockdown(books, b -> "Mehmet is reading " + b);

		// take 3
		ta.lockdown(books, Efe::oku);
		
		// take 4
		Efe efeMonday = new Efe("monday");
		Efe efeFriday = new Efe("friday");
		ta.lockdown(books, efeMonday::oku2);
		ta.lockdown(books, efeFriday::oku2);
	}
}
