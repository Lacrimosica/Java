package ticketing;

import java.util.Map;
import java.util.TreeMap;

public class Component {
	private String name;
	private Component parent = null;
	private Map<String,Component> subComponents;
	
	
	public Component(String name) {
		this.name = name;
		subComponents = new TreeMap<>();
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public Component getParent() {
		return this.parent;
	}
	
	
	public Map<String ,Component> getSubComponents() {
		return this.subComponents;
	}
	
	
	public void addSubComponent(Component sc) {
		this.subComponents.put(sc.getName(), sc);
		sc.parent = this;
	}
	
	static Component getParent(String p) throws TicketException {
		String[] path = p.split("/");
    	int depth = path.length;
  
    	
    	Component root = IssueManager.getInstance().getComponent(path[1]);
    	
    	for(int i=2; i< depth ; i++) {
    		root = root.getSubComponents().get(path[i]);
    	}
		return root;
	}
	
}
