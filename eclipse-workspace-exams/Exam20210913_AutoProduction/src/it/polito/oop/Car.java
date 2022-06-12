package it.polito.oop;

public class Car {
	private String model;
	private String name;
	private	int year;
	private float engineSize;
	private int engineType;
	
	
	public Car(String model,
			String name,
			int year,
			float engineSize,
			int engineType) {
		super();
		this.model = model;
		this.name = name;
		this.year = year;
		this.engineSize = engineSize;
		this.engineType = engineType;
	}
	
	
	public String getModel() {
		return model;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public float getEngineSize() {
		return engineSize;
	}

	public int getEngineType() {
		return engineType;
	}


	@Override
	public String toString() {
		return model +"," + name + "," + year + "," + engineSize +  "," + engineType; 
	}
	
	
}
