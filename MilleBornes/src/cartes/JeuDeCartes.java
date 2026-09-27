package cartes;

public class JeuDeCartes {
	Configuration[] typesDeCartes = {
			new Configuration(new Borne(25), 10),
			new Configuration(new Borne(50), 10),
			new Configuration(new Borne(75), 10),
			new Configuration(new Borne(100), 12),
			new Configuration(new Borne(200), 4),
			new Configuration(new Parade(Type.FEU), 14),
			new Configuration(new FinLimite(), 6),
			new Configuration(new Parade(Type.ESSENCE), 6),
			new Configuration(new Parade(Type.CREVAISON), 6),
			new Configuration(new Parade(Type.ACCIDENT), 6),
			new Configuration(new Attaque(Type.FEU), 5),
			new Configuration(new DebutLimite(), 4),
			new Configuration(new Attaque(Type.ESSENCE), 3),
			new Configuration(new Attaque(Type.CREVAISON), 3),
			new Configuration(new Attaque(Type.ACCIDENT), 3),
			new Configuration(new Botte(Type.FEU), 1),
			new Configuration(new Botte(Type.ESSENCE), 1),
			new Configuration(new Botte(Type.CREVAISON), 1),
			new Configuration(new Botte(Type.ACCIDENT), 1),	
	};
	
	public String affichageJeuDeCartes() {
		StringBuilder affichage = new StringBuilder();
		/*Carte[] jeu = donnerCartes();*/
		for(int i=0; i<typesDeCartes.length; i++) {
			affichage.append(typesDeCartes[i].getNbExemplaires());
			affichage.append(" ");
			affichage.append(typesDeCartes[i].getCarte());
			affichage.append("\n");
		}
		return affichage.toString();
	}
	
	public Carte[] donnerCartes() {
		int taille = 0;
		int idx = 0;
		
		for(int i=0;i<typesDeCartes.length; i++) {
			taille += typesDeCartes[i].nbExemplaires;
		}
		Carte[] jeu = new Carte[taille];
		for(int i=0; i < typesDeCartes.length; i++) {
			for(int j = 0; j < typesDeCartes[i].getNbExemplaires(); j++) {
				jeu[idx] = typesDeCartes[i].getCarte();
				idx++;
			}
		}
		return jeu;
	}
	
	public boolean checkCount() {
	    Carte[] jeu = donnerCartes();

	    int nombreAttendu = 0;

	    for (Configuration configuration : typesDeCartes) {
	        nombreAttendu += configuration.getNbExemplaires();
	    }

	    return jeu.length == nombreAttendu;
	}
	
	private static class Configuration {
		Carte carte;
		private int nbExemplaires;
		

		public Configuration(Carte carte, int nbExemplaires) {
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}
		
		public Carte getCarte() {
			return carte;
		}
	}
	
}
