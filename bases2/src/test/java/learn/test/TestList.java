package learn.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestList {

	@Test
	void testConstructListWithImplementation() {
		// en Java 5
		List<String> villes = new ArrayList<String>();
		// autre implémentation
		// List<String> villes = new LinkedList<String>();
		villes.add("Pau");
		villes.add("Toulouse");
		villes.add(0, "Paris");
		System.out.println(villes);
		
		// java.lang.IndexOutOfBoundsException if index not good :
		String ville = villes.get(0); 
		System.out.println(ville);
	}
	
	@Test
	void testConstructListAlmostAtOnce() {
		var villes = new ArrayList<String>();
		Collections.addAll(villes, "Pau", "Toulouse", "Paris");
		System.out.println(villes);
	}
	
	@Test
	void testConstructListAtOnce() {
		// List.of => list non modifiable !!!!
		var villes = List.of("Pau", "Toulouse", "Paris");
		System.out.println(villes);
		System.out.println(villes.getClass());
		// villes.add("Bayonne"); // UnsupportedOperationException
	}
	
	@Test
	void testListDouble() {
		List<Double> temperatures = List.of(34.3, 21.2, 12.8); 
		double d = temperatures.get(0);
	}
	
	@Test
	void testIterate() {
		var villes = List.of("Pau", "Toulouse", "Paris");
		// foreach (Java 5)
		for (String ville: villes) {
			System.out.println(" - " + ville);
		}
		// Java 11: on peut utiliser var pour la variable de parcours
		for (var ville: villes) {
			System.out.println(" * " + ville);
		}
		// Java 8 : api fonctionnelle Stream
		villes.forEach(System.out::println);
		villes.forEach(v -> System.out.println(" # " + v));
		// oldschool for
		for (int i=0; i < villes.size(); i++) {
			System.out.println(" @ " + villes.get(i));
		}
	}
	
	
	
	
	
	
	
	
	

}
