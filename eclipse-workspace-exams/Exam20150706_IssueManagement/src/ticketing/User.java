package ticketing;

import java.util.Set;
import java.util.TreeSet;

import ticketing.IssueManager.UserClass;

public class User {
	String username;
	Set<UserClass> uc;
	public int closedTickets = 0 ;
	
	public User(String username, Set<UserClass> ucs) {
		this.username = username;
		uc = new TreeSet<>(ucs);
	}
	
	public Set<UserClass> getUC() {
		return uc;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void incrementClosedTickets() {
		this.closedTickets++;
	}
	
	public int getClosedTickets() {
		return this.closedTickets;
	}
	
}
