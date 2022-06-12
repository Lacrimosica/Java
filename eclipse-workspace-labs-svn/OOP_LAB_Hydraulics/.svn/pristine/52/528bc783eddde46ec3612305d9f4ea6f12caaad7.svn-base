package hydraulic;

public class Sink extends ElementExt {

	
	public Sink(String name) {
		super(name);
	}

	@Override
	protected int visualize(int coln) {
		String output = " [" + getName() + "]Sink";
		System.out.print(output);
		return coln; 
		
	}


	@Override
	protected boolean delete() {
		this.setName("Deleted");
		this.input.getName();
		return true;
	}

	
	
	@Override
	void simulate(double inFlow, SimulationObserver observer) {
		observer.notifyFlow("Sink", getName(), inFlow, SimulationObserver.NO_FLOW);
	}
	
	@Override
	void simulate(double inFlow, SimulationObserverExt observer, boolean enableMaxFlowCheck) {
		if(enableMaxFlowCheck && inFlow > maxFlow) {
			observer.notifyFlowError("Sink", getName(), inFlow, maxFlow);
		}
		observer.notifyFlow("Sink", getName(), inFlow, SimulationObserver.NO_FLOW);
		
	}
}
