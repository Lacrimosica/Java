package libraryMgmt;
import java.util.*;

import static java.util.stream.Collectors.*;
import java.time.*;

public class LibraryMgmt {
	
	public static int bookCounter = 1;
	public static int loanCounter = 1;

	public Map<String, Book> books;
	
	
	public LocalDate date;
	//R0
	/**
	 * Defines the current date
	 * @param date current date
	 */
	public void setCurrentDate(LocalDate date) {
		this.date = date;
		
	}

	/**
	 * retrieves current library system date
	 * @return current date
	 */
	public LocalDate getCurrentDate () {
		return this.date;
	}
	/**
	 * Moves current date forward
	 * @param nOfDays number of days forward
	 */
	public void addDays (long nOfDays) {
		date = this.date.plusDays(nOfDays);
	}


	//R1
	/**
	 * Add a new book with corresponding volumes
	 * 
	 * @param title    title of the book
	 * @param nVolumes number of volumes available
	 * @param authors  list of authors
	 * @return volume index range
	 * @throws LMException
	 */
	public String addBook(String title, int nVolumes, String... authors) throws LMException {
		List<String> authList = new ArrayList<>();
		
		if(Directory.getInstance().getBook(title) != null) {
			throw new LMException();
		}
		
		for(String s: authors) {
			authList.add(s);
		}
		
		Book b = new Book(bookCounter, title, nVolumes, authList);
		Directory.getInstance().addBook(b);
		
		int lowerIndex = bookCounter;
		int upperIndex = bookCounter+ nVolumes -1;
		bookCounter+= nVolumes;
		return lowerIndex+":"+ upperIndex;
	}

	/**
	 * Adds a new user with relative parameters
	 * 
	 * @param name
	 * @param maxNofBooks
	 * @param duration
	 * @return
	 * @throws LMException
	 */
	public String addUser (String name, int maxNofBooks, int duration) throws LMException {
		if(Directory.getInstance().getUser(name) != null) {
			throw new LMException();
		}
		User u = new User(name, maxNofBooks , duration);
		Directory.getInstance().addUser(u);
		
		return u.toString();
	}

	//R2
	/**
	 * Adds a new volume loan in the system.
	 * 
	 * @param user : user name
	 * @param title: book title
	 * @return loan index
	 * @throws LMException
	 */
	public int addLoan (String user, String title) throws LMException {
		
		User u = Directory.getInstance().getUser(user);
		Book b = Directory.getInstance().getBook(title);
		
		
		if(!u.canLoan()) {
			throw new LMException();
		}
		
		if(!b.isAvailable()) {
			throw new LMException();
		}
		
		int volIndex = b.getAvailable();
		
		Loan l = new Loan(loanCounter, getCurrentDate(), u, b, volIndex);
		
		Directory.getInstance().addLoan(l);
		
		
		return loanCounter++;
	}

	/**
	 * Retrieves loan information
	 * 
	 * @param loanIndex
	 * @return information as string
	 */
	public String getLoanInfo (int loanIndex) {
		
		Loan l = Directory.getInstance().getLoanByIndex(loanIndex);
		return l.getInfo(getCurrentDate());
	}

	/**
	 * Closes a loan
	 * 
	 * @param loanIndex loan index
	 * @return loan return date
	 */
	public LocalDate closeLoan (int loanIndex)  { //throws LMException
		
		Loan l = Directory.getInstance().getLoanByIndex(loanIndex);
		l.closeLoan(getCurrentDate());
		return getCurrentDate();
	}


	/**
	 * Retrieves number of volumes currently on loan to user
	 * @param user
	 * @return number of volumes
	 */
	public int numberOfBooks (String user) {
		return Directory.getInstance().getUser(user).getNumBooks();
	}

	//R3  statistics

	/**
	 * Returns map of authors grouped by title
	 * 
	 * @return map title -> author list
	 */
	public TreeMap<String, ArrayList<String>> authorsByTitle() {
		TreeMap<String, ArrayList<String>> result = new TreeMap<>();
		Directory.getInstance().books.forEach( (key,val) -> { ArrayList<String> a = new ArrayList<>(val.getAuthors()); result.put(key, a);});
		return result;
	}


	/**
	 * Retrieves total loans for users (including closed ones)
	 * 
	 * @return map user -> loan number
	 */
	public TreeMap<String, Integer> numberOfTotalLoansByUser() {
		return Directory.getInstance().users.values().stream().filter(user -> user.getTotalLoans() > 0).collect(toMap(u-> u.getName(), u -> u.getTotalLoans(), (a,b) -> a , TreeMap::new));
	}

	//R4  queries

	/**
	 * returns the list of loans whose due date is equal to the current date.
	 * 
	 * @return list of loan indexes
	 */
	public List<Integer> dailyOverdue(){
		return Directory.getInstance().loans.values().stream().filter(l -> l.getDueDate().equals(getCurrentDate())).map(Loan::getId).collect(toList());
	}

	/**
	 * returns the average delay of loan returns for given user
	 * @param userName
	 * @return
	 */
	public double averageDelay(String userName) {
		return Directory.getInstance().getUser(userName).getLoans().stream().filter( l -> !l.getState().equals("ongoing")).collect(averagingDouble(Loan::getDelay));
	}

	/**
	 * returns the number of volumes available for the book with the given title
	 * @param title
	 * @return number of available volumes
	 */
	public long availableVolumes(String title) {
		return Directory.getInstance().getBook(title).getNumAvailable();
	}


}
