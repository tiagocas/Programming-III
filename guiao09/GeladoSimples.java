package guiao09;

public class GeladoSimples implements Gelado {
	private String sabor;
	private int value;
	
	public GeladoSimples(String sabor) {
		this.sabor = sabor;
	}

	@Override
	public void base(int value) {
		this.value = value;
		System.out.print("\n" + this.toString());
	}
	
	public String toString() {
		String b = "bolas";
		if(value == 1) {
			b = "bola";
		}
		return value + " " + b + " de gelado de " + sabor;
	}

}
