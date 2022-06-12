package hydraulic;

import javax.lang.model.util.Elements;

public class HSystemExt extends HSystem{
	
	/**
	 * Prints the layout of the system starting at each Source
	 */
	public String layout(){
		// TODO: to be implemented
		return null;
	}
	
	public boolean deleteElement(String name) {
		Element[] result = new Element[count];
		int idx=0;
		for( Element e : this.elements) {
			if ( !(e.getName().equals(name) ) ){
				result[idx++]= e;
				}
			}
		if(idx != count) {
			count=idx;
			return false;
		}
		return true;
	}

	/**
	 * starts the simulation of the system; if enableMaxFlowCheck is true,
	 * checks also the elements maximum flows against the input flow
	 */
	public void simulate(SimulationObserverExt observer, boolean enableMaxFlowCheck) {
		for(Element e: elements) {
			if(e !=null && e instanceof Source) {
				e.simulate(-1, observer);
			}
		}
	}
	
}
