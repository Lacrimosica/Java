package it.polito.oop;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	
	public String procesSFile() throws IOException {
		try(BufferedReader br= new BufferedReader(new FileReader("data.txt"))) {
			return br.readLine();
		}
	}
}
