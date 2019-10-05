package guiao03;

public class Rectangulo implements Figure {
	private Point p1, p2, p3, p4;
	
	public Rectangulo(double x, double y) {
		this.p1 = new Point(0, 0);
		this.p2 = new Point(x, 0);
		this.p3 = new Point(x, y);
		this.p4 = new Point(0, y);
	}
	
	public Rectangulo(double px1, double py1, double px3, double py3) {
		this.p1 = new Point(px1, py1);
		this.p3 = new Point(px3, py3);
		if(px1 > px3) {
			this.p2 = new Point(this.p1.x() , this.p3.y());
			this.p4 = new Point(this.p3.x() , this.p1.x());
		}
		else {
			this.p2 = new Point(this.p3.x() , this.p1.x());
			this.p4 = new Point(this.p1.x() , this.p3.x());
		}
	}

	public Rectangulo(Rectangulo q) {
		this.p1 = q.p1;
		this.p2 = q.p2;
		this.p3 = q.p3;
		this.p4 = q.p4;
	}
	
	public boolean equals(Rectangulo q) {
		return this.p1.equals(q.p1) && this.p2.equals(q.p2) && this.p3.equals(q.p3) && this.p4.equals(q.p4);
	}
	
	public double area() {
		return this.p1.distance(this.p2) * this.p2.distance(p3);
	}
	
	public double perimetro() {
		return this.p1.distance(this.p2) * 2 + this.p2.distance(p3)*2;
	}
	
	public String toString() {
		return "Rectangulo -> P1: " + this.p1.toString() + ", P2: " + this.p2.toString() + ", P3: " + this.p3.toString() + ", P4: " + this.p4.toString() + " ";
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
