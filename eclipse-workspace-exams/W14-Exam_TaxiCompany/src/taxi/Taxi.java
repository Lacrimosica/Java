package taxi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Taxi implements InfoI {

    static private Map<String, Taxi> directory = new HashMap<>();
    private String id;
    private Passenger passenger;
    private Place destination;
    private List<Trip> tripLog = new LinkedList<>();
    private TaxiCompany company;

    public TaxiCompany getCompany() {
        return company;
    }

    public void setCompany(TaxiCompany company) {
        this.company = company;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    static public Taxi getTaxi(String id) {
	if (!directory.containsKey(id))
	    return null;
	else
	    return directory.get(id);
    }

    public Taxi(String id) {
	if (directory.containsKey(id))
	    throw new RuntimeException() {
		private static final long serialVersionUID = 1L;
	    };
	this.id = id;
	directory.put(id, this);
    }

    public String toString() {
	return id;
    }

    public void beginTrip(Place dest) {
	destination = dest;
    }

    public void terminateTrip() {
	tripLog.add(new Trip(passenger.getPlace(), destination));
	passenger.setPlace(destination);
	company.addToAvailable(this);
    }

    public List<Trip> getTripLog() {
        return tripLog;
    }

    @Override
    public int compareTo(InfoI other) {
	if(this.getValue() != other.getValue())
	    return Integer.compare(other.getValue(), this.getValue());
	else
	    return this.getId().compareTo(other.getId());
    }

    @Override
    public String getId() {
	return this.toString();
    }

    @Override
    public int getValue() {
	return tripLog.size();
    }

}
