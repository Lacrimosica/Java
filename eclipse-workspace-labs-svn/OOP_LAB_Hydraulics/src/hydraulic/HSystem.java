package hydraulic;

public class HSystem {
	
	protected Element[] elements = new Element[100];
	protected int count=0;

	public void addElement(Element elem){
	
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
