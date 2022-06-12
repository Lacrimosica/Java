import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Stream;

import it.polito.oop.Trader;
import it.polito.oop.Transaction;



public class TraderTestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		
		
		List<Transaction> transactions = Arrays.asList(
		new Transaction(brian, 2011, 300),
		new Transaction(raoul, 2012, 1000),
		new Transaction(raoul, 2011, 400),
		new Transaction(mario, 2012, 710),
		new Transaction(mario, 2012, 700),
		new Transaction(alan, 2012, 950)
		);
	

	
	
	
	//1-find all transacion in the year 2011 and sort them by value (small to high);
	
	List<Transaction> tr2011 = 
			transactions.stream().filter(t -> t.getYear() == 2011)
			.sorted(comparing(Transaction::getValue))
			.collect(toList());
	
	for(Transaction t: tr2011) {
		System.out.println(t);
	}
	System.out.println("22222222222222222222222222222");
	//2-what are all the unique cities where the traders work;
	
	//this is how to make a stream out of objects
//	Stream<Trader> traders = Stream.of(raoul, mario , alan, brian);
	
//	List<String> uniqcities = 
//			traders.map(Trader::getCity).distinct().collect(toList());
	
	
	
	//alternative solution:
	
	List<String> citiesList = 
								transactions.stream()
								.map(transaction -> transaction.getTrader().getCity())
								.distinct()
								.collect(toList());
		
	
	
	//you can drop distinct too and use to set instead of it
	Set<String> citiesSet =
							
							transactions.stream()
							.map(transaction -> transaction.getTrader().getCity())
							.collect(toSet());
					
	
//	System.out.println(uniqcities);
	
	System.out.println("333333333333333333333333333333");
	//3-find all traders from Cambridge and sort them by name.
	
//	List<Trader> tradersSorted =
//			traders.filter(n -> n.getName() == "Cambridge").sorted(comparing(Trader::getName)).collect(toList());
	
	//alternative solution
	
	List<Trader> tradersFromCambridgeSorted = 
			transactions
			.stream()
			.map(Transaction::getTrader)
			.filter(trader -> trader.getCity().equals("Cambridge"))
			.distinct()
			.sorted(comparing(Trader::getName))
			.collect(toList());
	
	System.out.println("444444444444444444444444444");
	//4-return a string of all traders' names sorted alphabetically
		
	String names = 
			transactions.stream()
			.map(trans -> trans.getTrader().getName())
			.distinct()
			.sorted()
			.reduce("" , (n1, n2) -> n1 + n2);
		
	
	
	//other solution
	
	String namesOptimizedSol = transactions.stream()
			.map(trans -> trans.getTrader().getName())
			.distinct()
			.sorted()
			.collect(joining());
	
	System.out.println("5555555555555555555555555555555555555");
	//5-are any traders based on milan;  
//	if(traders.anyMatch(t -> t.getCity() == "Milan")) {
//		System.out.println("there exist traders based in milan");
//	}
	
	//alternative solution
	
	transactions.stream()
	.anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
	
	System.out.println("666666666666666666666666666666666");
	//6-print values of all transactions from the traders living in Cambridge

//	List<Transaction> trtrcam =
			transactions.stream()
			.filter(trans -> trans.getTrader().getCity().equals("Cambridge"))
			.forEach(System.out::println);	
			
			//alternative solution
	
			transactions.stream()
			.filter(trans -> "Cambridge".equals(trans.getTrader().getCity()))
			.forEach(System.out::println);
	
			
			
			System.out.println("7777777777777777777777777777");
	//7-what's the highest value of all transactions;
	Optional<Integer> maximum_trans = transactions.stream()
			.map(Transaction::getValue)
			.reduce(Integer::max);
	
	
	//alternative
	
OptionalInt max_trans_val_int = 
			transactions.stream()
			.mapToInt(Transaction::getValue)
			.max();
	
	
	
	System.out.println("888888888888888888888888888");
	//8-find the transaction with the smallest value;
	
	
	Optional<Transaction> minimum_trans = 
			transactions.stream()
			.reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
	
	
	//alternative soution
	
	
	Optional<Transaction> minimum_transOpt =
			transactions.stream()
			.min(comparing(Transaction::getValue));
	
	
}}
