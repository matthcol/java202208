package learn.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * apprendre à gérer du texte en Java
 *
 */
class TestTexte {

    @Test
    void testAffichage() {
    	// afficher du texte sur la console
        System.out.println("Je fais du Java");
    }
    
    @Test
    void testVariable() {
    	// declaration de variable avec initialisation
    	String ville = "Paris";
    	// affichage de la variable
    	System.out.println(ville);
    	// affectation de nouvelle valeur à la variable
    	ville = "Pau";
    	System.out.println(ville);
    	// affichage avec concaténation
    	System.out.println("Je vais à " + ville);
    }
    
    @Test
    void testExoVariable() {
    	// 3 variables ville1, ville2 et message
    	// ville1 : Paris
    	// ville2 : Pau
    	// message sera de la forme : Paris - Pau
    	// afficher le message
    }
    
}