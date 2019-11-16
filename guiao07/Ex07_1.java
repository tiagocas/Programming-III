package guiao07;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Ex07_1 {

	public static void main(String[] args) throws IOException {
		String DIR = "src/guiao07/";
		String flights = DIR + "voos.txt";
		String companies = DIR + "companhias.txt";
		String cities = DIR + "cities.txt";
		String Infopublico = DIR + "Infopublico.txt";
		String InfopublicoBin = DIR + "Infopublico.bin";
		
		Aeroporto ae = new Aeroporto(flights, companies);
		ae.saveTableToFile(Infopublico);
		ae.saveCitiesToFile(cities);
		
		System.out.println();
		System.out.println(ae.getFlightsOrigin());
		
		ae.savePublicInfoToFile(InfopublicoBin);
		
		System.out.println("Media dos atrasos: \n" + ae.calculateDelays());
		System.out.println(ae.showFlights());
		
		System.out.println("#####################  BIN FILE  #####################:\n" + Aeroporto.loadFromBinFile(InfopublicoBin));
		
		
	}

}
