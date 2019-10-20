package guiao04;

public class Quadrado extends Figura {
	Ponto p1, p2, p3, p4;
	
	public Quadrado(double l) {
		this.p1 = new Ponto(0, 0);
		this.p2 = new Ponto(0, l);
		this.p3 = new Ponto(l, l);
		this.p4 = new Ponto(l, 0);
	}
	
	public Quadrado(double px1, double py1, double l) {
		this.p1 = new Ponto(px1, py1);
		this.p2 = new Ponto(px1, py1 + l);
		this.p3 = new Ponto(px1 + l, py1 + l);
		this.p4 = new Ponto(px1 + l, py1);
	}

	public Quadrado(Quadrado q) {
		this.p1 = q.p1();
		this.p2 = q.p2();
		this.p3 = q.p3();
		this.p4 = q.p4();
	}
	
	@Override
	public boolean equals(Object q) {
		if(!q.getClass().equals(this.getClass())) return false;
		Quadrado x = (Quadrado)q;
		return this.p1.equals(x.p1) && this.p2.equals(x.p2) && this.p3.equals(x.p3) && this.p4.equals(x.p4);
	}
	
	public Ponto middle() {
		return getMiddle(this.p1, this.p3);
	}
	
	public Ponto getMiddle(Ponto xLeft, Ponto yRight) {
		double x = ( yRight.x() - xLeft.x() ) / 2;
		double y = (yRight.y() - xLeft.y() ) / 2;
 		return new Ponto(x, y);
	}
	
	public double area() {
		return this.p1.distance(this.p2) * this.p1.distance(this.p2);
	}
	
	public double perimetro() {
		return this.p1.distance(this.p2)*4;
	}
	
	public double getWidth() {
		double v = this.p3.x() - this.p1.x();
		if(v < 0) {
			v = -v;
		}
		return v;
	}
	
	public String toString() {
		return "Quadrado de centro " + this.middle().toString() + " e de lado " + this.getWidth();
		//return "Quadrado -> P1: " + this.p1.toString() + ", P2: " + this.p2.toString() + ", P3: " + this.p3.toString() + ", P4: " + this.p4.toString() + " ";
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
