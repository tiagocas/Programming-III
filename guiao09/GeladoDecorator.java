package guiao09;

public class GeladoDecorator implements Gelado {
	protected Gelado g;
	
	public GeladoDecorator(Gelado gelado) {
		this.g = gelado;
	}
	
	public void base(int n) {
		g.base(n);
	}
	
	public String toString() {
		return g.toString();
	}

}
