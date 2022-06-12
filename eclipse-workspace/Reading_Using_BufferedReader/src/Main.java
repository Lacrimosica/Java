
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br =  new BufferedReader( new FileReader("src/file.txt"));

		String line;
		
	
		
		while((line = br.readLine() ) != null) {
			System.out.println(line);
		}
		
		br.close();
	}

}
