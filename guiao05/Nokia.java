package guiao05;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Nokia implements Files {
	
	public ArrayList<Person> readFromFile(String fileName) throws Exception {
		ArrayList<Person> ps = new ArrayList<Person>();
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
		sc.nextLine();
		String line;
		String parts[] = new String[4];
		int count = 0;
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			parts[count] = line;
			if(line.length() == 0) {
				count = -1;
				ps.add(new Person(parts[0], parts[1], parts[2]));
			}
			
			count++;
		}
		sc.close();
		return ps;
	}

	@Override
	public void writeToFile(String fileName, ArrayList<Person> ps) throws FileNotFoundException, Exception {
		PrintWriter pwf = new PrintWriter(new File(fileName));
		pwf.println("Nokia");
		for(int i=0;i<ps.size();i++) {
			pwf.println(ps.get(i).toString("\n") + "\n");
		}
		pwf.close();
	}
}
