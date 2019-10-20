package guiao01;

public class Circle implements Figure{
	private double r;
	private Point middle;
	
	Circle(double x, double y, double r){
		this.middle = new Point(x, y);
		this.r = r;
	}
	Circle(Point middle, double r){
		this.middle = middle;
		this.r = r;
	}
	public Boolean equals(Circle c2) {
		if(this.middle.x() == c2.middle.x()) {
			if(this.middle.y() == c2.middle.y()) {
				if(this.r == c2.r()) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean intercepts(Circle c2) {
		double rSum = this.r + c2.r();
		if(distance(c2)>rSum) {
			return false;
		}
		return true;
	}
	private double distance(Circle c2) {
		double distX = this.middle.x() - c2.middle.x();
		double distY = this.middle.y() - c2.middle.y();
		return Math.sqrt(distX*distX + distY*distY);
	}
	public double r() {
		return this.r;
	}
	
	@Override
	public String toString() {
		return "Circle with middle point " + this.middle.toString() + " and " + this.r() + " radius";
	}
}
