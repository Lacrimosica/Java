package hydraulic;

public class Multisplit extends Split {
	private int numOutputs;
	private double[] flowRate;
	
	
	public Multisplit(String name, int numOutput) {
		super(name , numOutput); 
		this.numOutputs = numOutput;
		flowRate = new double[numOutput];
	}
    
    public Element[] getOutputs(){
        return this.outputs;
    }

	public void connect(Element elem, int noutput){
		this.outputs[noutput] = elem;
	}

	public void setProportions(double... proportions) {
		double checksum=0;
		
		
		for(int i=0 ; i< proportions.length ; i++) {
			if(checksum + proportions[i] <= 1.0) {
				flowRate[i] = proportions[i];	
			}else {
				System.out.println("proportions are more than unit");
			}
		}
	}

	@Override
	protected int visualize(int column_count) {
		String output = " [" + getName() + "]Multisplit";
		System.out.print(output);
		
		int padding=0;

		int i=0;

		for(int j=0 ; j< numOutputs  ; j++) {
			
			Element e = outputs[j];
			
			if(e != null) {
				System.out.print("+-> " + this.flowRate[j]*100 + "% ");

				padding = e.visualize(column_count + output.length());
				System.out.println("");
				
				for(i=0; i< padding ; i++) {
					System.out.print(" ");
				}
				
				if(j < outputs.length -1) {
					System.out.println("|");
				}
				
				for(i=0; i< padding ; i++) {
					System.out.print(" ");
				}
			}			
		}
		
		return column_count + padding;
		
	}
	@Override
	void simulate(double inFlow, SimulationObserver observer) {
		double outFlows[] = new double[numOutputs];
		
		for(int i=0; i< numOutputs ; i++) {
			if(outputs[i] != null) {
				outFlows[i] = inFlow * flowRate[i];
				outputs[i].simulate(outFlows[i], observer);
			}
		}

		observer.notifyFlow("MS plit", getName(), inFlow, outFlows);
	}
	
	@Override
	protected void simulate(double inFlow , SimulationObserverExt observer, boolean enableMaxFlowCheck) {
		double outFlows[] = new double[numOutputs];
	
		if(enableMaxFlowCheck && inFlow >maxFlow) {
			observer.notifyFlowError("Split", getName(), inFlow, maxFlow);
		}
		
		for(int i=0; i< numOutputs ; i++) {
			if(outputs[i] != null) {
				outFlows[i] = inFlow * flowRate[i];
				outputs[i].simulate(outFlows[i], observer, enableMaxFlowCheck);
			}
		}
	}
}
