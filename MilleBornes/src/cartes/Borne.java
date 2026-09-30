package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(int km) {
		super();
		this.km = km;
	}
	
	@Override
	public String toString() {
		return getKm() + "KM";
	}

	public int getKm() {
		return km;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Borne borne) {
			return km==borne.getKm();
		}
		return false;
	}
}
