package learn.test.exos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class TestComparableExo {
	
	@Test
	void testExo1() {
		var villes = List.of("Bayonne","Amnéville",
				"Bordeaux",  "Nantes", "Paris", 
				"Pau", "Lyon", "Marseille",
				"Pau", "Bayonne", "Pamiers",
				"Nancy", "Brest", "Tours");
		// Exo: extraire les villes commençant par P 
		// - triées par ordre alphabétique
		// - sans doublons
		
		// Sol: un TreeSet est un NavigableSet:
		//	- tri auto des données
		//  - pas de doublons
		//  - ordre naturel du type des éléments par défaut
		var villesP = new TreeSet<String>(); 
		for (var v : villes) {
			if (v.startsWith("P")) {
				villesP.add(v); // cout en log(n): 2^20 => 20
			}
		}
		System.out.println(villesP);
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
