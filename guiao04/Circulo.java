package guiao04;

public class Circulo extends Figura {
	private Ponto middle;
	private double r;
	
	public Circulo(double r) {
		this.r = r;
		this.middle = new Ponto(0, 0);
	}
	
	public Circulo(double x, double y, double r) {
		this.r = r;
		this.middle = new Ponto(x, y);
	}
	
	public Circulo(Circulo c) {
		this.r = c.r;
		this.middle = c.middle;
	}
	
	public double area() {
		return Math.PI * this.r * this.r;
	}
	
	public double perimetro() {
		return 2 * Math.PI * this.r;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!o.getClass().equals(this.getClass())) {
			return false;
		}
		Circulo c = (Circulo)o;
		return this.middle.equals(c.middle) && this.r == c.r;
	}
	
	public String toString() {
		return "Circulo de centro " + this.middle.toString() + " e de raio " + this.r;
	}
	
	public Ponto middle() {
		return this.middle;
	}
	
}
