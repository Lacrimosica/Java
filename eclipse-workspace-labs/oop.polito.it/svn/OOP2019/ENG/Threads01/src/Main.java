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

public final class Main {

	static int pandora;
	
	class T1 implements Runnable {
		@Override
		public void run() {
			for(int t = 0; t < 10000; ++t) {
				Main.pandora += 1;
				//System.out.println("T1: " + t);
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Main m = new Main();
		m.runTest();
	}

	void runTest() throws InterruptedException {
		Thread myThread = new Thread(new T1());
		myThread.start();
		for(int t = 0; t < 10000; ++t) {
			Main.pandora -= 1;
			//System.out.println("main: " + t);
		}
		myThread.join();
		System.out.println("Pandora: " + Main.pandora);
	}
}
