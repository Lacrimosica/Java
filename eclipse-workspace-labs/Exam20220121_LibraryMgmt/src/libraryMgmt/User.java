package libraryMgmt;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class User {

	private String name;
	private int maxBooks;
	private int maxdays;
	private int numBooks;
	private int totalLoans;
	private Map<Integer, Loan> loans;
	

	public User(String name, int maxBooks, int maxdays) {
		this.name = name;
		this.maxBooks = maxBooks;
		this.maxdays = maxdays;
		this.numBooks = 0;
		this.totalLoans = 0;
		loans = new LinkedHashMap<>();
	}
	public List<Loan> getLoans(){
		return new ArrayList<>(loans.values());
	}
	public String getName() {
		return name;
	}

	public int getMaxBooks() {
		return maxBooks;
	}


	public int getMaxdays() {
		return maxdays;
	}
	
	public int getTotalLoans(){
		return this.totalLoans;
	}
	
	public void loan(Loan l) {
		totalLoans++;
		numBooks ++;
		loans.put(l.getId(), l);
	}

	
	public boolean canLoan() {
		boolean maxed = true;
		boolean notLate = true;
		if(numBooks < maxBooks) {
			maxed = false;
		}
		
		for(Loan l : loans.values()) {
			if(l.isLate()) {
				notLate = false;
			}
		}
		
		return !maxed && notLate;
	}


	
	public int getNumBooks() {
		return numBooks;
	}

	public void setNumBooks(int numBooks) {
		this.numBooks = numBooks;
	}

	public void close() {
		numBooks--;
		
	}
	@Override
	public String toString() {
		return name + ":" + maxBooks + ":" + maxdays;
	}
}