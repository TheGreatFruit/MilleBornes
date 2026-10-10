package utils;

import java.util.List;
import java.util.ListIterator;
import java.util.Random;

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
		for(int i =0; i<randomIndex; i++) {
			iterateur.next();
		}
		T elem = iterateur.next();
		iterateur.remove();
		return elem;
		
		
	}
	
	
	
}
