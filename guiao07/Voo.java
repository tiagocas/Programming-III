package guiao07;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Voo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3487186049075772748L;
	private String name;
	private Calendar date;
	private String origin;
	private Calendar delay;
	private String obs;
	private String company;
	private int delayInt;
	
	
	
	public Voo(String date, String name, Company company, String origin, String delay, String obs) {
		this.name = name;
		this.origin = origin;
		this.obs = "";
		this.company = "Not Found";
		
		if(company != null) {
			this.company = company.getName();
		}
		
		if(delay.length() != 0) {
			String[] parts = delay.split(":");
			this.delayInt = Integer.parseInt(parts[0])*60 + Integer.parseInt(parts[1]);
		}
		else {
			this.delayInt = 0;
		}
		
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		Date dateD = null;
		Date delayD = null;
		try {
			dateD = df.parse(date);
			if(delay.length() > 0) {
				delayD = df.parse(delay);
			}
			else {
				delayD = df.parse("00:00");
			}
		}
		catch (ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		this.date = Calendar.getInstance();
		this.date.setTime(dateD);
		
		this.delay = Calendar.getInstance();
		this.delay.setTime(delayD);
	
		
		if(delay.length() != 0) {
			Date prevD = null;
			try {
				prevD = df.parse(date);
				Calendar cal = Calendar.getInstance();
				cal.setTime(prevD);
				cal.add(Calendar.HOUR, this.delay.HOUR);
				cal.add(Calendar.MINUTE, this.delay.MINUTE);
				String PREVISTO = df.format(cal.getTime());
				this.obs = "Previsto: " + PREVISTO;
				//prevD = df.parse(String.valueOf(this.date.HOUR) + ":" + String.valueOf(this.date.MINUTE));
			}
			catch (ParseException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			//Calendar prev = Calendar.getInstance();
			//prev.setTime(prevD);
			//prev.add(Calendar.MINUTE, this.delay.MINUTE);
			//prev.add(Calendar.HOUR, this.delay.HOUR);
			//this.obs = "Previsto: " + df.format(prev.getTime());
		}
		
	//	cal.add(Calendar.MINUTE, 70);
	//	String newTime = df.format(cal.getTime());
		//System.out.println(newTime);
	}
	
	public Voo(String date, String name, Company company, String origin) {
		this(date, name, company, origin, "");
	}
	
	public Voo(String date, String name, Company company, String origin, String delay) {
		this(date, name, company, origin, delay, "");
	}
	
	public String getOrigin() {
		return this.origin;
	}
	
	public int getDelay() {
		return this.delayInt;
	}
	
	public String getCompany() {
		return this.company;
	}
	
	public String getCompanySig() {
		return this.name.substring(0,2);
	}
	
	public String getDate(Calendar c) {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		return df.format(c.getTime());
	}
	
	public String toString() {
		String delay = "";
		if(this.getDate(this.delay).compareTo("00:00")!=0) {
			delay = this.getDate(this.delay);
		}
		return String.format("%-8s %-15s %-20s %-10s %-10s %-30s", this.getDate(this.date), this.name, this.company, this.origin, delay, this.obs);
	}
}
