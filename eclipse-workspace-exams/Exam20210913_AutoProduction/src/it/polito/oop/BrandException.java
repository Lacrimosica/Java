package it.polito.oop;

public class BrandException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BrandException() {
		super("generic exception");
	}
	
	public BrandException(String msg) {
		super(msg);
	}
	
}
