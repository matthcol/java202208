package geometry.test;

import geometry.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestForm {

    @Test
    void testForm() {
        // Form f = new Form();  // on ne peut pas creer d'instance
        Point p1 = new Point("A", 3, 4);
        Form f1 = p1;
        Form f2 = new Circle("C", p1, 3.3);
        List<Form> forms = List.of(
                f1,
                f2,
                new Point("B", 2.2, 1.1),
                new Circle("C2", p1, 4.4),
                new WeightedPoint("D", 1.1, 2.2, 3.3),
                new Triangle("T",
                        new Point("F", 1, 2),
                        new Point("G", 4, 2),
                        new Point("H", 1, 6)),
                new Polygon("P",
                        new Point("A", 1, 2),
                        new Point("B", 1, 6),
                        new Point("C", 5, 9),
                        new Point("D", 5, 2)
                )
        );
        System.out.println(forms);
        for (var f : forms) {
            System.out.println("- form: " + f.getName());
        }
        forms.forEach(f -> f.translate(-1, +1));
        forms.forEach(System.out::println);
        for (var f : forms) {
            switch (f) {
                case WeightedPoint wp ->
                    System.out.println(" * WP: " + wp + " ; weight: " + wp.getWeight());
                case Point pt ->
                    System.out.println(" * Point: " + pt
                            + " ; x,y: " + pt.getX()
                            + "," + pt .getY());
               case Circle c ->
                    System.out.println(" * Circle: " + c + " ; radius: " +c.getRadius());
               case Triangle t -> System.out.println(" * I'm a triangle: " + t);
               case Polygon py -> System.out.println(" * I'm a polygon: " + py);
               default ->
                    System.out.println(" * Form unknown");
            }
        }
    }

}