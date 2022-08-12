package geometry;

import jakarta.validation.constraints.Size;

import java.sql.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Triangle extends Form implements Mesurable2D, Iterable<Point> {

    @Size(min = 3, max = 3)
    private Point[] summits;

    // only for deserialization purpose
    public Triangle() {
    }

    public Triangle(String name, Point summit1, Point summit2, Point summit3){
        super(name);
        summits = new Point[3];
        summits[0] = summit1;
        summits[1] = summit2;
        summits[2] = summit3;

    }

    // for serializer only
    public Point[] getSummits() {
        return summits;
    }

    public void setSummits(Point[] summits) {
        this.summits = summits;
    }

    // useful getter
    public Point getSummit(int index) {
        if (index <0 || index>2) {
            throw new IllegalArgumentException("index must be in [0-2] was: " + index);
        }
        return summits[index];
    }

    // Triangle Iterable et Streamable

    @Override
    public Iterator<Point> iterator() {
        return Arrays.stream(summits).iterator();
    }

    public Stream<Point> streamSummits() {
        return Arrays.stream(summits);
    }

    @Override
    public String toString() {
        return getName() + "/"
                + streamSummits().map(Form::getName)
                .collect(Collectors.joining("-"))
                + "\\";
    }

    @Override
    public void translate(double deltaX, double deltaY) {
        // for (Point s: summits) { }
        this.forEach(s -> s.translate(deltaX, deltaY));
    }

    public DoubleStream allEdges() {
        return IntStream.range(0,3)
                .mapToDouble(i -> summits[i].distance(summits[(i+1)%3]));
    }

    @Override
    public double perimeter() {
        return allEdges().sum();
    }

    @Override
    public double surface() {
        // Heron formula (optimized)
        var sortedEdges = allEdges().mapToObj(e->e)
                .sorted(Comparator.reverseOrder())
                .toList();
        var a = sortedEdges.get(0);
        var b = sortedEdges.get(1);
        var c = sortedEdges.get(2);
        return Math.sqrt((a+(b+c))*(c-(a-b))*(c+(a-b))*(a+(b-c)))/4;
    }

}
