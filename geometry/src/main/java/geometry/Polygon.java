package geometry;

import jakarta.validation.constraints.Size;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Polygon extends Form implements Mesurable2D, Iterable<Point> {
    @Size(min = 3)
    private List<Point> summits;

    // only for deserialization purpose
    public Polygon() {
    }

    public Polygon(String name, Point... summits){
        this(name, Arrays.asList(summits));
    }

    public Polygon(String name, Collection<? extends Point> summits){
        super(name);
        this.summits = new ArrayList<>(summits);
    }

    // for serializer only
    public List<Point> getSummits() {
        return summits;
    }

    public void setSummits(List<Point> summits) {
        this.summits = summits;
    }

    // useful getter
    public Point getSummit(int index) {
        return summits.get(index);
    }

    // Triangle Iterable et Streamable

    @Override
    public Iterator<Point> iterator() {
        return summits.iterator();
    }

    public Stream<Point> streamSummits() {
        return summits.stream();
    }

    @Override
    public String toString() {
        return getName() + "{"
                + streamSummits().map(Form::getName)
                .collect(Collectors.joining("-"))
                + "}";
    }

    @Override
    public void translate(double deltaX, double deltaY) {
        this.forEach(s -> s.translate(deltaX, deltaY));
    }

    public DoubleStream allEdges() {
        return IntStream.range(0,summits.size())
                .mapToDouble(i -> summits.get(i).distance(
                        summits.get((i+1)%summits.size())));
    }

    @Override
    public double perimeter() {
        return allEdges().sum();
    }

    @Override
    public double surface() {
        // TODO: only for convex polygon
        // - for concave, you have to substract and not add intermediate surface
        // - for crossed one, very complex

        // decomposition en triangle et somme des surfaces des triangles
        final Point first = summits.get(0);
        return IntStream.range(2, summits.size())
                .mapToDouble(i -> new Triangle("?",
                        first,
                        summits.get(i-1),
                        summits.get(i)
                        ).surface())
                .sum();
    }

}
