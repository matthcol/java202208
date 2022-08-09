package learn.test.exos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
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
				"Bordeaux",  "Nantes", "pArIs", 
				"Pau", "Lyon", "Marseille",
				"pau", "Bayonne", "PAMIERS",
				"Nancy", "Brest", "Tours", "Paris",
				"pabu");
		// extraire les villes commençant par p
		// - sans tenir compte de la casse
		// - triées par ordre alphabétique (sans tenir compte de la casse)
		// - sans doublons (sans tenir compte de la casse)
		Comparator<String> cmp = 
				(v1, v2) -> v1.compareToIgnoreCase(v2);
				// String::compareToIgnoreCase; // + court ;)
		var villesP = new TreeSet<String>(cmp); 
		for (var v : villes) {
			if (v.toLowerCase().startsWith("p")) {
				villesP.add(v); 
			}
		}
		System.out.println(villesP);
	}

}
