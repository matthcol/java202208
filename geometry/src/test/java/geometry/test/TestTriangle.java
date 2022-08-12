package geometry.test;

import geometry.Point;
import geometry.Triangle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class TestTriangle {

    static Triangle triangle345;

    @BeforeAll
    static void initData() {
        triangle345 = new Triangle("T",
                new Point("A", 1, 2),
                new Point("B", 4, 2),
                new Point("C", 1, 6)
        );
    }

    @Test
    void testAllEdges() {
        // check edges are 3, 4, 5
        assertAll(
                IntStream.of(3,4,5)
                        .mapToObj(v -> () -> assertTrue(
                                triangle345.allEdges()
                                        .anyMatch(e -> e == v),
                                ""+v)
                        )
        );
    }

    @Test
    void testPerimeter() {
        double p = triangle345.perimeter();
        assertEquals(12, p);
    }

    @Test
    void testSurface() {
        double s = triangle345.surface();
        assertEquals(6, s);
    }
}