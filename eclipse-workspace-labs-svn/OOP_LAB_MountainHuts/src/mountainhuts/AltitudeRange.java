package mountainhuts;

public class AltitudeRange {
	
	private String name;
	private Integer min,max;
	
	public final static AltitudeRange DEFAULT = new AltitudeRange("0-"+Integer.MAX_VALUE);
	
	public AltitudeRange(String name) {
		this.name= name;
		String[] mm= name.split("-");
		this.min = Integer.valueOf(mm[0]);
		this.max = Integer.valueOf(mm[1]);
	}
	
	public boolean includes(Integer n) {
		return n.compareTo(min)> 0 && n.compareTo(max) <=0;
	}
	
	public String toString() {
		return name;
	}
}
