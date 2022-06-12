package taxi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TaxiCompany {

    private Set<Taxi> taxis = new HashSet<>();
    private Queue<Taxi> availableTaxis = new LinkedList<>();
    private int lostTrips;

    public void addTaxi(String id) throws InvalidTaxiName {
	if (Taxi.getTaxi(id) != null)
	    throw new InvalidTaxiName();
	Taxi t = new Taxi(id);
	t.setCompany(this);
	taxis.add(t);
	addToAvailable(t);
    }

    public void addToAvailable(Taxi t) {
	if (!taxis.contains(t))
	    throw new RuntimeException() {
		private static final long serialVersionUID = 1L;
	    };
	if (t.getCompany() != this)
	    throw new RuntimeException() {
		private static final long serialVersionUID = 1L;
	    };
	availableTaxis.add(t);
    }

    public Collection<Taxi> getAvailable() {
	return availableTaxis;
    }

    public Taxi callTaxi(Passenger p) {
	if (availableTaxis.isEmpty()) {
	    ++lostTrips;
	    return null;
	} else {
	    Taxi t = availableTaxis.remove();
	    t.setPassenger(p);
	    return t;
	}
    }

    public List<Trip> getTrips(String id) throws InvalidTaxiName {
	Taxi t = Taxi.getTaxi(id);
	if(!taxis.contains(t))
	    throw new InvalidTaxiName();
	return t.getTripLog();
    }

    public int getLostTrips() {
	return lostTrips;
    }

    public ArrayList<InfoI> statsTaxi() {
	return taxis.stream()
		.sorted()
		.collect(Collectors.toCollection(ArrayList::new));
    }

    
    class Info implements InfoI {

	private String district;
	private int count;
	
	public Info(String district, long count) {
	    this.district = district;
	    this.count = (int)count;
	}
	@Override
	public int compareTo(InfoI other) {
	    if(this.getValue() != other.getValue())
		return other.getValue() - this.getValue();
	    else
		return this.getId().compareTo(other.getId());
	}
	@Override
	public String getId() {
	    return district;
	}
	@Override
	public int getValue() {
	    return count;
	}
	@Override
	public String toString() {
	    return "Info [district=" + district + ", count=" + count + "]";
	}
	
    }
    
    public ArrayList<InfoI> statsDistricts() {
	return taxis.stream()
		.flatMap(t->t.getTripLog().stream())
		.map(t->t.getDestination().getDistrict())
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet()
		.stream()
		.map(e->new Info(e.getKey(), e.getValue()))
		.sorted()
		.collect(Collectors.toCollection(ArrayList::new));
    }
}







