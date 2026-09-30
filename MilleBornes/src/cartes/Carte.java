package cartes;

public abstract class Carte {

	public boolean equals(Object obj) {
		if(obj.getClass()==this.getClass()) {
			return true;
		}
		return false;
	}
}
