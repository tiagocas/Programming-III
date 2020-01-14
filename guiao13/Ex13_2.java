package guiao13;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex13_2 {
	public static final String inputFile = "src/guiao13/Policarpo.txt";
	public static final String outputFile = "src/guiao13/output.txt";

	public static void main(String[] args) throws IOException {
		
		String[] words = getWords(new File(inputFile)).toArray(new String[0]);
		//Arrays.asList(words).stream().forEach(x->System.out.println(x));

		Map<String, Map<String, Integer>> map = loadMap(words);
		save(map, new File(outputFile));
		
	}
	
	public static String mapToString(Map<String, Map<String, Integer>> map) {
		String content = "";
		int count;
		Set<String> keys = map.keySet();
		for(String key: keys) {
			count = 0;
			content += key + " = {";
			Map<String, Integer> aux = map.get(key);
			Set<String> keys2 = aux.keySet();
			for(String key2 : keys2) {
				content+= key2 + " = " + aux.get(key2);
				if(count < keys2.size()-1) {
					content += ", ";
				}
			}
			content += "}\n";
		}
		return content;
	}
	
	public static void save(Map<String, Map<String, Integer>> map, File file) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter(file.getAbsolutePath()), false);
		pw.write(mapToString(map));
		pw.close();
	}
	
	public static Map<String, Map<String, Integer>> loadMap(String[] words) {
		Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
		Map<String, Integer> aux;
		for(int i=0; i<words.length-1;i++) {
			if(map.containsKey(words[i])) {
				aux = map.get(words[i]);
				if(aux.containsKey(words[i+1])) {
					aux.put(words[i+1], aux.get(words[i+1]) + 1);
				}
				else {
					aux.put(words[i+1], 1);
				}
			}
			else {
				aux = new HashMap<String, Integer>();
				aux.put(words[i+1], 1);
			}
			map.put(words[i], aux);
		}
		return map;
	}
	
	public static List<String> getWords(File f) throws IOException{
		List<String> lines = Files.readAllLines(Paths.get(f.getAbsolutePath()));
		String text = lines.stream().reduce("", (previous, element) -> previous + element);
		List<String> words = Arrays.asList(text.split("[-|\t|\n| |.|,|:|'|,|;|?|!|*|{|}|=|+|&|/|(|)|[|]|\"|'|“|”|‘|’]")).stream()
				.filter(x -> x.length() >= 3)
				.map(x -> x.toLowerCase())
				.collect(Collectors.toList());
		return words;
	}

}
