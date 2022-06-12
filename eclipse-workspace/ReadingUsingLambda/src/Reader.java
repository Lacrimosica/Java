import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	public String processFile() throws IOException {
		try(BufferedReader br = new BufferedReader( new FileReader("src/file.txt"))){
			return br.readLine();
		}
	}
}
