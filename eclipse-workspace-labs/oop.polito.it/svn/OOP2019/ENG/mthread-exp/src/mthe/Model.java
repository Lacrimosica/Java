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

package mthe;

public class Model {
	private String id;

	public Model(String id) {
		this.id = id;
	}
	
	public void fit() {
		long start = System.nanoTime();
		long wait = id.hashCode() % Mthe.MODELING_TIME;
		Log.Message(this, "Fitting model " + id + "...");
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) { }
		Log.Message(this, "Model " + id + " fitted", System.nanoTime()-start);
	}
}
