package libraryMgmt;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;


public class Book {
	private int id;
	
	private String title;
	private int nVol;
	
	private SortedSet<String> authors;

	private Map< Integer ,Boolean> volsAvailable;

	public Book(int id, String title,
			int nVol, 
			List<String> authors) {
		this.id = id;
		this.title = title;
		this.nVol = nVol;
		this.authors = new TreeSet<>(authors);
		volsAvailable = new LinkedHashMap<>();
		
		for(int i=id ; i< id+ nVol ; i++) {
			volsAvailable.put(i, true);
		}
				
	}
	public Map<Integer,Boolean> getVolsAvailable(){
		return this.volsAvailable;
	}
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getnVol() {
		return nVol;
	}

	public SortedSet<String> getAuthors() {
		return authors;
	}
	
	public void loan(int volIndex) {
		this.volsAvailable.put(volIndex, false);
	}
	
	public void close(int vol) {
		this.volsAvailable.put(vol, true);
	}
	
	public boolean isAvailable() {
		
		for(int i=this.id ; i< this.id + nVol ; i++) {
			if(volsAvailable.get(i)) {
				return true;
			}
		}
		return false;
	}
	
	public int getAvailable() {
		for(Entry<Integer,Boolean> e : volsAvailable.entrySet()) {
			if(e.getValue() == true) {
				return e.getKey();
			}
		}
		return 0;
	}

	public int getNumAvailable() {
		int counter=0;
		for(Boolean b : this.volsAvailable.values()) if(b) counter++;
		return counter;
	}
	
}