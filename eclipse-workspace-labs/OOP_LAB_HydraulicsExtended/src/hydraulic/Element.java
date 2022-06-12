package hydraulic;

public abstract class Element {
	
	protected String name;
	protected double flow=0;
	protected double maxFlow;
	protected Element[] outputs;
	Element input;
	
	public Element(String name){
		this.name = name;
		outputs= new Element[1];
	}
	public Element(String name, int numOutputs) {
		this.name = name;
		outputs = new Element[numOutputs];
	}

	public void setInput(Element elem) {
		input = elem;
	}
	
	public int getOutputNum(Element elem) {
		for(int i=0 ; i< outputs.length; i++) {
			if(outputs[i] != null && elem.equals(outputs[i])) {
				return i;
			}
		}
		return 0;
	}
	public Element getInput() {
		return this.input;
	}
	
	public double getFlow() {
		return flow;
	}

	public void setFlow(double flow) {
		this.flow = flow;
	}

	public String getName(){
		return this.name;
	}
	
	public void connect(Element elem){
		outputs[0] = elem;
		elem.setInput(this);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void connect(Element elem, int index){
		outputs[index].connect(elem);
		elem.setInput(this);
	}
	
	
	public void setOutput(Element value, int idx) {
		this.outputs[idx] = value;
	}
	
	public Element getOutput(){
		return outputs[0];
	}
	
	public Element[] getOutputs(){
		return outputs;
	}
	
	public boolean isDeletable(Element e) {
		if(e instanceof Split) {
			int count=0;
			for(Element ee : e.outputs) {
				if (ee !=null) {
					count++;
				}	
			}
			
			if(count ==1) {
				return true;
			}
		}
		return false;
	}
		
	boolean replaceWith(Element e, Element r) {
		for(int i=0; i<outputs.length; ++i) {
			if(outputs[i] == e) {
				outputs[i] = r;
				if( r != null ) {
					r.setInput(this);
				}
				return true;
			}
		}
		return false;
	}
	
	protected abstract boolean delete();
	protected abstract int visualize(int column_count);
	
	abstract void simulate(double inFlow, SimulationObserver observer);
	abstract void simulate(double inFlow, SimulationObserverExt observer, boolean enableMaxFlowCheck);
	
	
}

