package guiao09;

public class Copo extends GeladoDecorator {
	
	public Copo(Gelado g) {
		super(g);
	}
	
	public void base(int value) {
		super.base(value);
		System.out.print(this.toString());
	}
	
	public String toString() {
		return " em Copo";
	}
	
}
