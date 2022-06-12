package it.polito.oop;

public class Coffee {
	
	private String type;
	private String brand;
	private double intensity;
	
	public Coffee(String type) {
		this.type = type;
		
	}

	public double getIntensity() {
		return intensity;
	}

	public void setIntensity(double intensity) {
		this.intensity = intensity;
	}

	public String getType() {
		return type;
	}

	public String getBrand() {
		return brand;
	}
	
	
	

}
