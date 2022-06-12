package ticketing;

import ticketing.IssueManager.UserClass;

/**
 * Class representing the ticket linked to an issue or malfunction.
 * 
 * The ticket is characterized by a severity and a state.
 */
public class Ticket {
    int Id;
    String description;
    Severity sv;
    State st;
    String author;
    String responder;
    Component component;
    String SolutionDescription;
    
    
    public Ticket(int id,String username,
    		String componentPath,
    		String description,
    		Ticket.Severity severity) throws TicketException {
    	this.Id = id;
    	this.author = username;
    	this.component = Component.getParent(componentPath);
    	this.description = description;
    	this.sv = severity;
    	this.st = State.Open;
    	
    }
    /**
     * Enumeration of possible severity levels for the tickets.
     * 
     * Note: the natural order corresponds to the order of declaration
     */
    public enum Severity { Blocking, Critical, Major, Minor, Cosmetic };
    
    /**
     * Enumeration of the possible valid states for a ticket
     */
    public static enum State { Open, Assigned, Closed }
    
    public int getId(){
        return Id;
    }

    public String getDescription(){
        return description;
    }
    
    public Severity getSeverity() {
        return sv;
    }
    
    public String getMaintainer() {
    	return this.responder;
    }
    public String getAuthor(){
        return author;
    }
    
    public String getComponent(){
        return component.getName();
    }
    
    public State getState(){
        return st;
    }
    
    public String getSolutionDescription() throws TicketException {
        return SolutionDescription;
    }
    
    public void setResponder(String rsp) {
    	this.responder = rsp;
    }
    
    public void setState(State s){
        this.st = s;
    }
    
    public void setSolution(String sol) {
    	this.SolutionDescription = sol;
    }
    public void handle(String username) throws TicketException {
    	if(this.st == State.Closed) {
    		throw new TicketException("ticket is closed");
    	}
    	User u = IssueManager.getInstance().users.get(username);
    	if(u == null) {
    		throw new TicketException("user doesn't exist");
    	}
    	if(!u.getUC().contains(UserClass.Maintainer)) {
    		throw new TicketException("user is not a maintainer");
    	}
    	
    	setResponder(username);
    	setState(State.Assigned);
    }
    
    public void close(String desc) throws TicketException {
    	if(!this.getState().equals(State.Assigned)) {
    		throw new TicketException("Ticket is in the state assinged");
    	}
    	setSolution(desc);
    	IssueManager.getInstance().users.get(getMaintainer()).incrementClosedTickets();
    	this.setState(State.Closed);
    }
}
