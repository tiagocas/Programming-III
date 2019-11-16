package guiao06;

public class DiaSemana {
	private static int max = 7;
	private static int min = 1;
	
	public static int rand() {
		return (int)Math.random()*7 +1;
	}
	
	public static int getNextDay(int dia) {
		if(dia == max) {
			return min;
		}
		return dia++;
	}
}
