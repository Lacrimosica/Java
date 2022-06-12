import java.util.Iterator;

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

public class UselessClass implements Comparable<UselessClass>, Iterable<Integer> {

	int val;
	
	
	public UselessClass(int val) {
		this.val = val;
	}

	/*-* Ugly & Unsafe
	@Override
	public int compareTo(Object arg) {
		UselessClass other = (UselessClass)arg;
		return val - other.val;
	}
	*/

	@Override
	public int compareTo(UselessClass o) {
		return val - o.val;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			int cnt = val;
			public boolean hasNext() {
				return cnt >= 0;
			}
			public Integer next() {				
				return cnt--;
			}};
	}

}
