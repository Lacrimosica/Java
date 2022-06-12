package hydraulic;

/**
 * Represents a multisplit element, an extension of the Split that allows many outputs
 * 
 * During the simulation each downstream element will
 * receive a stream that is determined by the proportions.
 */

public class Multisplit extends Split {

	/**
	 * Constructor
	 * @param name
	 * @param numOutput
	 */
	public Multisplit(String name, int numOutput) {
		super(name , numOutput); 
		
	}
    
    public Element[] getOutputs(){
    	
        return this.outputs;
    }

	public void connect(Element elem, int noutput){
		this.outputs[noutput] = elem;
	}
	

	public void setProportions(double... proportions) {
		System.out.println(proportions);
	}
}
