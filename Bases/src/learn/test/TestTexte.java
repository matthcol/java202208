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
    
    @Test
    void testEgalite() {
    	String ville1 = "Paris";
    	String ville2 = "Pau";
    	String ville3 = "Paris";
    	String ville4 = "Pa"+"ris";
    	// résultats cohérents :
    	System.out.println(ville1 == ville2);
    	System.out.println(ville1 == ville1);
    	System.out.println(ville1 == ville3);
    	System.out.println(ville1 == ville4);
    	// résultats incohérents
    	String ville5 = ville1.substring(0,3) 
    			+ ville3.substring(3);
    	System.out.println("V5 : " + ville5);
    	System.out.println(ville1 == ville5); // false
    	// utiliser equals pour contenu
    	System.out.println(ville1.equals(ville5)); // true
    }
    
    @Test
    void testOrdre() {
    	String ville1 = "Paris";
    	String ville2 = "Pau";
    	// boolean test = ville1 < ville2; // ne compile pas
    	// voir Comparator, Comparable
    }
    
}