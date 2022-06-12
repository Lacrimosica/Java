package hydraulic;

/**
 * Represents the generic abstract element of an hydraulics system.
 * It is the base class for all elements.
 *
 * Any element can be connect to a downstream element
 * using the method {@link #connect(Element) connect()}.
 */
public abstract class Element {
	String name;
	double flow=0;
	Element[] outputs;
	
	public Element(String name){
		// TODO: to be implemented
		this.name = name;
		outputs= new Element[1];
	}
	public Element(String name, int numOutputs) {
		this.name = name;
		outputs = new Element[numOutputs];
	}

	public double getFlow() {
		return flow;
	}

	public void setFlow(double flow) {
		this.flow = flow;
	}

	/**
	 * getter method
	 * @return the name of the element
	 */
	public String getName(){
		// TODO: to be implemented
		return this.name;
	}
	
	/**
	 * Connects this element to a given element.
	 * The given element will be connected downstream of this element
	 * @param elem the element that will be placed downstream
	 */
	public void connect(Element elem){
		// TODO: to be implemented
		outputs[0] = elem;
	}
	
	public void connect(Element elem, int index){
		// TODO: to be implemented
		outputs[index] = elem;
	}
	
	/**
	 * Retrieves the element connected downstream of this
	 * @return downstream element
	 */
	public Element getOutput(){
		// TODO: to be implemented
		return outputs[0];
	}
	
	public Element[] getOutputs(){
		// TODO: to be implemented
		return outputs;
	}
	
	
	abstract void simulate(double inFlow, SimulationObserver observer);
	}
