package Collatz;

import java.io.IOException;
import Collatz.CollatzConjecture;

public class driver{

	public static void main(String[] args) throws IOException, InterruptedException{
		
		ProcessBuilder pb = new ProcessBuilder("java","-cp",
				"C:\\Users\\Ryan\\Desktop\\workspace\\Operating Systems\\bin",
				CollatzConjecture.class.getName()).inheritIO();

		Process process = pb.start();
		process.waitFor();
		
		
	
	}
	

}
