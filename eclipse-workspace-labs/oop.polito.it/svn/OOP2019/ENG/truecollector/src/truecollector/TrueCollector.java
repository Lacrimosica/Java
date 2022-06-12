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

package truecollector;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class TrueCollector implements Collector<String,Map<String, Integer>,String> {

	class MyBeautifulCombiner implements BinaryOperator<Map<String, Integer>> {
		@Override
		public Map<String, Integer> apply(Map<String, Integer> map1, Map<String, Integer> map2) {
			for(Map.Entry<String, Integer> e: map2.entrySet()) {
				if(map1.containsKey(e.getKey()))
					map1.put(e.getKey(), e.getValue()+map1.get(e.getKey()));
				else
					map1.put(e.getKey(), e.getValue());
			}
			return map1;
		}
	}
	
	
	@Override
	public BiConsumer<Map<String, Integer>, String> accumulator() {
		return (d, s) -> {
			if(d.containsKey(s))
				d.put(s, d.get(s)+1);
			else
				d.put(s,  1);
		};
	}

	@Override
	public Set<Characteristics> characteristics() {
		Set<Characteristics> zap = new HashSet<>();
		return zap;
	}

	@Override
	public BinaryOperator<Map<String, Integer>> combiner() {
		return new MyBeautifulCombiner();
	}

	@Override
	public Function<Map<String, Integer>, String> finisher() {
		return (d)->d.toString();
	}

	@Override
	public Supplier<Map<String, Integer>> supplier() {
		/*-* anon class
		return new Supplier<Map<String, Integer>>() {
			public Map<String, Integer> get() {
				return new HashMap<String, Integer>();
			}};
		**/
		/*-* lambda
		return ()->new HashMap<String, Integer>();
		**/
		return HashMap<String, Integer>::new;
	}

}
