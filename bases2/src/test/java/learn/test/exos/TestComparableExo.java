package learn.test.exos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TestComparableExo {
	
	@Test
	void testExo1() {
		var villes = List.of("Bayonne","Amnéville",
				"Bordeaux",  "Nantes", "Paris", 
				"Pau", "Lyon", "Marseille",
				"Pau", "Bayonne", "Pamiers",
				"Nancy", "Brest", "Tours");
		// extraire les villes commençant par P 
		// - triées par ordre alphabétique
		// - sans doublons
	}
	
	@Test
	void testExo2() {
		var villes = List.of("Bayonne","Amnéville",
				"Bordeaux",  "Nantes", "Paris", 
				"Pau", "Lyon", "Marseille",
				"pau", "Bayonne", "PAMIERS",
				"Nancy", "Brest", "Tours", "pArIs");
		// extraire les villes commençant par p
		// - sans tenir compte de la casse
		// - triées par ordre alphabétique (sans tenir compte de la casse)
		// - sans doublons (sans tenir compte de la casse)
	}

}
