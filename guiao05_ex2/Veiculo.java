package guiao05_ex2;
import java.text.*;
import java.util.Date;

import guiao04.Figura;

public abstract class Veiculo implements IVeiculos ,Comparable<Veiculo>{
	private String name;
	private Date dateOfBuy;
	private double height;
	private double width;
	
	public Veiculo(String name, double height, double width, String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.dateOfBuy = dateFormat.parse(date);
		}
		catch(ParseException e) {
			try {
				dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				this.dateOfBuy = dateFormat.parse(date);
			}
			catch(ParseException e2) {
				System.out.println("Objeto nao reconhecido por causa da data");
			}
		}
		this.name = name;
		this.height = height;
		this.width = width;
	}
	
	public int compareTo(Veiculo v) {
		if(this.dateOfBuy.compareTo(v.dateOfBuy)>0) {
			return 1;
		}
		else if(this.dateOfBuy.compareTo(v.dateOfBuy)<0) {
			return -1;
		}
		return 0;
	}
	
	public String toString() {
		return "name: " + this.name + StringFormat.downAndSpace()
		+ "Date: " + this.getDateUTC() + StringFormat.downAndSpace()
		+ "height:" + this.height + " m" + StringFormat.downAndSpace()
		+ "width: " + this.width + " m" + StringFormat.downAndSpace();
 	}
	
	public Date getDate() {
		return this.dateOfBuy;
	}
	
	public String getDateUTC() {
		SimpleDateFormat dateformat3 = new SimpleDateFormat("dd-MM-yyyy");
		return dateformat3.format(this.dateOfBuy);
	}
	
	public String getName() {
		return this.getName();
	}
}
