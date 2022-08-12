package geometry.test;

import geometry.Point;
import geometry.Polygon;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TestPolygon {
    static Polygon polygon;

    @BeforeAll
    static void initData() {
        polygon = new Polygon("P",
                new Point("A", 1, 2),
                new Point("B", 1, 6),
                new Point("C", 5, 9),
                new Point("D", 5, 2)
        );
    }

    @Test
    void testAllEdges() {
        // check edges are 4x2, 5, 7
        assertAll(
                Map.of(4,2L,5,1L,7,1L)
                        .entrySet()
                        .stream()
                        .map(es -> () -> assertEquals(
                                es.getValue(),
                                polygon.allEdges()
                                        .peek(System.out::println)
                                        .filter(e -> e == es.getKey())
                                        .count(),
                                ""+es.getKey())));
    }

    @Test
    void testPerimeter() {
        double p = polygon.perimeter();
        assertEquals(20, p);
    }

    @Test
    void testSurface() {
        double s = polygon.surface();
        assertEquals(22, s);
    }
}