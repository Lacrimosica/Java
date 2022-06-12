package hydraulic;

/**
 * Represents a tap that can interrupt the flow.
 * 
 * The status of the tap is defined by the method
 * {@link #setOpen(boolean) setOpen()}.
 */

public class Tap extends Element {
	boolean open = false;
	
	public Tap(String name) {
		super(name);
		//TODO: complete
	}
	
	/**
	 * Defines whether the tap is open or closed.
	 * 
	 * @param open  opening level
	 */
	public void setOpen(boolean open){
		//TODO: complete
		this.open = open;
	}
	
	@Override
	void simulate(double inFlow, SimulationObserver observer) {
		double outFlow = (open?inFlow:0);
		observer.notifyFlow("Tap",getName(),inFlow, outFlow);
		getOutput().simulate(outFlow,observer);	
	}

}
