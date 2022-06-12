package hydraulic;

public class HSystemExt extends HSystem{
	
	public String layout(){
		
		for(Element e: this.elements) {
			if(e != null  && e instanceof Source) {
				e.visualize(0);
			}
		}
		return "";
	}
	
	
	
	public boolean deleteElement(String name) {
		for(Element e: elements) {
			if( e!= null && e.getName().equals(name)) {
				
				if(e.delete()) {
					System.out.println("element deleted succesffuly");
					return true;
					}
			}
		}
		return false;
	}
	
	public void simulate(SimulationObserverExt observer, boolean enableMaxFlowCheck) {
		for(Element e: elements) {
			if(e !=null && e instanceof Source) {
				e.simulate(-1, observer, enableMaxFlowCheck);
			}
		}
	}
	
}
