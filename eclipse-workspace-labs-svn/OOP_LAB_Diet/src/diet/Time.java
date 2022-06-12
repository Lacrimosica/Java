package diet;

public  class Time implements Comparable<Time>{
	int hour;
	int minute;
	
	Time(int hour, int minute){
		this.hour =hour;
		this.minute = minute;
	}
	
	Time(String time){
		String[] hAndM = time.split(":");
		int h = Integer.valueOf(hAndM[0]);
		int m = Integer.valueOf(hAndM[1]);
		this.hour =h;
		this.minute = m;
	}

	@Override
	public int compareTo(Time o) {
		return 60*hour+minute - (60*o.hour+o.minute);
	}
	
	public String toString() {
		return String.format("%02d:%02d", hour,minute);
	}
}
