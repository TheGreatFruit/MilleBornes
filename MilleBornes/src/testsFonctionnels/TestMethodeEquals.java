package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;
import cartes.Type;

public class TestMethodeEquals {
	public static void main(String[] args) {
		Carte carte25Bornes1 = new Borne(25);
		Carte carte25Bornes2 = new Borne(25);
		Carte carte50Bornes = new Borne(25);
		System.out.println("Deux cartes de 25km sont identiques ? " + carte25Bornes1.equals(carte25Bornes2));
		System.out.println("La carte 25km et 50km sont identiques ? " + carte25Bornes1.equals(carte50Bornes));

		
		Carte carteFeuxRouge1 = new Attaque(Type.FEU);
		Carte carteFeuxRouge2 = new Attaque(Type.FEU);
		System.out.println("Deux cartes de feux rouge sont identiques ? " + carteFeuxRouge1.equals(carteFeuxRouge2));
		
		Carte carteFeuxVert = new Parade(Type.FEU);
		System.out.println("La carte feu rouge et la carte feu vert sont identiques ? " + carteFeuxRouge1.equals(carteFeuxVert));
		Carte carteParNotFeu = new Parade(Type.ACCIDENT);
		System.out.println("La carte feu vert et la carte reparations sont identiques ? " + carteFeuxVert.equals(carteParNotFeu));
		Carte carteLimite = new DebutLimite();
		Carte carteLimite2 = new DebutLimite();
		Carte carteFinLimite = new FinLimite();
		Carte carteFinLimite2 = new FinLimite();
		System.out.println("La carte debutLimite et la carte finLimite sont identiques ? " + carteLimite.equals(carteFinLimite));
		System.out.println("Deux cartes debutLimite sont identiques ? " + carteLimite.equals(carteLimite2));
		System.out.println("Deux cartes finLimite sont identiques ? " + carteFinLimite.equals(carteFinLimite2));
	}
}
