package geometry.test;

import geometry.Circle;
import geometry.Form;
import geometry.Point;
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
        List<Form> forms = List.of(f1, f2);
        System.out.println(forms);
    }

}