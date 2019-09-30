package guiao1;

public class Square implements Figure{
	private Point rightTop,rightBottom,leftTop,leftBottom;
	
	Square(Point p1, Point p2, Point p3, Point p4){
		this.rightTop = p1;
		this.rightBottom = p2;
		this.leftTop = p3;
		this.leftBottom = p4;
	}
	
	public static boolean checkSquare(Point p1, Point p2, Point p3, Point p4) {
		return p1.distance(p2) == p2.distance(p3) && p3.distance(p4) == p4.distance(p1);
	}
	
	@Override
	public String toString() {
		return "Rectangle with points: {" + rightTop.toString() + ", " + rightBottom.toString() + ", " + leftTop.toString() + ", " + leftBottom.toString() +"}";
	}
}
