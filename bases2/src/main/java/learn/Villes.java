package learn;

import java.util.List;

public class Villes {
	/**
	 * met à jour la liste de ville
	 * @param villes liste modifiable à mettre à jour
	 * @throws java.lang.UnsupportedOperationException 
	 * si la liste est non modifiable
	 */
	public static void updateVilles(List<String> villes) {
		villes.add("Pau");
		villes.add("Toulouse");
		villes.add(0, "Paris");
	}
	
	// fonction de recherche
	// contientVille(ville, listeVilles) => true/false
	// rechercherVille(ville, listeVilles) => index / -1 (not found)
	

}
