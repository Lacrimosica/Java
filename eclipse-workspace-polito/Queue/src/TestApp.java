import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TestApp {

	
	static final long ELEMENTS= 100000;
	
	public static void main(String[] args) {
		TestApp ta = new TestApp();
		ta.queue();
	}
	
	
	//can only be done with linked list and not arraylist
	void queue() {
		Queue<String> beatles;
		System.out.println("*FIFO*");
		beatles = new LinkedList<>();
		beatles.add("john");
		beatles.add("Ringo");
		beatles.add("Paul");
		beatles.add("George");
		
		while(!beatles.isEmpty()) {
			System.out.println(beatles.poll());
		}
		System.out.println("--------");
		System.out.println(beatles.poll());
		System.out.println("--------");
		
		System.out.println("*Priority Queue*");
		beatles = new PriorityQueue<>();
		beatles.add("john");
		beatles.add("Ringo");
		beatles.add("Paul");
		beatles.add("George");
		
		while(!beatles.isEmpty()) {
			System.out.println(beatles.poll());
		}
		System.out.println("--------");
		System.out.println(beatles.poll());
		System.out.println("--------");
		
		
		System.out.println("*Priority Queue with different comparison*");
		beatles = new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				return Integer.compare(arg0.hashCode(), arg0.hashCode());
			}
		});
		
		beatles.add("john");
		beatles.add("Ringo");
		beatles.add("Paul");
		beatles.add("George");
		beatles.forEach( s -> System.out.println(s.toString() + " " + s.hashCode()));
		while(!beatles.isEmpty()) {
			System.out.println(beatles.poll());
		}
		System.out.println("--------");
		System.out.println(beatles.poll());
		System.out.println("--------");
	}
}
