package learn.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestList {

	@Test
	void test() {
		// en Java 5
		List<String> villes = new ArrayList<String>();
		villes.add("Pau");
		villes.add("Toulouse");
		System.out.println(villes);
		
		// java.lang.IndexOutOfBoundsException if index not good :
		String ville = villes.get(0); 
		System.out.println(ville);
	}

}
