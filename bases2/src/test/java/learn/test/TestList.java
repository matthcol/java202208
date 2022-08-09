package learn.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

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
	
	@Test
	void testReversement() {
		var villes = new ArrayList<String>();
		assertTrue(villes.isEmpty());
		// reverse content of another list
		var villesOther = List.of("Pau", "Paris");
		villes.addAll(villesOther);
		System.out.println(villes);
		assertEquals(2, villes.size());
		// reverse content of another list 2
		var villesOther2 = new LinkedList<String>();
		Collections.addAll(villesOther2, "Bordeaux", "Marseille", "Bayonne");
		villes.addAll(villesOther2);
		System.out.println(villes);
		assertEquals(5, villes.size());
		// attention au partage de reference
		assertTrue(villes.get(0) == villesOther.get(0));
		assertTrue(villes.get(2) == villesOther2.get(0));
		// 1 modification sur une liste n'a pas d'impact sur l'autre
		villesOther2.add("Lille");
		villes.add("Brest");
		System.out.println("villes: " + villes);
		System.out.println("villes O2: " + villesOther2);
		// reversement d'une autre type de collection
		var villesOther3 = Set.of("Lyon", "Tours");
		villes.addAll(villesOther3);
		System.out.println(villes);
		// bis repetita avec un NavigableSet
		var villesOther4 = new TreeSet<String>(); 
		Collections.addAll(villesOther4, "Nantes", "Nancy", "Amnéville");
		villes.addAll(villesOther4);
		System.out.println(villes);
		// reversement impossible
		var doubles = List.of(1.1, 2.2, 3.3);
		// villes.addAll(doubles); // erreur de compilation
		
		// tri de la liste globale
		villes.sort(null); // aver ordre naturel implicite
		System.out.println(villes);
		villes.sort(Comparator.reverseOrder());
		System.out.println(villes);
		villes.sort(Comparator.naturalOrder());
		System.out.println(villes);
		// tri avant Java 8 : Collections.sort
		Collections.sort(villes, Comparator.reverseOrder());
		System.out.println(villes);
		Collections.sort(villes); // natural order
		System.out.println(villes);
	}
	
	
	
	
	
	
	
	
	

}
