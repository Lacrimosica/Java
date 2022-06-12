package taxi;

public class Passenger {

    private Place place;
    
    public Passenger(Place pos) {
	place = pos;
    }

    public Place getPlace() {
	return place;
    }

    public void setPlace(Place p) {
	place = p;
    }

}
