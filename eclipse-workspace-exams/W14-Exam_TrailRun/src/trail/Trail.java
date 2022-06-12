package trail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Trail {

    private Set<Runner> runners = new HashSet<>();
    private Map<String, Location> locations = new HashMap<>();
    private Map<String, Delegate> delegates = new HashMap<>();
    private List<Location> path = new ArrayList<>();

    public int newRunner(String name, String surname) {
	Runner r = new Runner(runners.size() + 1, name, surname);
	runners.add(r);
	return r.getBibNumber();
    }

    public Runner getRunner(int bibNumber) {
	for (Runner r : runners)
	    if (r.getBibNumber() == bibNumber)
		return r;
	return null;
    }

    public Collection<Runner> getRunner(String surname) {
	return runners.stream()
		.filter(x->x.getSurname().equals(surname))
		.sorted()
		.collect(Collectors.toList());	
    }

    public List<Runner> getRunners() {
	return runners.stream()
		// .sorted((x,y)->Integer.compare(x.getBibNumber(), y.getBibNumber()))
		.sorted(Comparator.comparing(Runner::getBibNumber))
		.collect(Collectors.toList());
    }

    public List<Runner> getRunnersByName() {
	return runners.stream()
		// .sorted()
		.sorted(Comparator.comparing(Runner::getSurname)
			.thenComparing(Comparator.comparing(Runner::getName))
			.thenComparing(Comparator.comparing(Runner::getBibNumber)))
		.collect(Collectors.toList());
    }

    public void addLocation(String locationName) {
	Location loc = new Location(this, locationName);
	locations.put(locationName, loc);
	path.add(loc);
    }

    public Location getLocation(String locationName) {
	return locations.get(locationName);
    }

    public List<Location> getPath() {
	return path;
    }

    public void newDelegate(String name, String surname, String id) {
	Delegate d = new Delegate(id, surname, name);
	delegates.put(id,  d);
    }

    public List<String> getDelegates() {
	return delegates.values().stream()
		.sorted(Comparator.comparing(Delegate::getSurname)
			.thenComparing(Comparator.comparing(Delegate::getName)))
		.map(Delegate::toString)
		.collect(Collectors.toList());
    }

    public void assignDelegate(String locationName, String delegateSSN) throws TrailException {
	Delegate d = delegates.get(delegateSSN);
	Location l = locations.get(locationName);
	if(l == null || d == null)
	    throw new TrailException();
	l.addDelegate(d);
    }

    public List<String> getDelegates(String locationName) {
	return locations.get(locationName).getDelegates().stream()
		.map(Delegate::toString)
		.collect(Collectors.toList());
    }

    public long recordPassage(String delegateSSN, String locationName, int bibNumber) throws TrailException {
	Delegate d = delegates.get(delegateSSN);
	Location l = locations.get(locationName);
	Runner r = getRunner(bibNumber);
	long t = System.currentTimeMillis();
	if(l == null || d == null || r == null || !l.checkDelegate(d))
	    throw new TrailException();
	l.logPassage(r, t);
	return t;
    }

    public long getPassTime(String locationName, int bibNumber) throws TrailException {
	Location l = locations.get(locationName);
	Runner r = getRunner(bibNumber);
	if(l == null || r == null)
	    throw new TrailException();
	return l.getPassage(r);
    }

    public List<Runner> getRanking(String locationName) {
	return locations.get(locationName).getRanking();
    }

    public List<Runner> getRanking() {
	return null;
    }
}
