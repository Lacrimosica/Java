package hydraulic;

/**
 * Represents a tap that can interrupt the flow.
 * 
 * The status of the tap is defined by the method
 * {@link #setOpen(boolean) setOpen()}.
 */

public class Tap extends Element {

	private boolean open; //R4
	
	public Tap(String name) {
		super(name);
	}
	
	/**
	 * Defines whether the tap is open or closed.
	 * 
	 * @param open  opening level
	 */
	public void setOpen(boolean open){ //R4
		this.open = open;
	}


	@Override //R4
	void simulate(double inFlow, SimulationObserver observer) {
		double outFlow = (open?inFlow:0);
//		System.out.println("Tap " + getName() + ": in flow=" + inFlow);
//		System.out.println(" out flow=" + outFlow);

		observer.notifyFlow("Tap",getName(),inFlow, outFlow);

		getOutput().simulate(outFlow,observer);
		
	}
	

	@Override //R5
	StringBuffer layout(String pad) {
		StringBuffer res = new StringBuffer();
		res.append("[").append(getName()).append("]Tap -> ");
		res.append( getOutput().layout( pad + blanks(res.length()) ) );
		return res;
	}
	
}
