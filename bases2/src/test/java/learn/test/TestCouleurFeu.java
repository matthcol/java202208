package learn.test;

import learn.CouleurFeu;
import org.junit.jupiter.api.Test;

class TestCouleurFeu {

    @Test
    void testEnum1() {
        CouleurFeu couleur = CouleurFeu.ORANGE;
        System.out.println(couleur); // toString
        couleur = CouleurFeu.valueOf("ROUGE");
        System.out.println(couleur);
        for (CouleurFeu c: CouleurFeu.values()) {
            System.out.println(" - " + c
                    + " ; ordinal: " + c.ordinal()
                    + " ; toString: " + c.toString()
                    + " ; name: " + c.name()
                    + " ; delai: " + c.getDelai()
                    + " ; compute: " + c.compute(4)
            );
        }
        // !!!!!
        couleur = null;
    }

}