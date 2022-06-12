package hydraulic;

public class Split extends ElementExt {

	public Split(String name) {
		super(name, 2);
	}
	
	public Split(String name, int numOutput) {
		super(name , numOutput); 
	}
    


	@Override
	protected int visualize(int column_count) {
		String output = " [" + getName() + "]Split";
		System.out.print(output);
		
		int padding=0;

		int i=0;
		
		for(Element e: this.outputs) {
			
			System.out.print("+->");
			
			
			padding = e.visualize(column_count + output.length());
			System.out.println(" ");
			
			for(i=0; i< padding ; i++) {
				System.out.print(" ");
			}
			
			System.out.println("|");
			
			for(i=0; i< padding ; i++) {
				System.out.print(" ");
			}
			
		}
		
		return column_count + padding;
		
	}
	

	
	
	
	@Override
	protected boolean delete() {
		if(this.isDeletable(this)) {
			for(Element e : outputs) {
				this.input.connect(e, this.getOutputNum(e));
				return true;
			}
		}
		System.out.println("this Split can't be deleted");
		return false;
	}
	
	
	@Override
	void simulate(double inFlow, SimulationObserver observer) {
		double outFlow = inFlow/2;

		observer.notifyFlow("Split", getName(), inFlow, outFlow, outFlow);

		for(Element e : getOutputs()){
			e.simulate(outFlow, observer);
		}
	}
	
	@Override
	protected void simulate(double inFlow , SimulationObserverExt observer, boolean enableMaxFlowCheck) {
		double outFlow = inFlow/2;
	
		if(enableMaxFlowCheck && inFlow >maxFlow) {
			observer.notifyFlowError("Split", getName(), inFlow, maxFlow);
		}
		
		for(Element element : getOutputs()) {
			element.simulate(outFlow, observer, enableMaxFlowCheck);
		}
	}
}
