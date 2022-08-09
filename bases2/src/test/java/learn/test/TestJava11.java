package learn.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class TestJava11 {

	@Test
	void testJava5() {
		List<String> villes;
	}
	
	@Test
	void testJava8() {
		Stream<String> villeStream;
	}
	
	@Test
	void testJava11() {
		var villes = List.of("Paris", "Pau", "Toulouse");
		System.out.println(villes);
	}

}
