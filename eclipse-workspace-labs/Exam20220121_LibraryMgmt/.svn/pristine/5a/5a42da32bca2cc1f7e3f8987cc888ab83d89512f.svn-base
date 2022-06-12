package libraryMgmt;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;



public class Loan {
	private User user;
	private Book book;
	private int id;
	private int volIndex;
	private String title;
	private LocalDate startDate;
	private LocalDate dueDate;
	private LocalDate returnDate;
	private boolean isLate;
	private boolean closed;
	private String state;
	private double delay;
	
	public enum State{
		ONGOING, OVERDUE
	}
	
	public Loan(int id, LocalDate startDate, User u , Book b, int volIndex) {
		this.id= id;
		this.closed = false;	
		this.user = u;	
		this.book = b;	
		this.startDate = startDate;	
		this.dueDate = startDate.plusDays(u.getMaxdays());	
		this.returnDate = null;	
		this.isLate = false;	
		this.title = b.getTitle();	
		this.state = "ongoing";	
		this.delay = 0.0;
		this.volIndex = volIndex;
		b.loan(volIndex);	
		u.loan(this);
		
	}
	public int getId() {
		return id;
	}

	public int getVolIndex() {
		return volIndex;
	}

	public String getTitle() {
		return title;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public boolean isLate() {
		return isLate;
	}
	
	public double getDelay() {
		return this.delay;
	}
	
	public String getState() {
		return this.state;
	}
	
	public void closeLoan(LocalDate returnDate) {
		this.closed = true;
		this.returnDate = returnDate;
		this.user.close();
		this.book.close(this.volIndex);
		this.state="closed";
		if(returnDate.isAfter(dueDate)) {
			this.isLate = true;
			this.delay = dueDate.until(returnDate, ChronoUnit.DAYS);
		}
	}
		
	

	public String getInfo(LocalDate date) {
		if(date.isAfter(this.getDueDate()) && !closed) {
			this.isLate = true;
			this.state = "overdue";
		}
		return this.user.getName() +":" + this.getId() + ":" + this.volIndex +":" +this.dueDate + ":" +  this.state; 
	}
	

}
