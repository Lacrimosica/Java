
/*-************************************************************************-*\
*             *  CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)      *
*   #####     *  (!) May-2019, Giovanni Squillero <squillero@polito.it>      *
*  ######     *                                                              *
*  ###   \    *  Copying and distributing this file, either with or without  *
*   ##G  c\   *  modification, are permitted in any medium without royalty,  *
*   #     _\  *  provided that this 10-line comment is preserved.            *
*   |  _/     *                                                              *
*             *  ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <===  *
\*-************************************************************************-*/

import it.polito.oop.milliways.MilliwaysException;
import it.polito.oop.milliways.Party;
import it.polito.oop.milliways.Race;
import it.polito.oop.milliways.Restaurant;

public final class TestApp {

	public static void main(String[] args) throws MilliwaysException {
		Race v = Restaurant.defineRace("Vogons");
		v.addRequirement("foo");
		v.addRequirement("bar");
		v.addRequirement("baz");
		System.out.println(v.getRequirements());

		Race w = Restaurant.defineRace("Humans");
		w.addRequirement("foo");
		w.addRequirement("gargle");
		System.out.println(w.getRequirements());
		
		Party p = Restaurant.createParty();
		p.addCompanions("Vogons", 1);
		p.addCompanions("Humans", 3);
		System.out.println(p.getRequirements());
		
	}
}
