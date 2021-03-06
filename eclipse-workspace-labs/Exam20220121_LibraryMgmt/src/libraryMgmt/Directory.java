package libraryMgmt;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Directory {

	private static Directory instance;
	
	Map<String, Book> books;
	Map<String, User> users;
	Map<Integer, Loan> loans;
	
	
	
	private Directory() {
		books = new TreeMap<>();
		users = new TreeMap<>();
		loans = new LinkedHashMap<>();
		
	}
	
	public static Directory getInstance() {
		
		if(instance == null) {
			instance = new Directory();
		}
		return instance;
	}
	
	
	
	
	public Loan getLoanByIndex(int index) {
		return getInstance().loans.get(index);
	}
	
	public Book getBook(String name) {
		return getInstance().books.get(name);
	}
	
	public void addBook(Book b) {
		getInstance().books.put(b.getTitle(), b);
	}
	
	public User getUser(String name) {
		return getInstance().users.get(name);
	}
	
	public void addUser(User u) {
		getInstance().users.put(u.getName(), u);
	}
	
	public void addLoan(Loan l) {
		getInstance().loans.put(l.getId(), l);
	}
	
}