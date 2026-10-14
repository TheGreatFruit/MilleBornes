package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.Limite;

public class ZoneDeJeu {
	private final List<Limite> pileLimites = new ArrayList<>();
	private final List<Bataille> pileBataille = new ArrayList<>();
	private final List<Borne> collectionBornes = new ArrayList<>();	
	
	public List<Limite> getPileLimites() {
		return pileLimites;
	}
	
	public List<Bataille> getPileBataille() {
		return pileBataille;
	}
	
	public List<Borne> getCollectionBornes() {
		return collectionBornes;
	}
}
