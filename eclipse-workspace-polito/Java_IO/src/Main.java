import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import it.polito.oop.Lake;

public final class Main {
	
	static final String FILE_NAME = "foo.txt";
	static final String DUMP_NAME = "dump.dat";
	static final String GOOGLE = "http://www.google.com/";
	static final String POLITO = "https://www.polito.it/";
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
			
			Main m = new Main();
					
			
			Lake l2 = m.readObject(DUMP_NAME); 
			
			Path d = Paths.get("data");
			
			int maxLen = 0 ; 
			if(Files.exists(d)) {
				maxLen = Files.lines(d).	//creates a stream from a file
				mapToInt(String::length).
				max().getAsInt();
				
			}
			
			//writing an object
//			FileOutputStream raw = new FileOutputStream(DUMP_NAME);
//			ObjectOutputStream dump = new ObjectOutputStream(raw);
//			Lake l1 = new Lake("Tahoe", "neverland");
//			System.out.println(11);
//			dump.writeObject(l1);
//			dump.close();
			
		}
	
	
	Lake readObject(String fileName) throws ClassNotFoundException, IOException{
		
		Lake lake ;
		
		FileInputStream raw = new FileInputStream(fileName);
		ObjectInputStream dump = new ObjectInputStream(raw);
		
		lake  = (Lake) dump.readObject();
		return lake;
	}
	
	void dumpObject(Lake lake) throws IOException {
		System.out.println("dumping " + lake);
		try(ObjectOutputStream dump = new ObjectOutputStream(new FileOutputStream(DUMP_NAME))){
			dump.writeObject(lake);
		}
	
		
	}
	
	
	String readLine(Reader r) throws IOException {
		char ch = (char) r.read();;
		StringBuffer res = new StringBuffer();
		
		
		while( ch != -1) {
			if( ch == '\n') break;
			if( ch !='\r') res.append(ch);
			ch = (char) r.read();
	}
		
		return res.toString();
		

	}
	
	
	void urlTest() throws IOException {
		URL page = new URL(POLITO);
		InputStreamReader in = new InputStreamReader(page.openStream());
		BufferedReader br = new BufferedReader(in);
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}

	void utf8Test() throws IOException {
		Reader file = new FileReader(FILE_NAME);
		int raw;

		System.out.println(java.nio.charset.Charset.defaultCharset() + "\n");

		for (int t = 0; t < 4; ++t) {
			raw = file.read();
			char rune = (char) raw;
			System.out.println(rune + "\t(" + raw + ")");
		}

	}
}
 