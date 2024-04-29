package ex03;

import java.io.FileWriter;
import java.io.IOException;

public class SimpleWrite {
	public static void main(String[] args) {
		
		try {
		FileWriter out = new FileWriter("c:/upload/data.txt");
		out.write('A');
		out.write('B');
		out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
