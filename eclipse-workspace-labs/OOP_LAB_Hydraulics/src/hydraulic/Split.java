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
		super(name, 2);
		//TODO: complete
	}
    
	/**
	 * returns the downstream elements
	 * @return array containing the two downstream element
	 */


    /**
     * connect one of the outputs of this split to a
     * downstream component.
     * 
     * @param elem  the element to be connected downstream
     * @param noutput the output number to be used to connect the element
     */

	@Override
	void simulate(double inFlow, SimulationObserver observer) {
		double outFlow = inFlow/2;

		observer.notifyFlow("Split", getName(), inFlow, outFlow, outFlow);

		for(Element e : getOutputs()){
			e.simulate(outFlow, observer);
		}


	}
}
