package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import jdk.jfr.Frequency;

public class GestionCartes {

	public static <T> T extraire(List<T> liste) {
		Random random = new Random();
		int randomIndex = random.nextInt(liste.size());
		return liste.remove(randomIndex);
	}

	public static <T> T extraire2(List<T> liste) {
		Random random = new Random();
		int randomIndex = random.nextInt(liste.size());

		ListIterator<T> iterateur = liste.listIterator();
		for (int i = 0; i < randomIndex; i++) {
			iterateur.next();
		}

		T elem = iterateur.next();
		iterateur.remove();
		return elem;
	}

	public static <T> List<T> melanger(List<T> liste) {
		List<T> pioche = new ArrayList<>();
		while(! liste.isEmpty()) {
			pioche.add(extraire(liste));
		}
		
		return pioche;
	}

	public static <T> boolean verifierMelange(List<T> listeAvant, List<T> listeMelangee) {
		if (listeAvant.size() != listeMelangee.size()) {
			return false;
		}
		
		int nbAv, nbAp;
		for(T element : listeAvant) {
			if(Collections.frequency(listeAvant, element) != Collections.frequency(listeMelangee, element)) {
				return false;
			}
		}
		return true;
	}
	
	public static <T> List<T> rassembler(List<T> liste) {
	    List<T> resultat = new ArrayList<>();
	    for (T element : liste) {
	        if (!resultat.contains(element)) {
	            int nb = Collections.frequency(liste, element);
	            for (int i = 0; i < nb; i++) {
	                resultat.add(element);
	            }
	        }
	    }
	    return resultat;
	}
	
	
	public static <T> List<T> rassemblerV2(List<T> liste) {
	    List<T> source = new ArrayList<>(liste);   // copie pour ne pas détruire l'argument
	    List<T> resultat = new ArrayList<>();
	    while (!source.isEmpty()) {
	        T courant = source.get(0);
	        Iterator<T> it = source.iterator();
	        while (it.hasNext()) {
	            T element = it.next();
	            if (element.equals(courant)) {
	                resultat.add(element);
	                it.remove();
	            }
	        }
	    }
	    return resultat;
	}
	
	
	public static <T> boolean verifierRassemblement(List<T> liste) {
	    ListIterator<T> it1 = liste.listIterator();
	    if (!it1.hasNext()) {
	        return true;
	    }
	    
	    T precedent = it1.next();
	    
	    while (it1.hasNext()) {
	    	
	        T courant = it1.next();
	        if (!courant.equals(precedent)) {

	            ListIterator<T> it2 = liste.listIterator(it1.previousIndex());
	            while (it2.hasNext()) {
	                if (it2.next().equals(precedent)) {
	                    return false;
	                }
	            }
	            precedent = courant;
	        }
	    }
	    return true;
	}
	
	
	
}



