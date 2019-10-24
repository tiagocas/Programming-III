package guiao05;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface Files {
	public ArrayList<Person> readFromFile(String fileName) throws FileNotFoundException, Exception;
	public void writeToFile(String fileName, ArrayList<Person> pl) throws FileNotFoundException, Exception;
}
