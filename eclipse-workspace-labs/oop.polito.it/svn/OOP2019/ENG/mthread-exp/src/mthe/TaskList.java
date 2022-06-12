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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TaskList {
	static public class Task {
		public int model, task;
		public Task(int model, int task) {
			this.model = model;
			this.task = task;
		}
		@Override
		public String toString() {
			return "M" + model + "T" + task;
		}
		
	}
	
	private List<Task> tasks = Collections.synchronizedList(new LinkedList<>());
	synchronized public Task get() {
		if(tasks.isEmpty())
			return null;
		return tasks.remove(0);
	}
	public void add(int model, int task) {
		tasks.add(new Task(model, task));
	}
	public boolean isEmpty() {
		return tasks.isEmpty();
	}

}
