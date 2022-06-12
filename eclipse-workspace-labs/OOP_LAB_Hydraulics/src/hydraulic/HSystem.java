package hydraulic;

public class HSystem {
	
	private Element[] elements = new Element[100];
	private int count=0;

	public void addElement(Element elem){
		// TODO: to be implemented
		elements[count++] = elem;
	}

	public Element[] getElements(){
		Element[] result = new Element[count];
		//Element[] result=null;
		for(int i =0; i<result.length; ++i){
			result[i] = elements[i];
		}
		return result;
	}

	public void simulate(SimulationObserver observer){
		for(Element e : elements){
			if( e != null && e instanceof Source){
				e.simulate(-1,observer);
			}
		}
	}

}
