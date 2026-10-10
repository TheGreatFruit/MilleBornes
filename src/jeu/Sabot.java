package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {
	int nbOp = 0;
	Carte[] jeu;
	int nbCartes;

	public Sabot(Carte[] jeu) {
		this.jeu = jeu;
		this.nbCartes = jeu.length;
	}

	public boolean estVide() {
		return nbCartes == 0;
	}

	public void ajouterCarte(Carte newCard) {
		if (nbCartes >= jeu.length) {
			throw new IllegalStateException("Le sabot est plein");
		}

		jeu[nbCartes] = newCard;
		nbCartes++;
		nbOp++;
	}

	public Carte piocher() {
		Iterator<Carte> iteration = iterator();
		Carte carte = iteration.next();
		iteration.remove();
		return carte;
	}

	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}

	private class Iterateur implements Iterator<Carte> {
		int iter = 0;
		boolean nextEffectue = false;
		int nbOpRef = nbOp;

		@Override
		public boolean hasNext() {
			return iter < nbCartes;
		}

		private void verificationConcurrence() {
			if (nbOp != nbOpRef)
				throw new ConcurrentModificationException();
		}

		@Override
		public Carte next() {
			verificationConcurrence();
			if (!hasNext()) {
				throw new NoSuchElementException();
			} else {
				Carte carte = jeu[iter];
				iter++;
				nextEffectue = true;

				return carte;
			}
		}

		@Override
		public void remove() {
			verificationConcurrence();

			if (!nextEffectue) {
				throw new IllegalStateException();
			}

			for (int i = iter - 1; i < nbCartes - 1; i++) {
				jeu[i] = jeu[i + 1];
			}

			jeu[nbCartes - 1] = null;

			nbCartes--;
			nbOp++;
			nbOpRef++;

			nextEffectue = false;
			iter--;
		}

	}

}
