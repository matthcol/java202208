package geometry.exos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import geometry.Point;

public class ExoCollectionStream {

	private List<Point> points;
	
	@BeforeEach
	void initData() {
		points = List.of(
				new Point("A",-1.1, 2.2),
				new Point("B",0.0, 3.3),
				new Point("C",1.1, 4.4),
				new Point("D",0.0, 5.5),
				new Point("E",3.3, 6.6),
				new Point("F",4.4, 3.3)
			);
	}
	
	@Test
	void exoTranslateAll() {
		points //.stream()
			.forEach(pt -> pt.translate(1, -1));
		points.forEach((Point pt) -> pt.translate(1, -1));
		points.forEach((var pt) -> pt.translate(1, -1));
		System.out.println(points);
	}
	
	@Test
	void exoXstatsMin() {
		double xMin = points.stream()
			//.map(pt -> pt.getX())
			.mapToDouble(Point::getX)  // DoubleStream
			.min()  // OptionalDouble
			.getAsDouble(); // extrait la valeur de la boite non vide
		System.out.println(xMin);
	}
	
	@ParameterizedTest
	@ValueSource(doubles= {-5.0, 0.0, 5.0})
	void exoXstatsMinFiltre(double threshold) {
		points.stream()
			//.map(pt -> pt.getX())
			.mapToDouble(Point::getX)  // DoubleStream
			.filter(x -> x > threshold)
			.min()  // OptionalDouble
			.ifPresent(
				xMin ->	System.out.println("x min with threshold "
							+ threshold + " : " + xMin));
	}
	
	@Test
	void exoXstatsMinEmptyCollection() {
		var emptyPoints = List.<Point>of();
		OptionalDouble xMin = emptyPoints.stream()
			//.map(pt -> pt.getX())
			.mapToDouble(Point::getX)
			.min();
		System.out.println(xMin);
	}
	
	@Test
	void exoXstatsSumFiltres() {
		// somme des X strictement positifs
		// pour les points sauf le point F
		double xSum = points.stream()
			.peek(p -> System.out.println("pt: " + p))
			.filter(p -> ! "F".equals(p.getName())) // eliminate F
			.peek(p -> System.out.println("pt (filter not F): " + p))
			.mapToDouble(Point::getX)
			.peek(x -> System.out.println("x: " + x))
			.filter(x -> x > 0)
			.peek(x -> System.out.println("x (filter > 0): " + x))
			.sum();
		System.out.println("X sum: " + xSum);
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {0.0, 5.0})
	void exoXstatsAverageFiltres(double threshold) {
		// moyenne des X strictement supérieur au seuil
		// pour les points sauf le point F
		var optAverage = points.stream()
			.filter(p -> ! "F".equals(p.getName()))
			.mapToDouble(p -> p.getX())
			.filter(x -> x > threshold)
			.average();
		// traitement du résultat oldschool
		if (optAverage.isPresent()) {
			System.out.println("Avg X: " 
					+ optAverage.getAsDouble());
		} else {
			System.out.println("No Data to compute average");
		}
		// traitement du résultat en mode fonctionnel
		optAverage.ifPresentOrElse(
				avg -> System.out.println("Avg X: " +avg),
				() -> System.out.println("No Data to compute average"));
	}
	
	@Test
	void exoYallstats() {
		var stats = points.stream()
			.mapToDouble(Point::getY)
			.filter(y -> y >= 3)
			.summaryStatistics();
		System.out.println(stats);
	}
	
	@Test
	void exoFilterPoints() {
		var pointsFiltered = points.stream()
			.filter(p -> p.getX() > 0)
			.filter(p -> ! "F".equals(p.getName()))
			.collect(Collectors.toList()); // Java 8/11
			//.toList(); // Java 17
		System.out.println(pointsFiltered);
	}
	
	
	@Test
	void exoDistanceTotale() {
		// 1. reprendre la liste de l'exercice exoTranslateAll
		// 2. calculer la distance de chaque point au point origine (0,0)
		// 3. calculer la distance totale
	}
	
}
