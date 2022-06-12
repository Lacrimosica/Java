package hydraulic;

public abstract class ElementExt extends Element{

	public ElementExt(String name) {
		super(name);
	}
	
	public ElementExt(String name, int numOutput) {
		super(name, numOutput);
	}

	public void setMaxFlow(double maxFlow) {
		System.out.println( getName()+" max flow set to " +  maxFlow);
		this.maxFlow = maxFlow;
	}
	
	

}
