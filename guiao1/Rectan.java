package guiao1;

public class Rectan implements Figure{
	private Point rightTop,rightBottom,leftTop,leftBottom;
	
	Rectan(Point p1, Point p2, Point p3, Point p4){
		this.rightTop = p1;
		this.rightBottom = p2;
		this.leftTop = p3;
		this.leftBottom = p4;
	}
	@Override
	public String toString() {
		return "Rectangle with points: {" + rightTop.toString() + ", " + rightBottom.toString() + ", " + leftTop.toString() + ", " + leftBottom.toString() +"}";
	}
	public static boolean checkRectan(Point p1, Point p2, Point p3, Point p4) {
		return p1.distance(p2) == p3.distance(p4) && p1.distance(p4) == p2.distance(p3);
	}
}
