package guiao09;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;

public class ScannerAbeirense implements Iterator<String>, Closeable {
	private Scanner input;

	public ScannerAbeirense(InputStream input) {
		this.input = new Scanner(input);
	}
	
	@Override
	public void close() throws IOException {
		this.input.close();
	}

	@Override
	public boolean hasNext() {
		return this.input.hasNext();
	}
	
	public boolean hasNextLine() {
		return this.input.hasNextLine();
	}

	@Override
	public String next() {
		return replace(this.input.next());
	}
	
	public String nextLine() {
		return replace(this.input.nextLine());
		
	}
	
	public String replace(String s) {
		s = s.replace("v", "b");
		s = s.replace("V", "B");
		return s;
	}

}
