package hydraulic;

/**
 * Represents a tap that can interrupt the flow.
 * 
 * The status of the tap is defined by the method
 * {@link #setOpen(boolean) setOpen()}.
 */

public class Tap extends ElementExt {
	
	boolean open = false;
	
	public Tap(String name) {
		super(name);
		//TODO: complete
	}

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
	
	@Override
	protected int visualize(int coln) {
		int res = 0;
		
		String output = " [" + getName() + "]Tap "+ " -> ";
		System.out.print(output);
		if(this.getOutput() != null) {
			res = this.getOutput().visualize(coln+ output.length());
		}else {
			res = output.length() + coln;
		}
	
		
		return res;
	}

	@Override
	protected boolean delete() {
		this.getInput().replaceWith(this, this.getOutput());
		return true;
	}

	@Override
	void simulate(double inFlow, SimulationObserverExt observer, boolean enableMaxFlowCheck) {
		double outFlow = (open ? inFlow: 0);
		if(enableMaxFlowCheck && inFlow > maxFlow) {
			observer.notifyFlowError("Tap", getName(), inFlow,  maxFlow);
		}
		observer.notifyFlow("Tap", getName(), inFlow, outFlow);
		
	}

}
