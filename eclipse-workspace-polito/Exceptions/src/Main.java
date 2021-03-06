
import it.polito.oop.directors.*;

public class Main {

	public static void main(String[] args) throws MovieException {
		
		Main ta = new Main();
		ta.addJapaneseDirector(); 
		Staff.getInstance().addDirector(null);
		Staff.getInstance().addDirector(new Director("Stanley Kubrick"));
		Staff.getInstance().addDirector(new Director("Sergio Leone"));
//		Staff.getInstance().addDirector(new Director("Stanley Kubrick"));
	}
	
	
	
	void addEnglishDirector() throws MovieException{
		Staff staff = Staff.getInstance();
		Staff.getInstance().addDirector(new Director("Sergio Leone"));
	}
	void addJapaneseDirector() throws MovieException{
		Staff staff = Staff.getInstance();
		
		try {
			
			Staff.getInstance().addDirector(new Director("Akira Korosava"));
		}
	}
	void addItalianDirectors() throws MovieException{
		Staff staff = Staff.getInstance();
		Staff.getInstance().addDirector(new Director("Sergio Leone"));
	}
	
	

}
 