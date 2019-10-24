package guiao05;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class CSV implements Files {

	public ArrayList<Person> readFromFile(String fileName) throws Exception {
		ArrayList<Person> ps = new ArrayList<Person>();
		Scanner sc = new Scanner(new File(fileName));
		sc.nextLine();
		String line;
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			String[] parts = line.split("\t");
			ps.add(new Person(parts[0], parts[1], parts[2]));
		}
		sc.close();
		return ps;
	}

	@Override
	public void writeToFile(String fileName, ArrayList<Person> ps) throws FileNotFoundException, Exception {
		PrintWriter pwf = new PrintWriter(new File(fileName));
		pwf.println("CSV");
		for(int i=0;i<ps.size();i++) {
			pwf.println(ps.get(i).toString("\t"));
		}
		pwf.close();
	}
}
