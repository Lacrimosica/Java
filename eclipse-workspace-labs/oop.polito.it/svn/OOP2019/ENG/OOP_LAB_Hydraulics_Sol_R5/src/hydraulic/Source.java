package hydraulic;

/**
 * Represents a source of water, i.e. the initial element for the simulation.
 *
 * The status of the source is defined through the method
 * {@link #setFlow(double) setFlow()}.
 */
public class Source extends Element {

	private double flow; //R4
	
	public Source(String name) {
		super(name);
	}

	/**
	 * defines the flow produced by the source
	 * 
	 * @param flow
	 */
	public void setFlow(double flow){ //R4
		this.flow = flow;
	}
	
	@Override //R4
	void simulate(double inFlow, SimulationObserver observer) {
		//System.out.println("Source " + getName() + ": flow=" + flow);
		observer.notifyFlow("Source",getName(),SimulationObserver.NO_FLOW, flow);
		getOutput().simulate(flow,observer);
		
	}
	
	@Override //R5
	StringBuffer layout(String pad) {
		StringBuffer res = new StringBuffer();
		res.append("[").append(getName()).append("]Source -> ");
		res.append( getOutput().layout(blanks(res.length())) );
		return res;
	}
	
}
