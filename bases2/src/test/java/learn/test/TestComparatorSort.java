package learn.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

class TestComparatorSort {

	@Test
	void testStringComparable() {
		String ville1 = "Nancy";
		String ville2 = "Nantes";
		int cmp = ville1.compareTo(ville2);
		System.out.println(cmp); // -17
		assertTrue(cmp < 0);
		int cmp2 = ville2.compareTo(ville1);
		System.out.println(cmp2);
		assertTrue(cmp2 > 0);
	}
	
	@Test
	void testCollectionWithNaturalOrder() {
		// String is Comparable => Natural Order
		var villesSorted = new TreeSet<String>();
		Collections.addAll(villesSorted, "Nancy", "Annecy", "Nantes");
		System.out.println(villesSorted);
		// sur une liste
		var villesListe = new ArrayList<String>();
		villesListe.addAll(villesSorted);
		Collections.shuffle(villesListe);
		System.out.println(villesListe);
		var villeMin = Collections.min(villesListe); // naturel order
		var villeMax = Collections.max(villesListe); // naturel order
		System.out.println(villeMin + " - " + villeMax);
		Collections.sort(villesListe); // naturel order
		System.out.println(villesListe);
	}
	
	@Test
	void testDataNotComparable() {
		assertThrows(ClassCastException.class, () -> {
				var data = new TreeSet<List<String>>();
				data.add(List.of("a","b"));
		});
		// List<Object> objects = List.of("Pau", 12, 12.2);
		// Collections.sort(objects); // erreur de compilation : Object is not Comparable
	}

}
