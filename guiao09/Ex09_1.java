package guiao09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex09_1 {

	public static void main(String[] args) throws IOException {
		
		String fileName = "src/guiao09/testFile.txt";
		testFile(new File(fileName));
		
		testPalavraPalavra(new FileInputStream(fileName));
		testLinhaLinha(new FileInputStream(fileName));
		testLinhaLinha(System.in);
		
	}
	
	public static void testPalavraPalavra(InputStream input) throws IOException {
		ScannerAbeirense sc = new ScannerAbeirense(input);
		System.out.println("\nPALAVRA A PALAVRA...");
		while(sc.hasNext()) {
			System.out.println(sc.next());
		}
		sc.close();
	}
	public static void testLinhaLinha(InputStream input) throws IOException {
		System.out.println("\nLINHA A LINHA...");
	
		ScannerAbeirense  sc = new ScannerAbeirense(input);
			
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		sc.close();
	}
	
	public static void testFile(File f) throws FileNotFoundException, IOException {
		testPalavraPalavra(new FileInputStream(f.getAbsolutePath()));
		testLinhaLinha(new FileInputStream(f.getAbsolutePath()));
	}

}
