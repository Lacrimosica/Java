package trail;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Location {

    private String name;
    private Trail trail;
    private List<Delegate> delegates = new LinkedList<>();
    private Map<Runner, Long> passages = new HashMap<>();
    
    public void logPassage(Runner r, long t) {
	passages.put(r,  t);
    }
    
    public long getPassage(Runner r) {
	if(passages.containsKey(r))
	    return passages.get(r);
	else
	    return -1;
    }
    
    public List<Runner> getRanking() {
	return passages.entrySet().stream()
		.sorted(Comparator.comparing(Entry::getValue))
		.map(Entry::getKey)
		.collect(Collectors.toList());
    }
    
    public Location(Trail trail, String name) {
	this.trail = trail;
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public int getOrderNum() {
	return trail.getPath().indexOf(this);
    }

    public void addDelegate(Delegate d) {
	if (checkDelegate(d))
	    throw new RuntimeException() {
		private static final long serialVersionUID = 1L;
	    };
	delegates.add(d);
    }

    public boolean checkDelegate(Delegate d) {
	return delegates.contains(d);
    }

    public List<Delegate> getDelegates() {
	return delegates;
    }
}
