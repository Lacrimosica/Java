package it.polito.oop;

public class Lake {
	
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String Country;
	
	
	public Lake(String name, String country) {
		this.Country = country;
		this.name = name;	
	}
	
	
	@Override
	public String toString() {
		return "Lake " + name;
	}
}
