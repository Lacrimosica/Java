package hydraulic;

/**
 * Represents the sink, i.e. the terminal element of a system
 *
 */
public class Sink extends Element {

	/**
	 * Constructor
	 * @param name
	 */
	public Sink(String name) {
		super(name);
	}
	
	@Override
	public void connect(Element elem){
		// no effect!
	}
	
	@Override //R4
	void simulate(double inFlow, SimulationObserver observer) {
		//System.out.println("Sink " + getName() + ": flow=" + inFlow);
		
		observer.notifyFlow("Sink", getName(), inFlow, SimulationObserver.NO_FLOW);

	}
	
	@Override //R5
	StringBuffer layout(String pad) {
		StringBuffer res = new StringBuffer();
		res.append("[").append(getName()).append("]Sink |");
		return res;
	}

}
