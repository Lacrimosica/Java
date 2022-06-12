package hydraulic;

/**
 * Represents a split element, a.k.a. T element
 * 
 * During the simulation each downstream element will
 * receive a stream that is half the input stream of the split.
 */

public class Split extends Element {

	/**
	 * Constructor
	 * @param name
	 */
	public Split(String name) {
//		super(name);
		super(name,2);
	}
    
	//Safely commented, I implemented this methods in Element
	//So Split will inherit this methods
//	/**
//	 * returns the downstream elements
//	 * @return array containing the two downstream element
//	 */
//    public Element[] getOutputs(){
//    		//TODO: complete
//        return null;
//    }
//
//    /**
//     * connect one of the outputs of this split to a
//     * downstream component.
//     * 
//     * @param elem  the element to be connected downstream
//     * @param noutput the output number to be used to connect the element
//     */
//	public void connect(Element elem, int noutput){
//		//TODO: complete
//	}
	
	@Override //R4
	void simulate(double inFlow, SimulationObserver observer) {
		double outFlow = inFlow/2;
//		System.out.println("Source " + getName() + ": flow=" + inFlow);
//		System.out.println(" : out flow=" + outFlow);

		observer.notifyFlow("Split", getName(), inFlow, outFlow);

		for(Element e : getOutputs()){
			e.simulate(outFlow, observer);
		}
	}
}
