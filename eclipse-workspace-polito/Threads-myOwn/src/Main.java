import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		
		//making thread : Extending thread class
		//class already made
		Thread t = new X("xxx" , 10);
	
		
		
		//making thread : implementing Runnable
		
		Thread r = new Thread(new Y("yyy" , 10));
//		r.start();
//		t.start();
		
		
		
		//Runnable factory
		
		Thread t1,t2;
		
		t1= new Thread(counting("x", 10));	//passing the runnable function to
		t2= new Thread(counting("y", 10));	//thread constructor
		
//		t1.start();
//		t2.start();
		
		ExecutorService es = Executors.newFixedThreadPool(4);
		es.submit(t);
		es.submit(r);
		
		es.submit(t1);
		es.submit(t2);
		
		
		//also
		try {
			
			
			es.shutdown();			//terminates the execution service
			es.awaitTermination(1000, TimeUnit.MILLISECONDS);
			
			
			es.submit(counting("z", 20));
		}catch(Exception e) {
			System.err.println(e.getCause());
		}
		
	
		
		//executor with future : using callable
			
		Callable<Integer> waitAndReturnSomething =
				() -> { Thread.sleep(2000);
				return 42;
				};	
		ExecutorService es2 = Executors.newCachedThreadPool();
		Future<Integer> answer = es2.submit(waitAndReturnSomething);
		try {
			Integer theAnswer = answer.get();
			System.out.println("Answer is " + theAnswer);
		} catch(Exception e) {
//			e.printStackTrace();
		}
		
		
		
		
	}
	
	//list of callable objects
	void example() throws InterruptedException{
		
		ExecutorService manager = Executors.newFixedThreadPool(2);
		List<Callable<Object>> jobs = new ArrayList<>();
		
		jobs.add(Executors.callable(new Counter("a" , 10)));
		jobs.add(Executors.callable(new Counter("b" , 10)));
		jobs.add(Executors.callable(new Counter("c" , 10)));
		jobs.add(Executors.callable(new Counter("d" , 10)));
		
		manager.invokeAll(jobs);
	
		System.out.println("thants all folks");
		
	}
	
	
	//Runnable factory
	static Runnable counting(String l , int num) {
		return () -> IntStream.range(0, num)
				.mapToObj(i -> l +": " + i+ " ")
				.forEach(System.out::println);
	}
	
}
