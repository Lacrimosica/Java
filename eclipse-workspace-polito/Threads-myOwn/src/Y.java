
public class Y implements Runnable {
	String name;
	int number;
	
	public Y(String x, int xx) {
		this.name = x;
		this.number =xx;
	}
	@Override
	public void run() {
		System.out.println("hello world Y");
		for(int i= number ; i>0 ; i--) {
			System.out.println(name + " : " + i);
		}
	}
	

}
