package taxi;

public class Place {

    private String fullAddress;
    private String district;
    
    public Place(String fullAddress, String district) {
	super();
	this.fullAddress = fullAddress;
	this.district = district;
    }

    public String toString() {
	return fullAddress;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public String getDistrict() {
        return district;
    }
}
