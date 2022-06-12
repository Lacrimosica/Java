package hydraulic;

import javax.swing.text.ElementIterator;

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
	
	
	/**
	 * Constructor
	 * @param name the name of the element
	 */
	
	public Element(String name){
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

	public String getName(){
		return this.name;
	}
	
	public void connect(Element elem){
		outputs[0] = elem;
	}
	
	public void connect(Element elem, int index){
		outputs[index] = elem;
	}

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
