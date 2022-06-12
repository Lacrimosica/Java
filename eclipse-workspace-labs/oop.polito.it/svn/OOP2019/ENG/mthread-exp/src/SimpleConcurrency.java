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

import mthe.DadaBase;
import mthe.Log;
import mthe.Model;
import mthe.Mthe;
import mthe.Scraper;

public final class SimpleConcurrency {

	DadaBase db = new DadaBase();

	class ThreadRunner implements Runnable {
		private int job;
		
		public ThreadRunner(int job) {
			this.job = job;
		}

		@Override
		public void run() {
			for(int t = 0; t < Mthe.TASK_PER_MODEL; ++t) {
				Scraper s = new Scraper("M"+job+"T"+t);
				s.run();
			}
			Model ml = new Model("M"+job);
			ml.fit();
			db.update("M"+job);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SimpleConcurrency v = new SimpleConcurrency();
		v.run();
	}
	
	void run() throws InterruptedException {
		Log.Message(this, "*", "Let's start (SimpleConcurrency)");
		long start = System.nanoTime();

		Thread[] jobs = new Thread[Mthe.NUM_MODELS];
		for(int j = 0; j < Mthe.NUM_MODELS; ++j) {
			jobs[j] = new Thread(new ThreadRunner(j));
			jobs[j].start();
		}
		for(Thread j: jobs)
			j.join();
		Log.Message(this, "*", "That's all folks!", System.nanoTime()-start);
	}

}
