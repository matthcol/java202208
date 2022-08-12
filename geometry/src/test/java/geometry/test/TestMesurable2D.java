package geometry.test;

import geometry.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestMesurable2D {


    static List<Form> forms;

    // tous les test font de la lecture seulement
    @BeforeAll
    static void initData() {
        forms = List.of(
                new Point("A", 1, 2),
                new Circle("C1", new Point("B", 2, 3), 5),
                new Circle("C2", new Point("C", 4, 5), 4),
                new WeightedPoint("D", 3, 4,5),
                new Triangle("T",
                        new Point("F", 1, 2),
                        new Point("G", 4, 2),
                        new Point("H", 1, 6)),
                new Polygon("P",
                        new Point("I", 1, 2),
                        new Point("J", 1, 6),
                        new Point("K", 5, 9),
                        new Point("L", 5, 2)
                )
        );
    }

    @Test
    void testExtractMesurableFromForms() {
        for (var f : forms) {
            switch (f) {
                case Mesurable2D m -> System.out.println("Mesurable: "
                + m + "; perimeter: " + m.perimeter()
                + "; surface: " + m.surface());
                default -> System.out.println("Skip");
            }
        }
    }

    @Test
    void testSurfaceTotal(){
        double surfaceTotal = forms.stream() // : Stream<Form>
                .peek(f -> System.out.println("1. Original data: " + f))
                .filter(f -> f instanceof  Mesurable2D) // : Stream<Form>
                .peek(f -> System.out.println("2. Filter Mesurable2D: " + f))
                .map(f -> (Mesurable2D) f) // : Stream<Mesurable2D>
                // .mapToDouble(Mesurable2D::surface) // : DoubleStream
                .peek(m -> System.out.println("3. Convert as Mesurable2D: " + m))
                .mapToDouble(m -> m.surface()) // : DoubleStream
                .peek(s -> System.out.println("4. Surface: " + s))
                .sum();
        System.out.println("Total surface: " + surfaceTotal);
    }

}