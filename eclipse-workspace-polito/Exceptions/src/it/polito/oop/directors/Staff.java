package it.polito.oop.directors;

import java.util.HashSet;
import java.util.Set;

public final class Staff {
	
	private Set<Director> directors;
	static Staff instance =null;
	private Staff() {
		directors = new HashSet<>();
	}
	
	public static Staff getInstance() {
		if(instance == null) {
			instance = new Staff();
		}
		return instance;
	}
	
	public void addDirector(Director director) throws MovieException {
		
		if(director == null) {
			throw new MovieException("NULL director");
		} else if(directors.contains(director)) {
			throw new MovieException("Duplicate director: " + director.getName());
		}
		directors.add(director);
	}
	
	
}
