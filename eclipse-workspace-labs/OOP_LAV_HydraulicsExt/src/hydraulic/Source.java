package hydraulic;

/**
 * Represents a source of water, i.e. the initial element for the simulation.
 *
 * The status of the source is defined through the method
 * {@link #setFlow(double) setFlow()}.
 */
public class Source extends Element {

	private double flow;
	public Source(String name) {
		super(name);
		//TODO: complete
	}

	/**
	 * defines the flow produced by the source
	 * 
	 * @param flow
	 */
	public void setFlow(double flow){
		//TODO: complete
		this.flow = flow;

	}

	@Override
	void simulate(double inFlow, SimulationObserver observer) {
		observer.notifyFlow("Source",getName(),SimulationObserver.NO_FLOW, flow);
		getOutput().simulate(flow,observer);	
	}
	
	
	
}
