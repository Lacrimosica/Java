package managingProperties;


public class Request {
	
	public enum State{
		PENDING, ASSIGNED, COMPLETED
	}
	int requestNumber;
	private String OId;
	private String AId;
	private String BId;
	private String profession;
	private Professional professional;
	private State st;
	private int chargedPrice;
	
	public Request(int number, String ownerId, String ApartmentId, String Profession) {
		this.requestNumber = number;
		this.OId = ownerId;
		this.AId = ApartmentId;
		this.profession = Profession;
		this.st = State.PENDING;
		setBId();
		
	}
	
	public void setBId() {
		String[] tmp = AId.split(":");
		this.BId = tmp[0];
	}
	
	public String getBId() {
		return this.BId;
	}
	
	public void setSt(State st) {
		this.st = st;
	}
	
	public void setProfessional(String id) {
		this.professional = PropertyManager.getInstance().getProfessional(id);;
	}

	public Professional getProfessional() {
		return this.professional;
	}
	
	public void setChargedPrice(int chargedPrice) {
		this.chargedPrice = chargedPrice;
		PropertyManager.getInstance().getOwner(this.OId).addToCharges(chargedPrice);
		PropertyManager.getInstance().getBuilding(BId).addToCharges(chargedPrice);
	}
	
	public int getChargedPrice() {
		return chargedPrice;
	}

	public int getRequestNumber() {
		return requestNumber;
	}

	public String getOId() {
		return OId;
	}

	public String getAId() {
		return AId;
	}

	public String getProfession() {
		return profession;
	}

	public State getSt() {
		return st;
	}
	
	public void Assing(String professional) {
		this.setProfessional(professional);
		this.setSt(State.ASSIGNED);
	}
	
	public void complete(int amount) {
		this.setSt(State.COMPLETED);
		this.chargedPrice = amount;
		PropertyManager.getInstance().getOwner(this.OId).addToCharges(amount);
	}

	@Override
	public String toString() {
		return "Request [requestNumber=" + requestNumber + ", OId=" + OId + ", AId=" + AId + ", BId=" + BId
				+ ", profession=" + profession + ", professional=" + professional + ", st=" + st + ", chargedPrice="
				+ chargedPrice + "]";
	}
	
	
}
