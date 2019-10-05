package guiao03;

public class Quadrado implements Figure {
	Point p1, p2, p3, p4;
	
	public Quadrado(double l) {
		this.p1 = new Point(0, 0);
		this.p2 = new Point(0, l);
		this.p3 = new Point(l, l);
		this.p4 = new Point(l, 0);
	}
	
	public Quadrado(double px1, double py1, double l) {
		this.p1 = new Point(px1, py1);
		this.p2 = new Point(px1, py1 + l);
		this.p3 = new Point(px1 + l, py1 + l);
		this.p4 = new Point(px1 + l, py1);
	}

	public Quadrado(Quadrado q) {
		this.p1 = q.p1();
		this.p2 = q.p2();
		this.p3 = q.p3();
		this.p4 = q.p4();
	}
	
	public boolean equals(Quadrado q) {
		return this.p1.equals(q.p1) && this.p2.equals(q.p2) && this.p3.equals(q.p3) && this.p4.equals(q.p4);
	}
	
	public double area() {
		return this.p1.distance(this.p2) * this.p1.distance(this.p2);
	}
	
	public double perimetro() {
		return this.p1.distance(this.p2)*4;
	}
	
	public String toString() {
		return "Quadrado -> P1: " + this.p1.toString() + ", P2: " + this.p2.toString() + ", P3: " + this.p3.toString() + ", P4: " + this.p4.toString() + " ";
	}
	
	public Point p1() {
		return this.p1;
	}
	
	public Point p2() {
		return this.p2;
	}
	
	public Point p3() {
		return this.p3;
	}
	
	public Point p4() {
		return this.p4;
	}
	
}
