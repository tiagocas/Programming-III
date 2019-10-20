package guiao05;
import java.time.LocalDate; // Import the LocalDateTime class

public class Aviao extends Motorizado  {
	private String name;
	private LocalDate dateOfBuy;
	private double length;
	private double width;
	
	public Aviao(String name, String buy, double length, double width) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	public int getPotencia() {
		return 0;
	}
	
	public int getConsumo() {
		return 0;
	}
	
	public int getCombustivel() {
		return 0;
	}
	
	
}
