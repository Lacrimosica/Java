package hydraulic;

/**
 * Represents the generic abstract element of an hydraulics system.
 * It is the base class for all elements.
 *
 * Any element can be connect to a downstream element
 * using the method {@link #connect(Element) connect()}.
 */
public class Element {
	//private Element output = null;
	private Element[] outputs;
	
	private String name;
	
	/**
	 * Constructor
	 * @param name the name of the element
	 */
	public Element(String name){
		this.name=name;
		outputs = new Element[1];
	}

	/**
	 * Constructor with generic number of outputs
	 * Visibility: default = package-private
	 * 		 		all classes in the same package can access the method
	 * @param name the name of the element
	 * @param numOutputs the number of outputs
	 */
	
	Element(String name, int numOutputs){
		this.name=name;
		outputs = new Element[numOutputs]; //R2
	}
	
	/**
	 * getter method
	 * @return the name of the element
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Connects this element to a given element.
	 * The given element will be connected downstream of this element
	 * @param elem the element that will be placed downstream
	 */
	public void connect(Element elem){
		//output = elem;
		outputs[0] = elem;
	}
	
	/**
	 * Connects this element to a given element on the specified output.
	 * The given element will be connected downstream of this element
	 * @param elem the element that will be placed downstream
	 * @param index the output of this element that will be connected to elem
	 */
	public void connect(Element elem, int index){
		outputs[index] = elem;
	} // other constructor keeping the old one: source, tap and sink untouched!
	
	/**
	 * Retrieves the element connected downstream of this
	 * @return downstream element
	 */
	public Element getOutput(){
//		return output;
		return outputs[0];
	}
	
	public Element[] getOutputs(){
		return outputs;
	}
	
}
