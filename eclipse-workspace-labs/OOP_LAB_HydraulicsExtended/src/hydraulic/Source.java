package hydraulic;


public class Source extends ElementExt {

	private double flow;
	public Source(String name) {
		super(name);
	
	}
	
	public void setFlow(double flow){
		this.flow = flow;

	}

	@Override
	void simulate(double inFlow, SimulationObserver observer) {
		observer.notifyFlow("Source",getName(),SimulationObserver.NO_FLOW, flow);
		getOutput().simulate(flow,observer);	
	}

	@Override
	protected int visualize(int coln) {
		String output = "[" + getName() + "]Source"+ " -> ";
		
		System.out.print(output);
		
		outputs[0].visualize(coln + output.length());
		
		return output.length();
	}

	@Override
	protected boolean delete() {
		this.setName("Deleted");
//		this.getOutput().setInput(null);
		return true;
	}
	
	@Override 
	public void setMaxFlow(double maxFlow) {
		
	}

	@Override
	void simulate(double inFlow, SimulationObserverExt observer, boolean enableMaxFlowCheck) {
		observer.notifyFlow("Source",getName(),SimulationObserver.NO_FLOW, flow);
		getOutput().simulate(flow,observer, enableMaxFlowCheck);	
	}
		
		
}
