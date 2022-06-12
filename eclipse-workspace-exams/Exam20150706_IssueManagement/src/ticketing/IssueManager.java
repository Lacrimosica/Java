package ticketing;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;


public class IssueManager {
	
	
//	SortedMap<String, User> maintainers = new TreeMap<>();
//	SortedMap<String, User> reporters = new TreeMap<>();

	public static int ticketCount = 1;
	public static IssueManager instance;
	SortedMap<String, User> users ;
	Map<String, Component> components;
	List<Ticket> tickets;
	
	public IssueManager() {
		users = new TreeMap<>();
		components = new TreeMap<>();
		tickets = new LinkedList<>();
	}
	
	
	public static IssueManager getInstance() {
		if(instance == null) {
			instance = new IssueManager();
		}
		return instance;
	}
    /**
     * Eumeration of valid user classes
     */
	public static enum UserClass {
        /** user able to report an issue and create a corresponding ticket **/
        Reporter, 
        /** user that can be assigned to handle a ticket **/
        Maintainer }
    
    /**
     * Creates a new user
     * 
     * @param username name of the user
     * @param classes user classes
     * @throws TicketException if the username has already been created or if no user class has been specified
     */
    public void createUser(String username, UserClass... classes) throws TicketException {
    	
        if(users.containsKey(username)) {
        	throw new TicketException("user name already exists");
        }
        
        if(classes.length == 0 ) {
        	throw new TicketException("user class not specified");
        }
        
        Set<UserClass> ucs = new TreeSet<>();;
        for(UserClass uc: classes) {
        	ucs.add(uc);
        }
        
        User u = new User(username, ucs);
        IssueManager.getInstance().users.put(username, u);
    }

    /**
     * Creates a new user
     * 
     * @param username name of the user
     * @param classes user classes
     * @throws TicketException if the username has already been created or if no user class has been specified
     */
    public void createUser(String username, Set<UserClass> classes) throws TicketException {
    	 if(users.containsKey(username)) {
         	throw new TicketException("user name already exists");
         }
         
         if(classes.size() == 0 ) {
         	throw new TicketException("user class not specified");
         }
         
         User u = new User(username, classes);
         IssueManager.getInstance().users.put(username, u);
    }
   
    /**
     * Retrieves the user classes for a given user
     * 
     * @param username name of the user
     * @return the set of user classes the user belongs to
     */
    public Set<UserClass> getUserClasses(String username){
    	User u = IssueManager.getInstance().users.get(username);
    	return u.getUC();
    }
    
    /**
     * Creates a new component
     * 
     * @param name unique name of the new component
     * @throws TicketException if a component with the same name already exists
     */
    
    
    public User getUser(String username) {
    	return users.get(username);
    }
    public Component getComponent(String name) {
    	return components.get(name);
    }
    public void defineComponent(String name) throws TicketException {
        if(components.containsKey(name)) {
        	throw new TicketException("component with the exact same name ealready exists");
        }
        
        Component c = new Component(name);
        IssueManager.getInstance().components.put(name, c);
    }
    
    /**
     * Creates a new sub-component as a child of an existing parent component
     * 
     * @param name unique name of the new component
     * @param parentPath path of the parent component
     * @throws TicketException if the the parent component does not exist or 
     *                          if a sub-component of the same parent exists with the same name
     */
    public void defineSubComponent(String name, String parentPath) throws TicketException {
    	if(components.containsKey(name)) {
    		throw new TicketException("component already exists");
    	}
    	Component sc = new Component(name);
    	Component parent = Component.getParent(parentPath);
    	parent.addSubComponent(sc);
    	IssueManager.getInstance().components.put(name, sc);
    }
    
    /**
     * Retrieves the sub-components of an existing component
     * 
     * @param path the path of the parent
     * @return set of children sub-components
     * @throws TicketException 
     */
    public Set<String> getSubComponents(String path) throws TicketException{
    	Component p = Component.getParent(path);
    	
    	if(p.getSubComponents().isEmpty()) {
    		System.err.println("Component has no subComponents");
    		return null;
    	}
    	
    	return p.getSubComponents().keySet();
    }

