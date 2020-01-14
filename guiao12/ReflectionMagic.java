package guiao12;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class ReflectionMagic {
	Class<?> c;

	public ReflectionMagic(String className) throws ClassNotFoundException {
		c = Class.forName(className);
	}
	
	public void showStructure() {
		System.out.println("Name: " + c.getName());
		System.out.println("Simple Name: " + c.getSimpleName());
		System.out.println("Canonical Name: " + c.getCanonicalName());
		
		List<Constructor<?>> constructors = Arrays.asList(c.getConstructors());
		constructors.stream().forEach(e -> {
			System.out.println(e);
		});
		
		//showConstructorsNames();
	}
	
	public void showConstructorsNames() {
		Arrays.stream(c.getConstructors()).forEach(e -> System.out.println(e));
	}
	
	public String getModifier() {
		String f = "";
		int m = c.getModifiers();
		if(Modifier.isPublic(m)) {
			f += "public ";
		}
		if(Modifier.isAbstract(m)) {
			f += "abstract ";
		}
		if(Modifier.isFinal(m)) {
			f += "final ";
		}
		return f;
	}
	
}
