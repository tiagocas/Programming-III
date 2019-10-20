package guiao04;

public class Rectangulo extends Figura {
	private Ponto p1, p2, p3, p4;
	
	public Rectangulo(double x, double y) {
		this.p1 = new Ponto(0, 0);
		this.p2 = new Ponto(x, 0);
		this.p3 = new Ponto(x, y);
		this.p4 = new Ponto(0, y);
	}
	
	public Rectangulo(double px1, double py1, double px3, double py3) {
		this.p1 = new Ponto(px1, py1);
		this.p3 = new Ponto(px3, py3);
		if(px1 > px3) {
			this.p2 = new Ponto(this.p1.x() , this.p3.y());
			this.p4 = new Ponto(this.p3.x() , this.p1.x());
		}
		else {
			this.p2 = new Ponto(this.p3.x() , this.p1.x());
			this.p4 = new Ponto(this.p1.x() , this.p3.x());
		}
	}

	public Rectangulo(Rectangulo q) {
		this.p1 = q.p1;
		this.p2 = q.p2;
		this.p3 = q.p3;
		this.p4 = q.p4;
	}
	
	public Ponto middle() {
		return getMiddle(this.p1, this.p3);
	}
	
	public Ponto getMiddle(Ponto xLeft, Ponto yRight) {
		double x = ( yRight.x() - xLeft.x() ) / 2;
		double y = (yRight.y() - xLeft.y() ) / 2;
 		return new Ponto(x, y);
	}
	
	public int compareTo(Figura q) {
		if(this.area() > q.area()) {
			return 1;
		}
		else if(this.area() < q.area()) {
			return -1;
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!o.getClass().equals(this.getClass())) {
			return false;
		}
		Rectangulo q = (Rectangulo)o;
		return this.p1.equals(q.p1) && this.p2.equals(q.p2) && this.p3.equals(q.p3) && this.p4.equals(q.p4);
	}
	
	public double area() {
		return this.p1.distance(this.p2) * this.p2.distance(p3);
	}
	
	public double perimetro() {
		return this.p1.distance(this.p2) * 2 + this.p2.distance(p3)*2;
	}
	
	public double getHeight() {
		double v = this.p3.y() - this.p1.y();
		if(v < 0) {
			v = -v;
		}
		return v;
	}
	
	public double getWidth() {
		double v = this.p3.x() - this.p1.x();
		if(v < 0) {
			v = -v;
		}
		return v;
	}
	
	public String toString() {
		return "Rectangulo de centro " + this.middle().toString() + ", altura " + this.getHeight() + ", comprimento " + this.getWidth();
		//return "Rectangulo -> P1: " + this.p1.toString() + ", P2: " + this.p2.toString() + ", P3: " + this.p3.toString() + ", P4: " + this.p4.toString() + " ";
	}
	
	public Ponto p1() {
		return this.p1;
	}
	
	public Ponto p2() {
		return this.p2;
	}
	
	public Ponto p3() {
		return this.p3;
	}
	
	public Ponto p4() {
		return this.p4;
	}
	
}