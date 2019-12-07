package guiao09;

public class Topping extends GeladoDecorator {
	private String ingrediente;

	public Topping(Gelado gelado, String ingrediente) {
		super(gelado);
		this.ingrediente = ingrediente;
	}
	
	public void base(int n) {
		super.base(n);
		System.out.print(toString());
	}
	
	public String toString() {
		return " com " + this.ingrediente;
	}

}
