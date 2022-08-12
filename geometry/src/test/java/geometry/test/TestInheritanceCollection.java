package geometry.test;


import static org.junit.jupiter.api.Assertions.*;

import geometry.Circle;
import geometry.Form;
import geometry.Point;
import geometry.WeightedPoint;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestInheritanceCollection {

    // NB: downcasting
    // Point p = ???
    // WeightedPoint wp = (WeightedPoint) p;
    // NB2: LSP
    // WeightedPoint wp2 = ???
    // Point p2 = wp2;

    @Test
    void demoJoker() {
        List<?> data;
        data = new ArrayList<Point>();
        data = new ArrayList<Circle>();
        data = new ArrayList<String>();
    }

    private static void fEgal(List<Point> points) {
        // ANYTHING
    }

    private static void fExtendsOK(List<? extends Point> points) {
        for (Point p : points) {
            System.out.println(p.getX());
        }
    }

    private static void fExtendsNOK(List<? extends Point> points) {
        // points.add(new Point()); // refused by compiler
    }

    private static void fSuperOK(List<? super WeightedPoint> points) {
        points.add(new WeightedPoint());
    }

    private static void fSuperNOK(List<? super WeightedPoint> points) {
        // for (WeightedPoint p : points) { // doesnt compile
        for (var p : points) {
            // System.out.println(p.getWeight()); // doesnt compile with var
        }
    }

    @Test
    void demoExtends() {
        List<Point> points = List.of(new Point("A", 1, 2));
        List<WeightedPoint> weightedPoints = List.of(new WeightedPoint("B", 3, 4, 5));
        points.addAll(weightedPoints); // WeightedPoint match ? extends Points
        // fEgal(weightedPoints); // List<WP> does not extend List<P>
        fExtendsOK(points);
        fExtendsOK(weightedPoints);
        fExtendsNOK(weightedPoints);
    }

    @Test
    void demoSuper() {
        List<Point> points = List.of(new Point("A", 1, 2));
        List<WeightedPoint> weightedPoints = List.of(new WeightedPoint("B", 3, 4, 5));
        // example from API
        weightedPoints.sort(Comparator.comparing(WeightedPoint::getWeight));
        weightedPoints.sort(Comparator.comparing(Point::getX));
        weightedPoints.sort(Comparator.comparing(Form::getName));
        weightedPoints.sort(Comparator.comparing(Object::hashCode));
        // demo:
        fSuperOK(weightedPoints);
        fSuperOK(points); // List<Point> match List<? super WeightedPoint>
        fSuperNOK(points);
    }
}