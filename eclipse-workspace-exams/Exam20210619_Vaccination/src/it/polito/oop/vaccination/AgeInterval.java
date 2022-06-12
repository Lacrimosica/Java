package it.polito.oop.vaccination;

public class AgeInterval {
	
	int min;
	int max;
	String infinity;
	String boundary;
	
	public AgeInterval(int a, int b) {
		this.min = a;
		this.boundary = "[" +a +","+b+ ")";
		this.max = b;
	}
	public AgeInterval(int a) {
		this.min = a;
		this.boundary = "[" +a +","+ "+)";
		this.max = Integer.MAX_VALUE;
	}
	public AgeInterval(String label) {
		String[] vals = label.split(",");
		this.min = (int) vals[0].charAt(1);
		if(vals[1].charAt(0) == '+') {
			this.max = Integer.MAX_VALUE;
		}else {
			this.max = vals[1].charAt(0);
		}
	}
	
	
	public int getMin() {
		return this.min;
	}
	
	public String toString() {
		return this.boundary;
	}
}

