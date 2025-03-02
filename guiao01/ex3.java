package guiao01;
import java.util.Scanner;

public class ex3 {
	static Scanner input;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		String menuReceiver;
		String content = "\n"
				+ "[0] Add circle\n"
				+ "[1] Add Square\n"
				+ "[2] Add Rectangle\n"
				+ "[3] Is interseption\n"
				+ "[4] Confirme equality\n";
		Menu menu = new Menu(content);
		
		Circle circle1 = new Circle(new Point(3,4),2);
		Circle circle2 = new Circle(new Point(3,5),3);
		
		while(true){
			menuReceiver = menu.showMenu();
			switch(menuReceiver) {
			case "0":
				System.out.printf("\nMiddle point of the circle: ");
				System.out.printf("\n\tX: ");
				int x = input.nextInt();
				System.out.printf("\n\tY: ");
				int y = input.nextInt();
				System.out.printf("\nRadius of the circle: ");
				int radius = input.nextInt();
				Circle circle = new Circle(new Point(x,y),radius);
				System.out.println(circle.toString());
				break;
			case "1":
				System.out.printf("\nTop Right Point of the square");
				System.out.printf("\nX: ");
				int trX = input.nextInt();
				System.out.println("\nY: ");
				int trY = input.nextInt();
				Point p1 = new Point(trY,trY);
				System.out.printf("\nTop Left Point of the square");
				System.out.printf("\nX: ");
				int tlX = input.nextInt();
				System.out.println("\nY: ");
				int tlY = input.nextInt();
				Point p2 = new Point(tlX,tlY);
				System.out.printf("\nBottom Right Point of the square");
				System.out.printf("\nX: ");
				int brX = input.nextInt();
				System.out.println("\nY: ");
				int brY = input.nextInt();
				Point p3 = new Point(brX,brY);
				System.out.printf("\nBottom Left Point of the square");
				System.out.printf("\nX: ");
				int blX = input.nextInt();
				System.out.println("\nY: ");
				int blY = input.nextInt();
				Point p4 = new Point(blX,blY);
				if(Square.checkSquare(p1, p2, p3, p4)) {
					Square sqr1 = new Square(p1,p2,p3,p4);
					System.out.println("Square was successfully added");
					System.out.println(sqr1.toString());
				}
				else {
					System.out.println("Square was not accepted");
				}
				break;
			case "2":
				System.out.printf("\nTop Right Point of the rectangle");
				System.out.printf("\nX: ");
				int RtrX = input.nextInt();
				System.out.println("\nY: ");
				int RtrY = input.nextInt();
				Point Rp1 = new Point(RtrX,RtrY);
				System.out.printf("\nTop Left Point of the rectangle");
				System.out.printf("\nX: ");
				int RtlX = input.nextInt();
				System.out.println("\nY: ");
				int RtlY = input.nextInt();
				Point Rp2 = new Point(RtlX,RtlY);
				System.out.printf("\nBottom Right Point of the rectangle");
				System.out.printf("\nX: ");
				int RbrX = input.nextInt();
				System.out.println("\nY: ");
				int RbrY = input.nextInt();
				Point Rp3 = new Point(RbrX,RbrY);
				System.out.printf("\nBottom Left Point of the rectangle");
				System.out.printf("\nX: ");
				int RblX = input.nextInt();
				System.out.println("\nY: ");
				int RblY = input.nextInt();
				Point Rp4 = new Point(RblX,RblY);
				if(Rectan.checkRectan(Rp1, Rp2, Rp3, Rp4)) {
					Rectan rect1 = new Rectan(Rp1,Rp2,Rp3,Rp4);
					System.out.println("Square was successfully added");
					System.out.println(rect1.toString());
				}
				else {
					System.out.println("Square was not accepted");
				}
				break;
			case "3":
				if(circle1.intercepts(circle2)) {
					System.out.println("Circles intersept");
				}
				else {
					System.out.println("Circles do not intersept");
				}
				break;
			case "4":
				if(circle1.equals(circle2)) {
					System.out.println("Circles are equal");
				}
				else {
					System.out.println("Circles are different");
				}
				break;
			default:
				System.out.println("Command not recognized");
			}
			
		}
	}

}
