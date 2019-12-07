package guiao09;

public class Cone extends GeladoDecorator {
	
	public Cone(Gelado gelado) {
		super(gelado);
	}
	
	public void base(int value) {
		super.base(value);
		System.out.print(this.toString());
	}
	
	public String toString() {
		return " em Cone";
	}
	
}
