package mthe;
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



final public class Log {
	private Log() {
		// just don't do it!
	}

	static public void Message(Object who, String tag, String message) {
		String who2 = Thread.currentThread().getName() + "::" + who;
		System.out.printf("%-42s|%1s| %s\n", who2, tag, message);
	}
	
	static public void Message(Object who, String message) {
		Message(who, "", message);
	}

	static public void Message(Object who, String message, long elapsed) {
		Message(who, "", message + " (" + + (elapsed / 1e6) + "ms)");
	}

	static public void Message(Object who, String tag, String message, long elapsed) {
		Message(who, tag, message + " (" + + (elapsed / 1e6) + "ms)");
	}
}
