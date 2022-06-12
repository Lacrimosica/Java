package hydraulic;

public abstract class Split extends Element {

	public Split(String name) {
		super(name, 2);
	}
	
	public Split(String name, int numOutput) {
		super(name , numOutput); 
	}
    
	@Override
	void simulate(double inFlow, SimulationObserver observer) {
		double outFlow = inFlow/2;

		observer.notifyFlow("Split", getName(), inFlow, outFlow, outFlow);

		for(Element e : getOutputs()){
			e.simulate(outFlow, observer);
		}


	}
}
