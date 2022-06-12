
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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import mthe.DadaBase;
import mthe.Log;
import mthe.Model;
import mthe.Mthe;
import mthe.Scraper;
import mthe.TaskList;

public final class SMCConcurrency {

	DadaBase db = new DadaBase();
	TaskList scheduledTask = new TaskList();
	Map<Integer, Integer> requiredScrapingTasks;
	Map<Integer, Boolean> dbUpdate;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SMCConcurrency smcc = new SMCConcurrency();
		smcc.run();
	}

	void run() throws InterruptedException {
		Log.Message(this, "*", "Let's start (SlightlyMoreComplexConcurrency)");
		long start = System.nanoTime();

		// init
		requiredScrapingTasks = Collections.synchronizedMap(new HashMap<>());
		dbUpdate = Collections.synchronizedMap(new HashMap<>());
		for (int m = 0; m < Mthe.NUM_MODELS; ++m) {
			requiredScrapingTasks.put(m, Mthe.TASK_PER_MODEL);
			for (int t = 0; t < Mthe.TASK_PER_MODEL; ++t)
				scheduledTask.add(m, t);
		}

		Thread[] scrapers = new Thread[6];
		for (int t = 0; t < scrapers.length; ++t) {
			scrapers[t] = new Thread(() -> scraperHandler());
			scrapers[t].start();
		}

		Thread[] models = new Thread[2];
		for (int t = 0; t < models.length; ++t) {
			models[t] = new Thread(() -> mlHandler());
			models[t].start();
		}

		dbUpdater();

		Log.Message(this, "*", "That's all folks!", System.nanoTime() - start);

		// join!
		for (Thread t : scrapers)
			t.join();
		for (Thread t : models)
			t.join();
	}

	void dbUpdater() {
		boolean finish = false;
		while (!finish) {
			synchronized (dbUpdate) {
				try {
					dbUpdate.wait();
				} catch (InterruptedException e) {
				}
			}

			// Log.Message(this, "D", "dbUpdate: " + dbUpdate);
			for (int m = 0; m < Mthe.NUM_MODELS; ++m) {
				if (dbUpdate.containsKey(m) && !dbUpdate.get(m)) {
					db.update("M" + m);
					dbUpdate.put(m, true);
				}
			}

			finish = true;
			for (int m = 0; m < Mthe.NUM_MODELS; ++m)
				if (!dbUpdate.containsKey(m) || !dbUpdate.get(m))
					finish = false;
			// Log.Message(this, "D", "dbUpdate: " + dbUpdate);
			// Log.Message(this, "D", "finish: " + finish);
		}
	}

	void scraperHandler() {
		Log.Message(this, "Starting scraperHandler");
		while (!scheduledTask.isEmpty()) {
			TaskList.Task t = scheduledTask.get();
			if (t == null)
				continue;
			Scraper s = new Scraper(t.toString());
			s.run();
			synchronized (requiredScrapingTasks) {
				requiredScrapingTasks.put(t.model, requiredScrapingTasks.get(t.model) - 1);
				requiredScrapingTasks.notifyAll();
			}
		}
		Log.Message(this, "Removing scraperHandler");
	}

	void mlHandler() {
		Log.Message(this, "Starting mlHandler");
		boolean moreModel = true;
		while (moreModel) {
			int model = -1;
			synchronized (requiredScrapingTasks) {
				/*- NOT WORKING
				 * try {
				 * requiredScrapingTasks.wait();
				 * } catch (InterruptedException e) { }
				***/
				for (int m = 0; m < Mthe.NUM_MODELS; ++m) {
					if (requiredScrapingTasks.get(m) == 0) {
						requiredScrapingTasks.put(m, -1);
						model = m;
						break;
					}
				}
			}

			if (model >= 0) {
				Model ml = new Model("M" + model);
				ml.fit();
				synchronized (dbUpdate) {
					dbUpdate.put(model, false);
					dbUpdate.notifyAll();
				}
			}

			moreModel = false;
			for (int m = 0; m < Mthe.NUM_MODELS; ++m)
				if (requiredScrapingTasks.get(m) != -1)
					moreModel = true;
		}
		Log.Message(this, "Removing mlHandler");
	}
}
