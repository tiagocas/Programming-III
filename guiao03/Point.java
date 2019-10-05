package guiao03;

public class Point {
	private double x,y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Point p) {
		return this.x == p.x() && this.y == p.y();
	}
	
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
	
	public String toString(String sep) {
		return "(" + this.x + sep + this.y + ")";
	}
	
	public String toString(String left, String sep, String right) {
		return left + this.x + sep + this.y + right;
	}
	
	public double distance(Point p2) {
		return Math.sqrt((p2.y()-this.y())*(p2.y()-this.y()) + (p2.x()-this.x())*(p2.x()-this.x()));
	}
	
	public double y() {
		return this.y;
	}
	
	public double x() {
		return this.x;
	}
	
}
