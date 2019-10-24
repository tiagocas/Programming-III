package guiao05;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class vCard implements Files {
	
	public ArrayList<Person> readFromFile(String fileName) throws Exception {
		ArrayList<Person> ps = new ArrayList<Person>();
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
		sc.nextLine();
		String line;
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			String[] parts = line.split("#");
			ps.add(new Person(parts[1], parts[2], parts[3]));
		}
		sc.close();
		return ps;
	}

	@Override
	public void writeToFile(String fileName, ArrayList<Person> ps) throws FileNotFoundException, Exception {
		PrintWriter pwf = new PrintWriter(new File(fileName));
		pwf.println("vCard");
		for(int i=0;i<ps.size();i++) {
			pwf.println("#" + ps.get(i).toString("#"));
		}
		pwf.close();		
	}
	
}
