package geometry.exos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import geometry.Point;

public class ExoCollection {

	@Test
	void exoTranslateAll() {
		// 1. creer une liste avec les points
		// A(-1.1, 2.2)
		// B(0.0, 3.3)
		// C(1.1, 4.4)
		// D(0.0, 5.5)
		// E(3.3, 6.6)
		// F(4.4, 3.3)
		List<Point> points = List.of(
				new Point("A",-1.1, 2.2),
				new Point("B",0.0, 3.3),
				new Point("C",1.1, 4.4),
				new Point("D",0.0, 5.5),
				new Point("E",3.3, 6.6),
				new Point("F",4.4, 3.3)
			);
		// 2. afficher la liste de points
		System.out.println(points);
		for (var pt: points) {
			System.out.println(" - " + pt);
		}
		// 3. translater tous les points de (-1,+1)
		for (var pt: points) {
			pt.translate(-1, 1);
		}
		// 4. afficher la liste de points
		System.out.println(points);
	}
	
	@Test
	void exoXstats() {
		// 1. reprendre la liste de l'exercice exoTranslateAll
		List<Point> points = List.of(
				new Point("A",-1.1, 2.2)
				);
		// 2. donner la coordonnée X max de tous les points
		// 3. donner la coordonnée X min de tous les points
		// 4. donner la coordonnée X moyenne de tous les points
	}
	
	@Test
	void exoDistanceTotale() {
		// 1. reprendre la liste de l'exercice exoTranslateAll
		// 2. calculer la distance de chaque point au point origine (0,0)
		// 3. calculer la distance totale
	}
	
	@Test
	void exoTri() {
		// 1. reprendre la liste de l'exercice exoTranslateAll
		// 2. trier les points par X croissant
		// 2. trier les points par X décroissant, puis par name
	}
}
