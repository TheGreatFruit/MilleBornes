package jeu;

import java.util.Objects;

import cartes.Carte;

public class Joueur {
	private final String nom;
	private final ZoneDeJeu zoneJoueur;
	private final MainJoueur mainJoueur;
	
	public Joueur(String nom) {
		this.nom = nom;
		this.zoneJoueur = new ZoneDeJeu();
		this.mainJoueur = new MainJoueur();
	}

	public String getNom() {
		return nom;
	}

	public ZoneDeJeu getZoneJoueur() {
		return zoneJoueur;
	}

	

	public MainJoueur getMainJoueur() {
		return mainJoueur;
	}

	@Override
	public String toString() {
		return nom;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		Joueur autre = (Joueur) obj;
		return Objects.equals(nom, autre.nom);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}
	
	private void donner(Carte carte) {
		mainJoueur.prendre(carte);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		if(sabot.estVide()) {
			return null;
		}
		Carte carte = sabot.piocher();
		donner(carte);
		return carte;
	}
	
}
