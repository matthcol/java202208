package geometry.exos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

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
				new Point("A",-1.1, 2.2),
				new Point("B",0.0, 3.3),
				new Point("C",1.1, 4.4),
				new Point("D",0.0, 5.5),
				new Point("E",3.3, 6.6),
				new Point("F",4.4, 3.3)
			);
		// 2. donner la coordonnée X max de tous les points
		double xMax = Double.NEGATIVE_INFINITY; // -inf
		for (var pt: points) {
			if (pt.getX() > xMax) {
				xMax = pt.getX(); 
			}
		}
		System.out.println("X max: " + xMax);
		// 3. donner la coordonnée X min de tous les points
		double xMin = Double.POSITIVE_INFINITY; // -inf
		for (var pt: points) {
			if (pt.getX() < xMin) {
				xMin = pt.getX(); 
			}
		}
		System.out.println("X min: " + xMin);
		// 4. donner la coordonnée X moyenne de tous les points
		// (Σx_i)/nb = Σ(x_i/nb)
		double xSum = 0.0;
		for (var pt: points) {
			xSum += pt.getX();
		}
		double xAvg = xSum / points.size();
		System.out.println("X average: " + xAvg);
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
		List<Point> points = List.of(
				new Point("A",-1.1, 2.2),
				new Point("D",0.0, 5.5),
				new Point("b",0.0, 3.3),
				new Point("C",1.1, 4.4),
				new Point("E",3.3, 6.6),
				new Point("F",4.4, 3.3)
			);
		var points2 = new ArrayList<>(points);
		// 2. trier les points par X croissant
		
		// Point is not Comparable
		// Collections.sort(points2); // compil error
		// points2.sort(null); // execution error
		
		// avec un comparator
		Comparator<Point> comp = Comparator.comparing(Point::getX);
		points2.sort(comp);
		System.out.println(points2);
		// 2. trier les points par X décroissant, puis par name
		comp = Comparator
				.comparing(Point::getX, Comparator.reverseOrder())
				.thenComparing(Point::getName, String::compareToIgnoreCase);
		points2.sort(comp);
		System.out.println(points2);
	}
	
	@Test
	void exoTri2() {
		// 1. reprendre la liste de l'exercice exoTranslateAll
		List<Point> points = List.of(
				new Point("A",-1.1, 2.2),
				new Point("D",0.0, 5.5),
				new Point("b",0.0, 3.3),
				new Point("C",1.1, 4.4),
				new Point("E",3.3, 6.6),
				new Point("F",4.4, 3.3)
			);
		// 2. trier les points par X décroissant, puis par name
		Comparator<Point> comp = Comparator
				.comparing(Point::getX, Comparator.reverseOrder())
				.thenComparing(Point::getName, String::compareToIgnoreCase);
		var points2 = new TreeSet<Point>(comp);
		points2.addAll(points);
		System.out.println(points2);
	}
}
