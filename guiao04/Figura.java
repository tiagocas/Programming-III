package guiao04;

public abstract class Figura implements iFigura, Comparable<Figura>
{
	
	public int compareTo(Figura q) {
		if(this.area() > q.area()) {
			return 1;
		}
		else if(this.area() < q.area()) {
			return -1;
		}
		return 0;
	}
//@Override public  boolean equals(Object f);
}