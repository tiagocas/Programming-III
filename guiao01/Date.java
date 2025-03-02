package guiao01;
import java.util.Scanner;

public class Date {
	private int day;
	private int month;
	private int year;
	private static int[] monthsWith31 = {1,3,5,7,8,10,12};
	private static int[] monthsWith30 = {4,6,9,11};
	
	static Scanner input = new Scanner(System.in);
	public Date(int day, int month, int year) {
		if(validDate(day,month,year)) {
			this.day = day;
			this.month = month;
			this.year = year;
		}
		else {
			System.out.print("Invalid Date");
		}
	}
	
	public Date(String date) {
		String sep = ",";
		if(date.contains("/")) {
			sep = "/";
		}
		else if(date.contains("-")) {
			sep = "-";
		}
		String[] part = date.split(sep);
		
		int day = 0;
		int month = 0;
		int year = 0;
		try {
			day = Integer.valueOf(part[0]);
			month = Integer.valueOf(part[1]);
			year = Integer.valueOf(part[2]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid Date");
		}
		
		if(validDate(day,month,year)) {
			this.day = day;
			this.month = month;
			this.year = year;
		}
		else {
			System.out.printf("Invalid Date\n");
		}		
	}
	
	public static Date getDate(String phrase) {
		boolean err = true;
		while(err) {
			System.out.println(phrase);
			String date = input.nextLine();
			String sep = ",";
			if(date.contains("/")) {
				sep = "/";
			}
			else if(date.contains("-")) {
				sep = "-";
			}
			String[] part = date.split(sep);
			
			int day = 0;
			int month = 0;
			int year = 0;
			try {
				day = Integer.valueOf(part[0]);
				month = Integer.valueOf(part[1]);
				year = Integer.valueOf(part[2]);
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Invalid Date");
			}
			
			if(validDate(day,month,year)) {
				return new Date(date);
			}
			else {
				System.out.printf("Invalid Date\n");
				System.out.println("Want to quit? [y/n]");
				String option = input.nextLine().toLowerCase();
				switch(option) {
				case "y":
					err = false;
					break;
				case "n":
					break;
				default:
					System.out.println("Command not recognized so action was canceled");
					err = false;
					break;
				}
			}
			
		}
		return null;
	}
	
	public int day() {
		return this.day;
	}
	
	public int month() {
		return this.month;
	}
	
	public int year() {
		return this.year;
	}
	
	public static boolean validDate(int day, int month, int year) {
		if(day > 0 && day < monthNumberOfDays(month, year)) {
			if(month > 0 && month <= 12) {
				return true;
			}
		}
		return false;
	}
	public static int monthNumberOfDays(int month, int year) {
		if(month == 2){
			if(isBissextus(year)){
				return 29;
			}
			else {
				return 28;
			}
		}
		for(int i = 0; i < monthsWith31.length; i++) {
			if(monthsWith31[i] == month) {
				return 31;
			}
		}
		
		for(int k = 0; k < monthsWith30.length; k++) {
			if(monthsWith31[k] == month) {
				return 30;
			}
		}
		return 0;
	}
	public static boolean isBissextus(int year) {
		if ((year % 400 == 0) || ((year % 4 == 0) && !(year % 100 == 0))) {   
			return true;
		}
		else {
			return false;
		}
	}

	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}
	public String toString(String sep) {
		return this.day + sep + this.month + sep + this.year;
	}
	
}