    /**
     * Retrieves the parent component
     * 
     * @param path the path of the parent
     * @return name of the parent
     * @throws TicketException 
     */
    public String getParentComponent(String path) throws TicketException{
    	Component p = Component.getParent(path);
    	if(p.getParent() == null) {
    		return null;
    	}
       	return p.getParent().getName();
      }

    /**
     * Opens a new ticket to report an issue/malfunction
     * 
     * @param username name of the reporting user
     * @param componentPath path of the component or sub-component
     * @param description description of the malfunction
     * @param severity severity level
     * 
     * @return unique id of the new ticket
     * 
     * @throws TicketException if the user name is not valid, the path does not correspond to a defined component, 
     *                          or the user does not belong to the Reporter {@link IssueManager.UserClass}.
     */
    
    public int openTicket(String username,
    		String componentPath,
    		String description, 
    		Ticket.Severity severity) 
    					throws TicketException {
    	
    	User u = IssueManager.getInstance().getUser(username);
    	if(u == null){
    		throw new TicketException("username non-existant, can't open ticket");
    	}
    	
    	if(!u.getUC().contains(UserClass.Reporter)) {
    		throw new TicketException("User is not a reporter");
    	}
    	
    	Ticket t = new Ticket(ticketCount, username, componentPath, description, severity);
    	IssueManager.getInstance().tickets.add(t);
    	ticketCount++;
    	return ticketCount-1;
    }
    
    /**
     * Returns a ticket object given its id
     * 
     * @param ticketId id of the tickets
     * @return the corresponding ticket object
     */
    public Ticket getTicket(int ticketId){
        return IssueManager.getInstance().tickets.get(ticketId-1);
    }
    
    /**
     * Returns all the existing tickets sorted by severity
     * 
     * @return list of ticket objects
     */
    public List<Ticket> getAllTickets(){
    	return tickets;
    }
    
    /**
     * Assign a maintainer to an open ticket
     * 
     * @param ticketId  id of the ticket
     * @param username  name of the maintainer
     * @throws TicketException if the ticket is in state <i>Closed</i>, the ticket id or the username
     *                          are not valid, or the user does not belong to the <i>Maintainer</i> user class
     */
    public void assingTicket(int ticketId, String username) throws TicketException {
       IssueManager.getInstance().getTicket(ticketId).handle(username);
    }

    /**
     * Closes a ticket
     * 
     * @param ticketId id of the ticket
     * @param description description of how the issue was handled and solved
     * @throws TicketException if the ticket is not in state <i>Assigned</i>
     */
    public void closeTicket(int ticketId, String description) throws TicketException {
    	IssueManager.getInstance().getTicket(ticketId).close(description);
    }

    /**
     * returns a sorted map (keys sorted in natural order) with the number of  
     * tickets per Severity, considering only the tickets with the specific state.
     *  
     * @param state state of the tickets to be counted, all tickets are counted if <i>null</i>
     * @return a map with the severity and the corresponding count 
     */
    public SortedMap<Ticket.Severity,Long> countBySeverityOfState(Ticket.State state){
    	
    	return IssueManager.getInstance().tickets.stream()
    		.filter( t-> t.getState().equals(state) || t.getState().equals(null))
    			.collect(groupingBy(Ticket::getSeverity 
    					,TreeMap::new,  
    					counting()));
 
    }

    /**
     * Find the top maintainers in terms of closed tickets.
     * 
     * The elements are strings formatted as <code>"username:###"</code> where <code>username</code> 
     * is the user name and <code>###</code> is the number of closed tickets. 
     * The list is sorter by descending number of closed tickets and then by username.

     * @return A list of strings with the top maintainers.
     */
    public List<String> topMaintainers(){
    	return IssueManager.getInstance().users.values()
    			.stream()
    			.sorted(comparing( (User u) -> u.getClosedTickets() )
    					.reversed()
    					.thenComparing(User::getUsername))
    					.map(u ->  u.getUsername() + ":" + u.getClosedTickets() ) 
    						.collect(toList());
    }

}
