package taxi;

public class Trip {
    private Place source, destination;
    
    public Trip(Place source, Place destination) {
	this.source = source;
	this.destination = destination;
    }

    public String toString() {
	return source + ", " + destination;
    }

    Place getDestination() {
	return destination;
    }
}
