package guiao07;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Aeroporto {
	private ArrayList<Voo> voos;
	private	Companies companies;
	
	public Aeroporto(String flightsFile, String companiesFile) throws IOException {
		
		companies = loadCompanies(companiesFile, "\t");
		voos = loadFlights(flightsFile, "\t", companies);
		
	}
	
	public void saveTableToFile(String file) {
		this.saveToFile(file, this.showFlights());
	}
	
	public void saveCitiesToFile(String file) {
		this.saveToFile(file, this.getFlightsOrigin());
	}
	
	public static String loadFromBinFile(String file) throws IOException {
		String content = "";
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		int fileSize = (int) new File(file).length();
		byte[] bytes = new byte[fileSize];
		if(file.length() > 0) {
			raf.readFully(bytes);
			content = new String(bytes);
		}
		raf.close();
		return content;
	}
	
	public void savePublicInfoToFile(String file) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		raf.write(this.showFlights().getBytes());
		raf.close();
		System.out.println("File  \"" + file + "\"  atualizado");
	}
	
	public String getFlightsOrigin() {
		String content = "";
		HashMap<String, Integer> hm = new HashMap();
		ArrayList al = new ArrayList();
		
		for(int i=0;i<this.voos.size();i++) {
			Voo voo = this.voos.get(i);
			if(hm.containsKey(voo.getOrigin())) {
				hm.put(voo.getOrigin(), hm.get(voo.getOrigin()) + 1);
			}
			else {
				hm.put(voo.getOrigin(), 1);
				al.add(voo.getOrigin());
			}
		}
		
		String[][] grid = new String[al.size()][2];
		for(int i=0;i<al.size();i++) {
			grid[i][0] = (String) al.get(i);
			grid[i][1] = String.valueOf(hm.get(al.get(i)));
		}
		
		// bubble sort
		Boolean cont = true;
		while(cont) {
			cont = false;
			for(int i=0;i<al.size()-1;i++) {
				if(Integer.parseInt(grid[i][1]) > Integer.parseInt(grid[i+1][1])) {
					String city = grid[i][0];
					String num = grid[i][1];
					grid[i][0] = grid[i+1][0];
					grid[i][1] = grid[i+1][1];
					grid[i+1][0] = city;
					grid[i+1][1] = num;
				}
			}
		}
		
		// get content
		String formatString = "%-15s%-10s\n";
		content += String.format(formatString, "Origem", "Voos");
		if(al.size()==0) {
			return "No flights found";
		}
		for(int i=0;i<al.size();i++) {
			content += String.format(formatString, grid[i][0], grid[i][1]);
		}		
		return content;
	}
	
	private void saveToFile(String file, String content) {
		try {
			FileWriter out = new FileWriter(new File(file));
			String flights = content;
			out.write(flights);
			out.close();
			System.out.println("Ficheiro  \"" + file + "\"  atualizado");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String calculateDelays() {
		String resp = "";
		String keys[] = this.companies.keys();
		HashMap<String, ArrayList<Voo>> hm = new HashMap<String,ArrayList<Voo>>();
		for(int i=0;i<this.voos.size();i++) {
			Voo voo = this.voos.get(i);
			if(voo.getDelay() != 0) {
				ArrayList<Voo> al = new ArrayList<Voo>();
				if(hm.containsKey(voo.getCompanySig())) {
					al = hm.get(voo.getCompanySig());	
				}
				al.add(voo);
				hm.put(voo.getCompanySig(), al);
			}
		}
		for(int i=0;i<keys.length;i++) {
			if(hm.containsKey(keys[i])) {
				int delayInt = 0;
				ArrayList<Voo> auxAl = hm.get(keys[i]);
				for(int j=0;j<auxAl.size();j++) {
					delayInt += auxAl.get(j).getDelay();
				}
				resp += keys[i] + "\t" + delayInt/auxAl.size() + "\n";
			}
		}
		return resp;
	}
	
	private Companies loadCompanies(String file, String sep) throws IOException {
		List<String> companies = Files.readAllLines(Paths.get(file));
		Companies c = new Companies();
		for(int i=1;i<companies.size();i++) {
			String parts[] = companies.get(i).split(sep);
			c.addCompany(parts[0], parts[1]);
		}
		return c;
	}
	
	private ArrayList<Voo> loadFlights(String file, String sep, Companies companies) throws IOException {
		List<String> flights = Files.readAllLines(Paths.get(file));
		ArrayList<Voo> list = new ArrayList<Voo>();
		for(int i = 1 ; i < flights.size() ; i++) {
			String parts[] = flights.get(i).split(sep);
			String sig = parts[1].substring(0, 2);
			Company company = companies.getCompany(sig);
			if(parts.length == 3) {
				list.add(new Voo(parts[0], parts[1], company, parts[2]));
			}
			else if(parts.length == 4) {
				list.add(new Voo(parts[0], parts[1], company, parts[2], parts[3]));
			}
			else if(parts.length == 5) {
				list.add(new Voo(parts[0], parts[1], company, parts[2], parts[3],  parts[4]));
			}
			
		}
		return list;
	}	
	
	public String showFlights() {
		String str = String.format("%-8s %-15s %-20s %-10s %-10s %-30s\n", "Hora","Voo", "Companhia", "Origem", "Atraso", "Obs");
		for(int i=0;i<this.voos.size();i++) {
			str += this.voos.get(i).toString() + "\n";
		}
		return str;
	}
	
}
