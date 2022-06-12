import java.io.IOException;

import it.polito.oop.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Reader r = new Reader();
		r.procesSFile();
		
		
		String result = processFile( (BufferedReader br) -> br.readLine() + br.readLine());
	}

	private static String processFile(BufferedReader br) {
		// TODO Auto-generated method stub
		return null;
	}

}
