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
	public static boolean contientVille(String ville, List<String> villes) {
		for (var v: villes) {
			if (v.equals(ville)) {
				return true;
			}
		}
		return false;
	}
	
	// rechercherVille(ville, listeVilles) => index / -1 (not found)
	public static int rechercheVille(String ville, List<String> villes) {
		for (int i=0; i<villes.size(); i++) {
			if (villes.get(i).equals(ville)) {
				return i;
			}
		}
		return -1;
	}

}
