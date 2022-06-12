package managingProperties;

import java.util.LinkedList;
import java.util.List;

public class Professional {
	private String id;
	private String profession = null;
	private int earning ;
	private List<Request> assignedRequests;
	
	public Professional(String id, String profession) {
		assignedRequests = new LinkedList<>();
		this.id = id;
		this.profession = profession;
		this.earning = 0;
	}

	public String getId() {
		return id;
	}

	public String getProfession() {
		return profession;
	}

	public int getEarning() {
		return earning;
	}
	
	public void setEarning(int amount) {
		this.earning = amount;
	}

	public List<Request> getAssignedRequests() {
		return assignedRequests;
	}
	
	
	public void addRequest(Request r) {
		assignedRequests.add(r);
	}
	
	
	
	
	
	
	
}
