
public class X extends Thread {
	
	
	String name;
	int number;
	
	public X(String x, int xx) {
		this.name = x;
		this.number =xx;
	}
	
	public void run() {
		System.out.println("hello world X");
		for(int i= number ; i>0 ; i--) {
			System.out.println(name + " : " + i);
		}
	}
	

}
