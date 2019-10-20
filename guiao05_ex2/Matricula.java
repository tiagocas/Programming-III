package guiao05_ex2;
import java.util.Random;
import java.security.SecureRandom;

public class Matricula {
	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String DATA_FOR_RANDOM_STRING = CHAR_UPPER;
    private static SecureRandom random = new SecureRandom();
    
	public static String random() {
		String[] matricula = {generateNumber(0,99),generateRandomString(2),generateNumber(0,99)};
		return mixRandomMatricula(matricula);
	}
	
	private static String mixRandomMatricula(String[] array) {
		String matricula = "";
		for(int i=0;i<array.length;i++) {
			matricula += array[i];
			if(i < array.length -1) {
				matricula += "-";
			}
		}
		return matricula;
	}
	
	private static String generateNumber(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		if(randomNum < 10) {
			return "0" + String.valueOf(randomNum);
		}
		return String.valueOf(randomNum);
	}
	
	private static String generateRandomString(int length) {
        if (length < 1) throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

			// 0-62 (exclusive), random returns 0-61
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            // debug
            //System.out.format("%d\t:\t%c%n", rndCharAt, rndChar);

            sb.append(rndChar);

        }

        return sb.toString();

    }
}
