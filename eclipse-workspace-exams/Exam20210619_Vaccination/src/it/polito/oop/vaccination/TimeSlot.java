package it.polito.oop.vaccination;

public class TimeSlot {
	int hour;
	int min;
	
	public String toString() {
		return String.format("%02d:%02d", hour, min);
	}
	
	public TimeSlot(int h, int m) {
		this.hour = h; 
		this.min = m;
	}

	public void setMin(int min) {
		this.min = min;
	}
	
	
	public int getMin() {
		return  min;
	}
	
}
