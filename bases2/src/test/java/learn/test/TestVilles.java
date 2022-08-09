package learn.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.junit.jupiter.api.Test;

import learn.Villes;

class TestVilles {

	@Test
	void testUpdateVillesArrayList() {
		// en Java 5 
		List<String> villes = new ArrayList<String>();
		Villes.updateVilles(villes);
		System.out.println(villes);
	}
	
	@Test
	void testUpdateVillesLinkedList() {
		// en Java 7 : notation diamond
		List<String> villes = new LinkedList<>();
		Villes.updateVilles(villes);
		System.out.println(villes);
	}
	
	@Test
	void testUpdateVillesVector() {
		// en Java 10/11
		var villes = new Vector<String>();
		Villes.updateVilles(villes);
		System.out.println(villes);
	}

	@Test
	void testUpdateVillesListOf() {
		var villes = List.of("Bordeaux");
		assertThrows(UnsupportedOperationException.class, 
				() -> Villes.updateVilles(villes)
		);
	}
}
