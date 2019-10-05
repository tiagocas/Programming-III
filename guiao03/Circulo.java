package guiao03;

public class Circulo implements Figure {
	private Point middle;
	private double r;
	
	public Circulo(double r) {
		this.r = r;
		this.middle = new Point(0, 0);
	}
	
	public Circulo(double x, double y, double r) {
		this.r = r;
		this.middle = new Point(x, y);
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
	
	public boolean equals(Circulo c) {
		return this.middle.equals(c.middle) && this.r == c.r;
	}
	
	public String toString() {
		return "Circulo -> Middle point: " + this.middle.toString() + ", radius: " + this.r + " ";
	}
	
	public Point middle() {
		return this.middle;
	}
	
}
