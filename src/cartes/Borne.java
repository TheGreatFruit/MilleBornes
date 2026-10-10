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
	
	@Override
	public boolean equals(Object obj) {
	    return super.equals(obj) && km == ((Borne) obj).km;
	}
}
