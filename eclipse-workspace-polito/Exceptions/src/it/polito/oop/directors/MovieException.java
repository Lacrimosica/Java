package it.polito.oop.directors;

public class MovieException extends Exception{
	private static final long serialVersionUID = 1L;

	public String problem;
	public MovieException(String problem) {
		super();
		this.problem = problem;
	}
	
	
}
